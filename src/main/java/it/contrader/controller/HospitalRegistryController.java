package it.contrader.controller;


import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.service.HospitalRegistryService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import static java.util.Arrays.setAll;

@Controller
@RequestMapping("/hospital")
public class HospitalRegistryController {

    @Autowired
    private HospitalRegistryService service;
    @Autowired
    private UserService userService;


//    @GetMapping("/read")
//    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
//        request.getSession().setAttribute("dto", service.read(id));
//        return "";
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request,
                         @RequestParam("name") String name,
                         @RequestParam("address") String address,
                         @RequestParam("nation") String nation,
                         @RequestParam("province") String province,
                         @RequestParam("city") String city,
                         @RequestParam("description") String description){


        UserDTO user= (UserDTO) request.getSession().getAttribute("user");

        HospitalRegistryDTO dto = new HospitalRegistryDTO();

        dto.setName(name);
        dto.setAddress(address);
        dto.setNation(nation);
        dto.setProvince(province);
        dto.setCity(city);
        dto.setDescription(description);
        dto.setUserId(user.getId());
        service.insert(dto);
        setAll(request);
        return "index";
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id")Long id){

        HospitalRegistryDTO hospitalRegistryDTO= service.findByIdUser(id);
        request.setAttribute("hospitalRegistryDTO", hospitalRegistryDTO);
        return "hospitalReg";
    }

    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.setAttribute("hospitalRegistryDTO", service.read(id));
        return "HospitalRegistry";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request,
                         @RequestParam("id") Long id,
                         @RequestParam("name") String name,
                         @RequestParam("address") String address,
                         @RequestParam("nation") String nation,
                         @RequestParam("province") String province,
                         @RequestParam("city") String city,
                         @RequestParam("description") String description){

        UserDTO user= (UserDTO) request.getSession().getAttribute("user");

        HospitalRegistryDTO dto = new HospitalRegistryDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setNation(nation);
        dto.setProvince(province);
        dto.setCity(city);
        dto.setDescription(description);
        dto.setUserId(user.getId());
        service.update(dto);
        setAll(request);
        return "admin";
    }

    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("list", service.getAll());
    }


}
