package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String dentalTreatment;

    public Dentist(String name, String surname, String education, String birthday, String treatmentPlan, String heal, String dentalTreatment) {
        super(name, surname, education, birthday, treatmentPlan, heal);
        this.dentalTreatment = dentalTreatment;
    }

    public String getDentalTreatment() {
        return dentalTreatment;
    }
}
