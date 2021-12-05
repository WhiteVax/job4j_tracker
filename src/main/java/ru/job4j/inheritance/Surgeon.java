package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String vaccinate;

    public Surgeon(String name, String surname, String education, String birthday, String treatmentPlan, String heal, String vaccinate) {
        super(name, surname, education, birthday, treatmentPlan, heal);
        this.vaccinate = vaccinate;
    }

    public String getVaccinate() {
        return vaccinate;
    }
}
