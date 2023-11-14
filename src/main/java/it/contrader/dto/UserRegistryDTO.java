package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistryDTO {

    private Long id;

    private String name;

    private String surname;

    private String address;

    private String birthdate;

    private Long userId;

}