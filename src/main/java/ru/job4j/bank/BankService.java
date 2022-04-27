package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает, работу упрощенного банковского сервиса,
 * с возможностью, хранения, добавления, удаления пользователей,
 * переводом средств между пользователями.
 * @author VLADYSLAV BEDENKO
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, если его не находит по ключу в users.
     * @param user пользователь который добавляется.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет акаунт пользователю.
     * @param passport паспорстные данные по которым ищет пользователя
     *                 в users.
     * @param account акаунт который проверяется в списке,
     *                если не находит то добавляет.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> rsl = users.get(user.get());
            if (!rsl.contains(account)) {
                rsl.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспортным данным в users.
     * @param passport данные по которым ищет.
     * @return возвращает найденного пользователя типа User,
     * если не находит вернёт null.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет реквизиты пользователя.
     * @param passport данные по которым ищет пользователя.
     * @param requisite реквизиты которые ищет.
     * @return возвращает найденный акаунт или null  случае неудачи.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        return user.map(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst())
                .orElse(account);
    }

    /**
     * Метод удаляет пользователя.
     * @param passport данные по которым находит пользователя
     *                 для удаления.
     * @return в случае выполнения вернёт true или false.
     */
    public boolean deleteUser(String passport) {
        boolean rsl = false;
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            users.remove(user.get());
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод для перевода денежных средств.
     * @param srcPassport данные по которым ищет пользователя.
     * @param srcRequisite реквизиты с которых будет осуществлятся перевод.
     * @param destPassport данные по которым ищет пользователя для перевода.
     * @param destRequisite реквизиты на которые будет осуществлятся перевод.
     * @param amount сумма перевода.
     * @return в случаи выполнения вернёт true или false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
