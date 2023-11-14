package it.contrader.converter;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.model.MedicalExamination;
import org.springframework.stereotype.Component;

@Component
public class MedicalExaminationConverter extends AbstractConverter<MedicalExamination, MedicalExaminationDTO> {
    @Override
    public MedicalExamination toEntity(MedicalExaminationDTO medicalExaminationDTO) {
        MedicalExamination medicalExamination = null;
        if (medicalExaminationDTO != null) {
            medicalExamination = new MedicalExamination(medicalExaminationDTO.getId(),medicalExaminationDTO.getTypology(),medicalExaminationDTO.getCost(),medicalExaminationDTO.getCode(),medicalExaminationDTO.getImg());
        }
        return medicalExamination;
    }

    @Override
    public MedicalExaminationDTO toDTO(MedicalExamination medicalExamination) {
        MedicalExaminationDTO medicalExaminationDTO = null;
        if (medicalExamination != null) {
            medicalExaminationDTO = new MedicalExaminationDTO(medicalExamination.getId(),medicalExamination.getTypology(),medicalExamination.getCost(),medicalExamination.getCode(),medicalExamination.getImg());
        }
        return medicalExaminationDTO;
    }
}