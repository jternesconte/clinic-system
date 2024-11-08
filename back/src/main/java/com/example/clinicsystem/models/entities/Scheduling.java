package com.example.clinicsystem.models.entities;

import com.example.clinicsystem.utils.BooleanToStringConverter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate schedulingDate;

    @Column(name = "scheduling_time", nullable = false)
    private LocalTime schedulingTime;

    @Convert(converter = BooleanToStringConverter.class)
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public Scheduling() {

    }

    public Scheduling(Patient patientId, Doctor doctorId, LocalDate schedulingDate, LocalTime schedulingTime, Boolean status, String notes) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.schedulingDate = schedulingDate;
        this.schedulingTime = schedulingTime;
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

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(LocalDate schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public LocalTime getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(LocalTime schedulingTime) {
        this.schedulingTime = schedulingTime;
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
