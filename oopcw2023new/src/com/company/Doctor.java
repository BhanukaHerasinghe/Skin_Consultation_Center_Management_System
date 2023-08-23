package com.company;

public class Doctor extends Person {
    private String specialisation;
    private String medicallicenceId;

    public Doctor() {
        super();
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void setMedicallicenceId(String medicallicenceId) {
        this.medicallicenceId = medicallicenceId;
    }

    public String getMedicallicenceId() {
        return medicallicenceId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Name='" + super.getName() + '\'' +
                ", Surname='" + super.getSurname() + '\'' +
                ", Date_of_birth='" + super.getDate_of_birth() + '\'' +
                ", Specialisation='" + specialisation + '\'' +
                ", Medical_Licence_Id='" + medicallicenceId + '\'' +
                ", Mobile_Number='" + super.getMobile_number() + '\'' +
                '}';
    }

}
