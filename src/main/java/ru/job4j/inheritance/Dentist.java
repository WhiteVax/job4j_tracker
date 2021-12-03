package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String dentalTreatment;

    public Dentist(String name, String surname, String dentalTreatment) {
        super(name, surname);
        this.dentalTreatment = dentalTreatment;
    }

    public String getDentalTreatment() {
        return dentalTreatment;
    }
}
