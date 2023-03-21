package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель работы банковской системы
 * @author DMITRY KARPOV
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя user
     * Метод добавляет пользователя в коллекцию если такого пользователя еще нет
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта passport
     * Метод удаляет пользователя из коллекции по значению passport
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает на вход номер паспорта passport и номер счета account
     * Метод осуществляет поиск пользователя по паспорту и добавляет найденоому пользователю новый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> acc = users.get(user);
            if (!acc.contains(account)) {
                acc.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта passport
     * Метод осуществляет поиск пользователя по паспорту
     * @return возвращает пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод принимает на вход номер паспорта passport и реквизиты счета requisite
     * Метод осуществляет поиск пользователя по паспорту, затем находит у пользователя счет
     * @return возвращает счет пользователя или null если пользователь не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> acc = users.get(user);
            for (Account ac : acc) {
                if (ac.getRequisite().equals(requisite)) {
                    rsl = ac;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод принимает на вход номер паспорта passport и реквизиты счета с которого переводят srcRequisite,
     * номер паспорта passport и реквизиты куда переводят destRequisite и сумма перевода amount
     * Метод перечесляет деньги с одного счета на другой
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят), то метод должен вернуть false.
     * @return возвращает true если перевод выполнен иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
