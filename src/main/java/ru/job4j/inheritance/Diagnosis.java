package ru.job4j.inheritance;

public class Diagnosis extends Doctor {

    private String diagnosis;

    public Diagnosis(String name, String surname, String education, String birthday, String treatmentPlan, String heal, String diagnosis) {
        super(name, surname, education, birthday, heal, treatmentPlan);
        this.diagnosis = this.getDiagnosis();
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
