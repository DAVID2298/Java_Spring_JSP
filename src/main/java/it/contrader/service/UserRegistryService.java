package it.contrader.service;

import it.contrader.converter.UserRegistryConverter;
import it.contrader.dao.UserRegistryRepository;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryService extends AbstractService<UserRegistry, UserRegistryDTO>{


    @Autowired
    private UserRegistryConverter converter;
    @Autowired
    private UserRegistryRepository repository;



    public UserRegistryDTO findById_user(Long userId){
        return converter.toDTO(repository.findByUserId(userId));
    }

//    public UserRegistryDTO updateUserRegistry(Long userdId){
//        return converter.toDTO(repository.updateUserRegistry(userdId));
//    }

}