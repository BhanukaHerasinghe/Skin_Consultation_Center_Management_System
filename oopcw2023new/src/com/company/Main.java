package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final int DOCTOR_ARRAY = 10;
    private static Doctor[] emp_doctors = new Doctor[DOCTOR_ARRAY];

    public static void main(String[] args) {

        WestminsterSkinConsultationManager skin = new WestminsterSkinConsultationManager();
        skin.initializeArr(emp_doctors);
        skin.loadDataFromFile(emp_doctors);
        String selection;

        while (true) {
            selection = MenuData().toUpperCase();
            switch (selection) {
                case "A":
                    skin.addDoctor(emp_doctors);
                    break;
                case "D":
                    skin.deleteDoctor(emp_doctors);
                    break;
                case "P":
                    skin.printListOfAllDoctors(emp_doctors);
                    break;
                case "S":
                    skin.storeDataToFile(emp_doctors);
                    break;
                case "L":
                    skin.initializeArr(emp_doctors);
                    skin.loadDataFromFile(emp_doctors);
                    break;
                case "G":
                    SkinConsultationManagerGui gui = new SkinConsultationManagerGui();
                    gui.displayGui(emp_doctors);
                    break;
                case "X":
                    System.exit(0);
                default:
                    System.out.println("Entered option is not found. Please try again.");
            }

        }
    }

    public static String MenuData() {
        String selection;
        System.out.println("\n");
        System.out.println("Select your option");
        System.out.println("------------------------------------------------------\n");
        System.out.println("A - Add New Doctor to system");
        System.out.println("D - Delete Doctor from system");
        System.out.println("P - Print the list of the doctors in the consultation centre");
        System.out.println("S - Store program data into file");
        System.out.println("L - Load program data from file");
        System.out.println("G - Display GUI");
        System.out.println("X - Exit");
        System.out.println("------------------------------------------------------\n");

        System.out.println("Your selected option is : ");
        selection = scanner.next();
        return selection;


    }
}

