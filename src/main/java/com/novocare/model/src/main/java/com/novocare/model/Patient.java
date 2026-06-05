package com.novocare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId; // Unique identifier[cite: 1]

    @Column(nullable = false)
    private String name; // Must not be null[cite: 1]

    @Column(nullable = false)
    private String phone; // Must be valid phone format[cite: 1]

    @Column(columnDefinition = "TEXT")
    private String address; // Patient address[cite: 1]

    public Patient() {}

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
