package com.company;

public class Patient extends Person {
    private int patientId;

    public Patient(){
        super();
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }
}
