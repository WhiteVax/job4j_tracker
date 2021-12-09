package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 464);
        Book secondBook = new Book("City of the Dead", 320);
        Book thirdBook = new Book("School's Out - Forever", 448);
        Book fourthBook = new Book("The Shadow", 400);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;

        for (Book item : books) {
            System.out.println(item.getName() + " : " + item.getNumberOfPages());
        }

        System.out.println("");
        Book temp;
        temp = books[3];
        books[3] = books[0];
        books[0] = temp;

        for (Book item : books) {
            System.out.println(item.getName() + " : " + item.getNumberOfPages());
        }

        System.out.println("");
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " : " + books[index].getNumberOfPages());
            }
        }
    }
}
