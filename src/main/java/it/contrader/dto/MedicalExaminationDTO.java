package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MedicalExaminationDTO {

    private long id;

    private String typology;

    private double cost;

    private long code;

    private String img;

}