package it.contrader.controller;


import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userregistry")
public class UserRegistryController {


    @Autowired
    private UserRegistryService service;


    @GetMapping("/getall")
    public String getAll(HttpServletRequest request){
        setAll(request);
        return "allUsers";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("userId") Long userId) {
        service.delete(userId);
        setAll(request);
        return "utente/allUsers";
    }

    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.setAttribute("userRegistryDTO", service.read(id));
        return "updateRegistry";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
                         @RequestParam("surname") String surname, @RequestParam("address") String address,
                         @RequestParam("birthdate") String birthdate){
        ;
//        UserRegistryDTO user= (UserRegistryDTO) request.getAttribute("userRegistryDTO");
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        UserRegistryDTO dto = new UserRegistryDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setSurname(surname);
        dto.setAddress(address);
        dto.setBirthdate(birthdate);
        dto.setUserId(user.getId());
        service.update(dto);
        setAll(request);
        if (user.getUsertype().equals("ADMIN")) {
            return "admin";
        }
        else {
            return "homeuser";
        }
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request,
                         @RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("address") String address,
                         @RequestParam("birthdate") String birthdate){

        UserDTO user= (UserDTO) request.getSession().getAttribute("user");

        System.out.println(user);

        UserRegistryDTO dto = new UserRegistryDTO();

        dto.setName(name);
        dto.setSurname(surname);
        dto.setAddress(address);
        dto.setBirthdate(birthdate);
        dto.setUserId(user.getId());
        service.insert(dto);
        setAll(request);
        if(user.getUsertype().equals("ADMIN")){
            return "registration2";
        }
        else{
            return "index";
        }

    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id")Long id){

        UserRegistryDTO userRegistryDTO= service.findById_user(id);
        request.setAttribute("userRegistryDTO", userRegistryDTO);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    private void setAll(HttpServletRequest request){
        request.setAttribute("list", service.getAll());
    }
}