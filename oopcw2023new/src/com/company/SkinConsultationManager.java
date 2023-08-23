package com.company;

public interface SkinConsultationManager {
    public void addDoctor(Doctor[] emp_doctors);
    public void deleteDoctor(Doctor[] emp_doctors);
    public void printListOfAllDoctors(Doctor[] emp_doctors);
    public void storeDataToFile(Doctor[] emp_doctors);
    public void loadDataFromFile(Doctor[] emp_doctors);

}
