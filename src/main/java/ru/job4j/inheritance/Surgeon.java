package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String vaccinate;

    public Surgeon(String name, String surname, String birtday, String treatmentPlan, String vaccinate) {
        super(name, surname, birtday, treatmentPlan);
        this.vaccinate = vaccinate;
    }

    public String getVaccinate() {
        return vaccinate;
    }
}
