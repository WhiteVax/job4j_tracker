package ru.job4j.collection;

import java.util.Map;
import java.util.HashMap;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }

    public static void main(String[] args) {
        Citizen citizen = new Citizen("2f44a", "Petr");
        System.out.println(citizen.getPassport());
    }
}
