package com.example.clinicsystem.models.entities;

import com.example.clinicsystem.utils.BooleanToStringConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduling")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctorId;

    @Column(name = "scheduling_date", nullable = false)
    private LocalDateTime schedulingDate;

    @Convert(converter = BooleanToStringConverter.class)
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public Scheduling() {

    }

    public Scheduling(Patient patientId, Doctor doctorId, LocalDateTime schedulingDate, Boolean status, String notes) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.schedulingDate = schedulingDate;
        this.status = status;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(LocalDateTime schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
