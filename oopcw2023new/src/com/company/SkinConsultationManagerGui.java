package com.company;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;

public class SkinConsultationManagerGui {
    ArrayList<Consultation> consultations = new ArrayList<>();


    JFrame display = new JFrame();
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    int patientId = 1;


    public void displayGui(Doctor[] emp_doctors){

        JLabel titlenm = new JLabel("Westminster Skin Consultation!");
        titlenm.setBounds(455, 350, 500, 60);
        titlenm.setFont(new Font("Arial", Font.BOLD, 20));

        JButton patientButton = new JButton();
        patientButton.setText("Consultation");
        patientButton.setBounds(20, 20, 120, 40);

        JButton doctorButton = new JButton();
        doctorButton.setText("Doctor list");
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        doctorButton.setBounds(20, 100, 120, 40);

        JButton viewPatients = new JButton();
        viewPatients.setText("Patients");
        viewPatients.setBounds(20, 180, 120, 40);

        left.setBackground(Color.GRAY);
        left.setLayout(null);
        left.setBounds(0, 0, 200, 900);
        left.add(patientButton);
        left.add(doctorButton);
        left.add(viewPatients);

        right.setBackground(Color.WHITE);
        right.setLayout(null);
        right.setBounds(200, 0, 1240, 900);
        right.add(titlenm);

        display.setLayout(null);
        display.add(left, BorderLayout.WEST);
        display.add(right, BorderLayout.CENTER);

        display.setSize(1440, 900);
        display.setResizable(false);
        display.setVisible(true);



        patientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                patientDetails(emp_doctors);
            }
        });


        //button to view doctors table
        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorDetails(emp_doctors);
            }
        });

        //button to view patient details
        viewPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatientDetails();
            }
        });

        display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void doctorDetails(Doctor[] emp_doctors){
        int tableRowCount = 0;
        for (int i = 0; i < emp_doctors.length; i++) {
            if (emp_doctors[i].getName() != null) {
                tableRowCount++;
            }
        }

        //creating the doctors table
        String[][] tableData = new String[tableRowCount][6];
        String[] tableHeaders = {"Doctor name", "Doctor surname", "Specialization", "medical licence ID", "Date of birth", "mobile number"};
        for (int i = 0; i < emp_doctors.length; i++) {
            if (emp_doctors[i].getName() != null) {
                tableData[i][0] = emp_doctors[i].getName();
                tableData[i][1] = emp_doctors[i].getSurname();
                tableData[i][2] = emp_doctors[i].getSpecialisation();
                tableData[i][3] = emp_doctors[i].getMedicallicenceId();
                tableData[i][4] = emp_doctors[i].getDate_of_birth().toString();
                tableData[i][5] = String.valueOf(emp_doctors[i].getMobile_number());
            }
        }
        JTable table = new JTable(tableData, tableHeaders);
        table.setShowGrid(false);
        table.setAutoCreateRowSorter(true);
        table.setBounds(5,23,1190, 680);

        right.removeAll();
        right.revalidate();
        right.repaint();
        right.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setLayout(null);
        scrollPane.setBounds(20, 20, 1200, 700);
        JTableHeader header = table.getTableHeader();
        header.setBounds(5,5,1190, 20);
        scrollPane.add(header);
        scrollPane.add(table);
        right.add(scrollPane);
        display.add(right, BorderLayout.CENTER);
    }

    //method to add a consulation
    public void patientDetails(Doctor[] emp_doctors){
        String[] doctorNames = new String[getAvailableDoctorCount(emp_doctors)];
        String[] timeSlots = new String[5];

        for(int i = 0; i< emp_doctors.length; i++) {
            if(emp_doctors[i].getName() != null) {
                doctorNames[i] = emp_doctors[i].getName() + " " + emp_doctors[i].getSurname();
            }
        }

        int time;
        for(int i = 0; i < timeSlots.length; i++) {
            time = i+1;
            timeSlots[i] =  time + ":00 pm";
        }

        JLabel nameLabel = new JLabel();
        JLabel surnameLabel =  new JLabel();
        JLabel dobLabel = new JLabel();
        JLabel numberLabel = new JLabel();
        JLabel patientLabel = new JLabel();
        JLabel consultLabel = new JLabel();
        JTextField nameText = new JTextField();
        JTextField surnameText = new JTextField();
        JTextField numberText = new JTextField();
        JTextField dobText = new JTextField();
        JComboBox doctorCombo = new JComboBox(doctorNames);
        JLabel doctorNamesLabel = new JLabel();
        JComboBox timeCombo = new JComboBox(timeSlots);
        JLabel timeLabel = new JLabel();
        JLabel consultDateLabel = new JLabel();
        JTextField consultDateText = new JTextField();
        JLabel consultNoteLabel = new JLabel();
        JTextArea consultNoteText = new JTextArea();
        JButton addConsult = new JButton();

        patientLabel.setText("Patient Details");
        patientLabel.setBounds(550, 10, 200, 40);

        nameLabel.setText("Patient Name");
        nameLabel.setBounds(50, 50, 200, 40);

        nameText.setBounds(290, 50, 300, 40);

        surnameLabel.setText("Patient Surname");
        surnameLabel.setBounds(50, 130, 200, 40);

        surnameText.setBounds(290, 130, 300, 40);

        dobLabel.setText("<html>Patient date of birth<br> (yyyy-mm-dd)</html>");
        dobLabel.setBounds(620, 50, 200, 40);

        dobText.setBounds(890, 50, 300, 40);

        numberLabel.setText("Patient number");
        numberLabel.setBounds(620, 130, 200, 40);

        numberText.setBounds(890, 130, 300, 40);

        consultLabel.setText("Consultation Details");
        consultLabel.setBounds(530, 210, 300, 40);

        doctorNamesLabel.setText("Doctors");
        doctorNamesLabel.setBounds(50, 290, 200, 40);

        doctorCombo.setBounds(290, 290, 300, 40);

        timeLabel.setText("Time Slot");
        timeLabel.setBounds(50, 370, 200, 40);

        timeCombo.setBounds(290, 370, 300, 40);

        consultDateLabel.setText("<html>Date of consultation<br> (yyyy-mm-dd)</html>");
        consultDateLabel.setBounds(620, 290, 200, 40);

        consultDateText.setBounds(890, 290, 300, 40);

        consultNoteLabel.setText("Consultation Notes");
        consultNoteLabel.setBounds(620, 370, 200, 40);

        addConsult.setText("Add Consultation");
        addConsult.setBounds(50, 450, 200, 40);


        right.removeAll();
        right.revalidate();
        right.repaint();
        right.setLayout(null);
        right.add(patientLabel);
        right.add(nameLabel);
        right.add(surnameLabel);
        right.add(dobLabel);
        right.add(numberLabel);
        right.add(nameText);
        right.add(surnameText);
        right.add(dobText);
        right.add(numberText);
        right.add(consultLabel);
        right.add(doctorNamesLabel);
        right.add(doctorCombo);
        right.add(timeLabel);
        right.add(timeCombo);
        right.add(consultDateLabel);
        right.add(consultDateText);
        right.add(consultNoteLabel);
        consultNoteText.setLineWrap(true);
        JScrollPane notesArea = new JScrollPane(consultNoteText);
        notesArea.setBounds(890, 370, 300, 100);
        right.add(notesArea);
        right.add(addConsult);
        display.add(right, BorderLayout.CENTER);


        //button to add consultation
        addConsult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean doctorAvailable = true;
                Doctor doctor = null;

                try{
                    for(int i = 0; i < consultations.size(); i++) {
                        String docName = consultations.get(i).getDoctor().getName() + " " + consultations.get(i).getDoctor().getSurname();
                        String time = consultations.get(i).getConsultTimeSlot();
                        String date = String.valueOf(consultations.get(i).getConsultDate());
                        doctor = consultations.get(i).getDoctor();

                        if(docName.equals(doctorCombo.getSelectedItem().toString()) &&
                                Objects.equals(time, timeCombo.getSelectedItem().toString()) &&
                                Objects.equals(date, consultDateText.getText())){
                            doctorAvailable = false;
                        }
                    }

                    Patient patient = new Patient();
                    patient.setPatientId(patientId);
                    patient.setName(nameText.getText());
                    patient.setSurname(surnameText.getText());
                    patient.setMobile_number(Integer.parseInt(numberText.getText()));
                    patient.setDate_of_birth(LocalDate.parse(dobText.getText()));

                    Consultation consultation =  new Consultation();
                    consultation.setPatient(patient);

                    //check if doctor is already booked and get the random doctor
                    if(doctorAvailable) {
                        doctor = getFilteredDoctor(doctorCombo.getSelectedItem().toString(), emp_doctors);
                        consultation.setDoctor(doctor);
                    } else {
                        consultation.setDoctor(getRandomDoctor(doctorCombo.getSelectedItem().toString(), emp_doctors));
                    }
                    consultation.setConsultTimeSlot(timeCombo.getSelectedItem().toString());

                    String consultNoteTextEncoded = Base64.getEncoder().encodeToString(consultNoteText.getText().getBytes());
                    consultation.setConsultNotes(consultNoteTextEncoded);
                    consultation.setConsultDate(LocalDate.parse(consultDateText.getText()));
                    consultation.setConsultCost("$15");

                    //get the patient's cost considering the previous consultations
                    for(int i = 0;i < consultations.size(); i++) {
                        if(!Objects.equals(consultations.get(i).getPatient().getName(), patient.getName())) {
                            consultation.setConsultCost("$15");
                            break;
                        } else {
                            consultation.setConsultCost("$25");
                        }
                    }

                    consultations.add(consultation);
                    patientId = patientId + 1;
                } catch (Exception ex) {
                    System.out.println("error in adding a consultation. Please check the inputs.");
                }
            }
        });
    }


    //method to get the patients in the medical center
    public void viewPatientDetails() {
        String[][] tableData = new String[consultations.size()][4];
        String[] tableHeaders = {"Doctor name", "Patient name", "Consult Date", "Time Slot"};
        for (int i = 0; i < consultations.size(); i++) {
            if (consultations.get(i).getPatient() != null && consultations.get(i).getDoctor() != null) {
                tableData[i][0] = consultations.get(i).getDoctor().getName();
                tableData[i][1] = consultations.get(i).getPatient().getName();
                tableData[i][2] = String.valueOf(consultations.get(i).getConsultDate());
                tableData[i][3] = consultations.get(i).getConsultTimeSlot();
            }
        }

        //patient list table
        JTable table = new JTable(tableData, tableHeaders);
        table.setShowGrid(false);
        table.setBounds(5,23,1190, 480);

        right.removeAll();
        right.revalidate();
        right.repaint();
        right.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setLayout(null);
        scrollPane.setBounds(20, 20, 1200, 500);
        JTableHeader header = table.getTableHeader();
        header.setBounds(5,5,1190, 20);
        scrollPane.add(header);
        scrollPane.add(table);
        JButton viewSelectedPatient = new JButton();
        viewSelectedPatient.setText("View Details");
        viewSelectedPatient.setBounds(50, 540, 200, 40);

        JTextArea label = new JTextArea();

        right.add(scrollPane);
        right.add(viewSelectedPatient);
        label.setLineWrap(true);
        JScrollPane notesArea = new JScrollPane(label);
        notesArea.setBounds(50, 610, 600, 200);
        right.add(notesArea);
        display.add(right, BorderLayout.CENTER);


        //button to view details from table
        viewSelectedPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row = table.getSelectedRow();
                    Consultation consultation = consultations.get(row);
                    label.setText(consultation.toString());
                } catch (Exception ex) {

                }

            }
        });
    }

    //get the available doctor count
    private static int getAvailableDoctorCount(Doctor[] emp_doctors) {
        int doctorCount = 0;
        for(int i = 0;i < emp_doctors.length; i++){
            if(emp_doctors[i].getName() != null) {
                doctorCount++;
            }
        }
        return doctorCount;
    }

    //get the doctor from array
    private Doctor getFilteredDoctor(String name, Doctor[] emp_doctors) {
        for(int i = 0; i< emp_doctors.length; i++){
            String docName = emp_doctors[i].getName() + " " + emp_doctors[i].getSurname();
            if(docName.equals(name)) {
                return emp_doctors[i];
            }
        }
        return null;
    }


    //get a random doctor
    private Doctor getRandomDoctor(String name, Doctor[] emp_doctors){
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        for(int i = 0;i < emp_doctors.length; i++){
            String docName = emp_doctors[i].getName() + " " + emp_doctors[i].getSurname();
            if(!docName.equals(name) && emp_doctors[i].getName() != null) {
                doctorArrayList.add(emp_doctors[i]);
            }
        }

        for(int i = 0; i < consultations.size(); i++) {
            doctorArrayList.remove(consultations.get(i).getDoctor());
        }


        Random rn = new Random();
        int range = doctorArrayList.size();
        int randomNum =  rn.nextInt(range);

        return doctorArrayList.get(randomNum);
    }
}




















