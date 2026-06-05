package com.novocare.service;

import com.novocare.model.Appointment;
import com.novocare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public String bookAppointment(Appointment appointment) {
        // Logic: find all appointments for that date and check for conflicts
        List<Appointment> existing = appointmentRepository.findByDate(appointment.getDate());
        
        for (Appointment a : existing) {
            if (a.getTime().equals(appointment.getTime())) {
                return "Error: Time slot already booked!";
            }
        }
        
        appointmentRepository.save(appointment);
        return "Appointment successfully booked!";
    }
}
