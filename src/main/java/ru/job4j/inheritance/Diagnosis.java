package ru.job4j.inheritance;

public class Diagnosis extends Doctor {

    private String diagnosis;

    public Diagnosis(String heal, String treatmentPlan, String diagnosis) {
        super(heal, treatmentPlan);
        this.diagnosis = this.getDiagnosis();
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
