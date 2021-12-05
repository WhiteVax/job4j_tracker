package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String treatmentPlan;
    private String heal;

    public Doctor(String name, String surname, String education, String birthday, String treatmentPlan, String heal) {
        super(name, surname, education, birthday);
        this.treatmentPlan = treatmentPlan;
        this.heal = heal;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public String getHeal() {
        return heal;
    }
}
