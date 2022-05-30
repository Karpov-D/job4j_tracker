package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Karpov Dmitry");
        student.setGroup("15B");
        student.setAdmissionDate(new Date());

        System.out.println(" ФИО: " + student.getName() + System.lineSeparator()
                + " Группа: " + student.getGroup() + System.lineSeparator() + " Дата поступления: "
                + student.getAdmissionDate());
    }
}
