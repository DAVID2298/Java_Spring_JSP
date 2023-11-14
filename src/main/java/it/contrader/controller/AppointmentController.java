package it.contrader.controller;


import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AppointmentService;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;
    @Autowired
    private UserService serv;
    @Autowired
    private MedicalExaminationService meserv;

    @GetMapping("/getall")
    public String getAll(HttpServletRequest request){
        setAll(request);
        return "storico";
    }

    @GetMapping("/getalladmin")
    public String getAllAdmin(HttpServletRequest request){
        setAll(request);
        return "prenotazioni";
    }

//    void UserDTO (HttpServletRequest request) {
//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
//    }
//
//    void MedicalExaminationDTO (HttpServletRequest request) {
//        MedicalExaminationDTO medicalExaminationDTO = (MedicalExaminationDTO) request.getAttribute("medto");
//    }


    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("id") Long id){
        service.delete(id);
        setAll(request);
        return "prenotazioni";
    }

    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id){
        request.setAttribute("dto", service.read(id));
        MedicalExaminationDTO medto = new MedicalExaminationDTO();
        request.getSession().setAttribute("medto", medto);
        return "modpren";
    }

    @PostMapping ("/update")
    public String update(HttpServletRequest request, @RequestParam("id") Long id,
                         @RequestParam("date") String date,
                         @RequestParam("hour") String hour,
                         @RequestParam("cost") Double cost,
                         @RequestParam("userId") Long userId,
                         @RequestParam("meid") Long meid)

    {

//        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");

        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(id);
        dto.setDate(date);
        dto.setHour(hour);
        dto.setCost(cost);
        dto.setUserId(userId);
        dto.setVisitaId(meid);


        service.update(dto);
        setAll(request);
        return "prenotazioni";
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request, @RequestParam("date") String date,
                         @RequestParam("hour") String hour,
                         @RequestParam("cost") Double cost,
                         @RequestParam("meid") Long meid) {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");

        AppointmentDTO dto = new AppointmentDTO();
        dto.setDate(date);
        dto.setHour(hour);
        dto.setCost(cost);
        dto.setUserId(userDTO.getId());
        dto.setVisitaId(meid);
        dto.setVisitaId(meid);
        service.update(dto);
        setAll(request);
        return "storico";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }


    private void setAll(HttpServletRequest request) {
        request.setAttribute("list", service.getAll());


    }
}