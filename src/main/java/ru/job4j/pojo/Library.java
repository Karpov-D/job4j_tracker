package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book fairytale = new Book("Золотая рыбка", 60);
        Book romance = new Book("Война и мир", 600);
        Book comic = new Book("Человек паук", 100);
        Book code = new Book("Clean code", 900);

        Book[] books = new Book[4];
        books[0] = fairytale;
        books[1] = romance;
        books[2] = comic;
        books[3] = code;

        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        Book pr = books[0];
        books[0] = books[3];
        books[3] = pr;

        for (int index = 0; index < books.length; index++) {
            Book pro = books[index];
            if ("Clean code".equals(pro.getName())) {
                System.out.println(pro.getName() + " - " + pro.getCount());
            }
        }
    }
}
