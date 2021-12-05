package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String estimate;

    public Builder(String name, String surname, String education, String birthday, int experiance, String estimate) {
        super(name, surname, education, birthday, experiance);
        this.estimate = estimate;
    }

    public String getEstimate() {
        return estimate;
    }
}
