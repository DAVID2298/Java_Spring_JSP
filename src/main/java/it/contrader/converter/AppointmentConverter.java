package it.contrader.converter;

import it.contrader.dto.AppointmentDTO;

import it.contrader.model.Appointment;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter extends AbstractConverter<Appointment, AppointmentDTO>{

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @Autowired
    private MedicalExaminationConverter conv;

    @Autowired
    private MedicalExaminationService ser;

    @Override
    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = null;
        if (appointmentDTO != null){
            appointment = new Appointment(appointmentDTO.getId(),
                    appointmentDTO.getDate(),
                    appointmentDTO.getHour(),
                    appointmentDTO.getCost(),
                    converter.toEntity(service.read(appointmentDTO.getUserId())),
                    conv.toEntity(ser.read(appointmentDTO.getVisitaId())));
        }
        return appointment;
    }

    @Override
    public AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = null;
        if (appointment != null){
            appointmentDTO = new AppointmentDTO(appointment.getId(),
                    appointment.getDate(),
                    appointment.getHour(),
                    appointment.getCost(),
                    appointment.getUser().getId(),
                    appointment.getMedicalExamination().getId());
        }
        return appointmentDTO;
    }
}