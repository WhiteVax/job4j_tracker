package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String estimate;

    public Builder(String name, String surname, String education, String experiance, String estimate) {
        super(name, surname, education, experiance);
        this.estimate = estimate;
    }

    public String getEstimate() {
        return estimate;
    }
}
