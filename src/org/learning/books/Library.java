package org.learning.books;

import java.util.Scanner;

public class Library {
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

                        String title = validateInputString(scanner, "Title");
                        int pageNumber = validateInputInteger(scanner, "Page Number");
                        String author = validateInputString(scanner, "Author");
                        String editor = validateInputString(scanner, "Editor");

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
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
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

    private static int validateInputInteger(Scanner scanner, String request) {
        int input;

        while (true) {
            System.out.print(request + ": ");

            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input > 0) {
                    break;
                } else {
                    System.out.println("Have to be greater than 0!");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        return input;
    }

    private static String validateInputString(Scanner scanner, String request) {
        String input;

        while (true) {
            System.out.print(request + ": ");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Cannot be empty");
            }
        }

        return input;
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
