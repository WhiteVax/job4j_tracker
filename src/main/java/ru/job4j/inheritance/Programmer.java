package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String buildingApplication;

    public Programmer(String name, String surname, String education, String birthday, int experience, String buildingApplication) {
        super(name, surname, education, birthday, experience);
        this.buildingApplication = buildingApplication;
    }

    public String getBuildingApplication() {
        return buildingApplication;
    }
}
