package com.example.hasscriptmongo.service;
import com.example.hasscriptmongo.dto.AppointmentDto;
import com.example.hasscriptmongo.model.Appointment;
import com.example.hasscriptmongo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    public Appointment addAppointment(AppointmentDto appointmentDto){
        Appointment existAppointment=appointmentRepository.findById(appointmentDto.getUserId());
        if(Objects.nonNull(existAppointment)){
            throw new RuntimeException("Appointment exist");
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Appointment newAppointment=new Appointment();
        newAppointment.setId(UUID.randomUUID().toString());
        newAppointment.setUserId(appointmentDto.getUserId());
        newAppointment.setCityName(appointmentDto.getCityName());
        newAppointment.setHospitalName(appointmentDto.getHospitalName());
        newAppointment.setDepartmentName(appointmentDto.getDepartmentName());
        newAppointment.setDoctorName(appointmentDto.getDoctorName());
        newAppointment.setDescription(appointmentDto.getDescription());
        newAppointment.setIsActive(true);
        newAppointment.setCreatedAt(sdf.format(date));
        return appointmentRepository.save(newAppointment);
    }
    public List<Appointment> findByUserId(String userId){
        return appointmentRepository.findByUserId(userId);
    }

    public Boolean deleteById(String id){
        Appointment appointment=appointmentRepository.findById(id);
            if (Objects.isNull(appointment)) {
                throw new RuntimeException("There is no such an appointment.");
            }
            appointmentRepository.delete(appointment);
        return true;
    }

    public Boolean patchById(String id,String description) {
        Appointment appointment=appointmentRepository.findById(id);
        appointment.setDescription(description);
        appointmentRepository.save(appointment);
        return true;
    }





}
