package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student dmitry = new Student();
        dmitry.setName("Dmitry");
        dmitry.setSurname("Kowalsky");
        dmitry.setPatronymic("Sergeevich");
        dmitry.setGroup("ОХП");
        dmitry.setDateAdmission("8 августа 2021");

        System.out.println("Name : " + dmitry.getName());
        System.out.println("Surname : " + dmitry.getSurname());
        System.out.println("Patronymic : " + dmitry.getPatronymic());
        System.out.println("Group : " + dmitry.getGroup());
        System.out.println("Date admission : " + dmitry.getDateAdmission());
    }
}
