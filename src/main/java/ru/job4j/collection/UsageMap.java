package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("karpo0910@mail.ru", "Dmitriy Karpov");
        map.put("karpo0910@mail.ru", "Vitalik Karpov");
        map.put("karpo0910@mail.ru", "Anzorik Karpov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
