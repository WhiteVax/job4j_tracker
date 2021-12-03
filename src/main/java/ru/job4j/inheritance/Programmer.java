package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String buildingApplication;

    Programmer(String name, String surname, String education, String experiance, String buildingApplication) {
        super(name, surname, education, experiance);
        this.buildingApplication = buildingApplication;
    }

    public String getBuildingApplication() {
        return buildingApplication;
    }
}
