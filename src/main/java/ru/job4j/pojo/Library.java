package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book Fairytale = new Book("Золотая рыбка", 60);
        Book Romance = new Book("Война и мир", 600);
        Book Comic = new Book("Человек паук", 100);
        Book Code = new Book("Clean code", 900);

        Book[] books = new Book[4];
        books[0] = Fairytale;
        books[1] = Romance;
        books[2] = Comic;
        books[3] = Code;

        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }

        Book pr = books[0];
        books[0] = books[3];
        books[3] = pr;

        for (int index = 0; index < books.length; index++) {
            Book pro = books[index];
            if (pro.getName().equals("Clean code")) {
                System.out.println(pro.getName() + " - " + pro.getCount());
            }
        }
    }
}
