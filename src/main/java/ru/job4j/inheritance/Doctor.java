package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String treatmentPlan;
    private String heal;

    public Doctor() {
    }

    public Doctor(String treatmentPlan, String heal) {
        this.treatmentPlan = treatmentPlan;
        this.heal = heal;
    }

    public Doctor(String name, String surname,  String birtday, String treatmentPlan) {
        super(name, surname, birtday);
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
