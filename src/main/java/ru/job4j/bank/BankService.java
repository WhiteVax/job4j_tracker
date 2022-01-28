package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && findByRequisite(passport, account.getRequisite()) == null) {
            List<Account> rsl = users.get(user);
            rsl.add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User item : users.keySet()) {
            if (item.getPassport().equals(passport)) {
                user = item;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account found = null;
        if (user != null) {
            List<Account> rsl = users.get(user);
            for (Account account : rsl) {
                if (account.getRequisite().equals(requisite)) {
                    found = account;
                    break;
                }
            }
        }
        return found;
    }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            rsl = true;
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        double srcBalance = srcAccount.getBalance() - amount;
        if (destAccount != null && srcBalance >= 0) {
            srcAccount.setBalance(srcBalance);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
