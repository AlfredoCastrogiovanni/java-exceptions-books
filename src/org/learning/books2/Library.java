package org.learning.books2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.learning.books.Book;

public class Library {

    public static String PATH_FILE = "./resources/data.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] bookList = new Book[0];

        while (true) {

            printMenu();

            try {

                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:

                        System.out.println("Title:");
                        String title = scanner.nextLine();

                        System.out.println("Page Number:");
                        int pageNumber = Integer.parseInt(scanner.nextLine());

                        System.out.println("Author:");
                        String author = scanner.nextLine();

                        System.out.println("Editor:");
                        String editor = scanner.nextLine();

                        bookList = addToBookList(bookList, new Book(title, pageNumber, author, editor));

                        System.out.println();
                        System.out.println("Book added.");

                        break;
                    case 2:
                        viewBookList(bookList, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        saveBookList(PATH_FILE, bookList);
                        readBookList(PATH_FILE);
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void readBookList(String filePath) {
        Scanner scanner = null;
        File file = new File(filePath);

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        scanner.close();
    }

    public static void saveBookList(String filePath, Book[] bookList) {
        File file = new File(filePath);

        if (!file.isFile()) {
            System.out.println("File not found");
        } else {
            try (FileWriter fw = new FileWriter(file)) {
                for (int i = 0; i < bookList.length; i++) {
                    fw.write("--- Book " + i + "\n");
                    fw.write(bookList[i].toString());
                }
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public static Book[] addToBookList(Book[] bookList, Book item) {
        Book[] newBookList = new Book[bookList.length + 1];

        for (int i = 0; i < bookList.length; i++) {
            newBookList[i] = bookList[i];
        }

        newBookList[newBookList.length - 1] = item;

        return newBookList;
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("|        LIBRARY MENU      |");
        System.out.println("----------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. View you book list");
        System.out.println("3. Exit");
        System.out.println("----------------------------");
        System.out.println();
    }

    private static void viewBookList(Book[] bookList, Scanner scanner) {
        System.out.println("----------------------------");
        System.out.println("|         BOOK LIST        |");
        System.out.println("----------------------------");

        if (bookList.length == 0) {
            System.out.println("          Is Empty          ");
        } else {
            for (int i = 0; i < bookList.length; i++) {
                System.out.println("--- Book " + i);
                System.out.println(bookList[i]);
            }
        }

        System.out.println();
        System.out.print("Press enter to exit");
        scanner.nextLine();
    }
}
