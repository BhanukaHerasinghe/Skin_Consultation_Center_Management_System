package com.company;

import java.time.LocalDate;
import java.util.Base64;

public class Consultation {
    private LocalDate consultDate;
    private String consultTimeSlot;
    private String consultCost;
    private String consultNotes;
    private Doctor doctor;
    private Patient patient;

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public String getConsultTimeSlot() {
        return consultTimeSlot;
    }

    public void setConsultTimeSlot(String consultTimeSlot) {
        this.consultTimeSlot = consultTimeSlot;
    }

    public String getConsultCost() {
        return consultCost;
    }

    public void setConsultCost(String consultCost) {
        this.consultCost = consultCost;
    }

    public String getConsultNotes() {
        return consultNotes;
    }

    public void setConsultNotes(String consultNotes) {
        this.consultNotes = consultNotes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        byte[] decodedBytes = Base64.getDecoder().decode(consultNotes);
        String notes = new String(decodedBytes);
        return "----Consultation----\n" +
                "consultDate=" + consultDate + "\n" +
                "consultTimeSlot='" + consultTimeSlot + '\'' + "\n" +
                "consultCost='" + consultCost + '\'' + "\n" +
                "consultNotes='" + notes + '\'' + "\n" +
                "doctor=" + doctor + "\n" +
                "patient=" + patient ;
    }

}
