package it.contrader.service;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.HospitalRegistryRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalRegistryService extends AbstractService<HospitalRegistry, HospitalRegistryDTO> {

    @Autowired
    private HospitalRegistryConverter converter;
    @Autowired
    private HospitalRegistryRepository repository;


    public HospitalRegistryDTO findByIdUser(Long userId){
        return converter.toDTO(repository.findByUserId(userId));
    }

//
//    public HospitalRegistryDTO findByHRegistryString (String name,String address, String nation, String province, String city, String description, int userId) {
//        return converter.toDTO(repository.findByHRegistry(name, address, nation, province,city, description,userId));
//    }



}
