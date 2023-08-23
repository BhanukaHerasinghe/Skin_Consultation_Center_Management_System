package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    private Scanner scanner = new Scanner(System.in);
    private static final int DOCTOR_ARRAY = 10;

    public void initializeArr(Doctor[] emp_doctors) {
        Arrays.fill(emp_doctors, new Doctor());
    }

    @Override
    public void addDoctor(Doctor[] emp_doctors) {
        Doctor doctor = new Doctor();

        System.out.println("Enter Doctor name : ");
        String name = scanner.next();

        System.out.println("Enter Doctor surname : ");
        String surname = scanner.next();

        System.out.println("Enter Doctor specialisation (Surgical/Radiology/Medical/internal/Facial) : ");
        String specialisation = scanner.next();
        specialisation = specialisation + " Dermatology";

        System.out.println("Enter Doctor medical licence ID : ");
        String medicallicenceId = scanner.next();

        System.out.println("Enter Doctor Date of birth : ");
        String date_of_birth = scanner.next();

        System.out.println("Enter Doctor mobile number : ");
        int mobile_number = scanner.nextInt();

        doctor.setName(name);
        doctor.setSurname(surname);
        doctor.setSpecialisation(specialisation);
        doctor.setMedicallicenceId(medicallicenceId);
        doctor.setDate_of_birth(LocalDate.parse(date_of_birth));
        doctor.setMobile_number(mobile_number);


        boolean isArrayFull = false;
        for (int i = 0; i < emp_doctors.length; i++) {
            if (emp_doctors[i].getName() == null) {
                emp_doctors[i] = doctor;
                break;
            } else {
                isArrayFull = true;
            }
        }

        if(isArrayFull) {
            System.out.println("The doctor array is full ");
        }

    }


    @Override
    public void deleteDoctor(Doctor[] emp_doctors) {
        System.out.println("Enter Doctor medical licence number :");
        String deleteDoctor = scanner.next();
        boolean isDeleted = false;

        for (int i = 0; i < DOCTOR_ARRAY; i++) {
            if (emp_doctors[i].getMedicallicenceId().equals(deleteDoctor)) {
                System.out.println("Removed doctor " + emp_doctors[i].getName() + " from the medical center");
                emp_doctors[i] = new Doctor();
                isDeleted = true;
                System.out.println("Available doctor count is " + getAvailableDoctorCount(emp_doctors));
                return;
            }
        }

        if (!isDeleted) {
            System.out.println("Medical licence ID " + deleteDoctor + " is not found.");
        }

    }

    private int getAvailableDoctorCount(Doctor[] emp_doctors) {
        int doctorCount = 0;
        for(int i = 0;i < emp_doctors.length; i++){
            if(emp_doctors[i].getName() != null) {
                doctorCount++;
            }
        }
        return doctorCount;
    }

    @Override
    public void printListOfAllDoctors(Doctor[] emp_doctors) {
        Doctor[] tempDocList = new Doctor[DOCTOR_ARRAY];
        System.arraycopy(emp_doctors, 0, tempDocList, 0, emp_doctors.length);
        Doctor temp;
        for (int i = 0; i < emp_doctors.length; i++) {
            for (int j = i + 1; j < emp_doctors.length; j++) {
                if(tempDocList[i].getName() != null && tempDocList[j].getName() != null) {
                    if (tempDocList[i].getSurname().compareTo(tempDocList[j].getSurname()) > 0) {
                        // swapping
                        temp = tempDocList[i];
                        tempDocList[i] = tempDocList[j];
                        tempDocList[j] = temp;
                    }
                }
            }
        }

        System.out.println("The names in alphabetical order are: ");
        for (int i = 0; i < emp_doctors.length; i++) {
            if (tempDocList[i] != null) {
                System.out.println(tempDocList[i]);
            }
        }

    }

    @Override
    public void storeDataToFile(Doctor[] emp_doctors) {
        try {
            FileWriter myWriter = new FileWriter("doctorsn.txt");
            for (int i = 0; i < DOCTOR_ARRAY; i++) {
                if(emp_doctors[i].getName() != null){
                    myWriter.write(emp_doctors[i].getName() + " "
                            +emp_doctors[i].getSurname() + " "
                            +emp_doctors[i].getMedicallicenceId() + " "
                            + emp_doctors[i].getSpecialisation() + " "
                            + emp_doctors[i].getMobile_number() + " "
                            + emp_doctors[i].getDate_of_birth() + "\n"
                    );
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    @Override
    public void loadDataFromFile(Doctor[] emp_doctors) {

        try {
            File inputFile = new File("doctorsn.txt");
            Scanner rf = new Scanner(inputFile);
            String fileline;
            int i = 0;
            while (rf.hasNextLine()) {
                fileline = rf.nextLine();
                String[] tmp = fileline.split(" ");
                Doctor doctor = new Doctor();
                doctor.setName(tmp[0]);
                doctor.setSurname(tmp[1]);
                doctor.setMedicallicenceId(tmp[2]);
                doctor.setSpecialisation(tmp[3] + " "+tmp[4]);
                doctor.setMobile_number(Integer.parseInt(tmp[5]));
                doctor.setDate_of_birth(LocalDate.parse(tmp[6]));
                emp_doctors[i] = doctor;
                i++;
            }
            rf.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
}
