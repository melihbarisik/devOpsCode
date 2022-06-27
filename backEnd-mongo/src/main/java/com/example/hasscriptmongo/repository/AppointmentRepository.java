package com.example.hasscriptmongo.repository;

import com.example.hasscriptmongo.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends MongoRepository<Appointment,Long> {

    Appointment findById(String id);
    List<Appointment> findByUserId(String userId);
}
