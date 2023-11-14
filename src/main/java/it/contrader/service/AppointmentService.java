package it.contrader.service;

import it.contrader.converter.AppointmentConverter;
import it.contrader.dao.AppointmentRepository;
import it.contrader.dto.AppointmentDTO;
import it.contrader.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends AbstractService<Appointment, AppointmentDTO>{

    @Autowired
    private AppointmentConverter converter;

    @Autowired
    private AppointmentRepository repository;
}