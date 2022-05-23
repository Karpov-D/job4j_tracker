package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{\n"
                + "\t\"name\" : " + "\"" + name + "\"" + ",\n"
                + "\t\"body\" : " + "\"" + body + "\""
                + "\n}";
    }

    public static void main(String[] args) {
        JSONReport d = new JSONReport();
        String a = d.generate("a", "b");
        System.out.println(a);
    }
}
