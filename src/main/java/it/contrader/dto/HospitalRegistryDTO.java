package it.contrader.dto;


import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HospitalRegistryDTO {

    private Long id;

    private String name;

    private String address;

    private String nation;

    private String province;

    private String city;

    private String description;

    private Long userId;

}
