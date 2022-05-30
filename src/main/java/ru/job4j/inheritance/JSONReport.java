package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\t\"name\" : " + "\"" + name + "\""
                + ",\n"
                + "\t\"body\" : " + "\""
                + body + "\"" + System.lineSeparator()
                + "}";
    }
}
