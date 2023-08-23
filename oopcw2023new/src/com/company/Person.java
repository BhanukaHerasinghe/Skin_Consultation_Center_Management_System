package com.company;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate date_of_birth;
    private int mobile_number;

    public Person() {
    }

    // Get name
    public String getName(){
        return name;
    }

    // Set name
    public void setName(String newName){
        this.name = newName;
    }

    // Get surname
    public String getSurname(){
        return surname;
    }

    // Set surname
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", mobile_number=" + mobile_number +
                '}';
    }




}





