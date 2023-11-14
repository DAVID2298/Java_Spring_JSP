package it.contrader.converter;

import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.User;
import it.contrader.service.HospitalRegistryService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospitalRegistryConverter extends AbstractConverter <HospitalRegistry, HospitalRegistryDTO>{

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @Override
    public HospitalRegistry toEntity(HospitalRegistryDTO hRDTO) {
        HospitalRegistry user = null;
        if (hRDTO != null) {
            user = new HospitalRegistry(hRDTO.getId(),
                    hRDTO.getName(),
                    hRDTO.getAddress(),
                    hRDTO.getNation(),
                    hRDTO.getProvince(),
                    hRDTO.getCity() ,
                    hRDTO.getDescription(),
                    converter.toEntity(service.read(hRDTO.getUserId())));
        }
        return user;
    }

    @Override
    public HospitalRegistryDTO toDTO(HospitalRegistry hospitalRegistry) {
        HospitalRegistryDTO hospitalRegistryDTO = null;
        if (hospitalRegistry != null) {
            hospitalRegistryDTO = new HospitalRegistryDTO(hospitalRegistry.getId(),
                    hospitalRegistry.getName(),
                    hospitalRegistry.getAddress(),
                    hospitalRegistry.getNation(),
                    hospitalRegistry.getProvince(),
                    hospitalRegistry.getCity(),
                    hospitalRegistry.getDescription(),
                    hospitalRegistry.getUser().getId());


        }
        return hospitalRegistryDTO;
    }
}
