package com.novocare.controller;

import com.novocare.model.MedicalHistory;
import com.novocare.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-histories")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @GetMapping("/{patientId}")
    public List<MedicalHistory> getHistoryByPatient(@PathVariable Long patientId) {
        // This will allow us to fetch history for a specific patient
        return medicalHistoryRepository.findAll().stream()
                .filter(h -> h.getPatientId().equals(patientId))
                .toList();
    }

    @PostMapping("/add")
    public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory history) {
        return medicalHistoryRepository.save(history);
    }
}
