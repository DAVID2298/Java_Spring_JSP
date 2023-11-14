package it.contrader.converter;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

@Component
public class UserRegistryConverter extends AbstractConverter<UserRegistry, UserRegistryDTO> {

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;
    @Override
    public UserRegistry toEntity(UserRegistryDTO userRegistryDTO) {
        UserRegistry userRegistry = null;
        if (userRegistryDTO != null) {
            userRegistry = new UserRegistry(userRegistryDTO.getId(),
                    userRegistryDTO.getName(),
                    userRegistryDTO.getSurname(),
                    userRegistryDTO.getAddress(),
                    userRegistryDTO.getBirthdate(),
                    converter.toEntity(service.read(userRegistryDTO.getUserId())));


        }
        return userRegistry;
    }

    @Override
    public UserRegistryDTO toDTO(UserRegistry userRegistry) {
        UserRegistryDTO userRegistryDTO = null;
        if (userRegistry != null) {
            userRegistryDTO = new UserRegistryDTO(userRegistry.getId(),
                    userRegistry.getName(),
                    userRegistry.getSurname(),
                    userRegistry.getAddress(),
                    userRegistry.getBirthdate(),
                    userRegistry.getUser().getId());

        }
        return userRegistryDTO;
    }
}