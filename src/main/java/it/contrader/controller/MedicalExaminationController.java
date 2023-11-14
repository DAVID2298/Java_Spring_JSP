package it.contrader.controller;

import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/medicalExamination")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService service;


    @GetMapping("/getall")
    public String getAll(HttpServletRequest request) {
        setAll(request);
        return "visits";
    }

    @GetMapping("/getvisite")
    public String getAllVisite(HttpServletRequest request) {
        setAll(request);
        return "visite";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
        MedicalExaminationDTO medicalExaminationDTO=service.read(id);
        medicalExaminationDTO.setCode(0);
        medicalExaminationDTO.setCost(0);
        medicalExaminationDTO.setTypology(null);
        medicalExaminationDTO.setImg(null);
//		service.delete(id);
        service.update(medicalExaminationDTO);
        setAll(request);
        return "admin";
    }

    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.setAttribute("dto", service.read(id));
        return "modvisita";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam ("typology") String typology,
                         @RequestParam("cost") double cost, @RequestParam("code") long code) {

        MedicalExaminationDTO dto = new MedicalExaminationDTO();
        dto.setId(id);
        dto.setTypology(typology);
        dto.setCost(cost);
        dto.setCode(code);
        service.update(dto);
        setAll(request);
        return "visits";
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request, @RequestParam ("typology") String typology,
                         @RequestParam("cost") double cost, @RequestParam("code") long code ) {
        MedicalExaminationDTO dto = new MedicalExaminationDTO();
        dto.setTypology(typology);
        dto.setCost(cost);
        dto.setCode(code);
        service.update(dto);
        setAll(request);
        return "visits";
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
        request.setAttribute("dto", service.read(id));
        return "dettaglio";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    void AppointmentDTO (HttpServletRequest request) {
        AppointmentDTO appointmentDTO = (AppointmentDTO) request.getAttribute("app");
    }




    private void setAll(HttpServletRequest request) {
        request.setAttribute("list", service.getAll());


    }


}