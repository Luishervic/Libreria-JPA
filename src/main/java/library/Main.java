package library;

import library.model.Author;
import library.model.Book;
import library.service.AuthorService;
import library.service.BookService;
import library.utils.Validation;

import java.util.List;

public class Main {
    private static final BookService bookService = new BookService();
    private static final AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        int option;

        do {
            menu();
            option = Validation.getUserInputInt("Choose an option: ", 1, 10);
            switch (option) {
                case 1:
                    searchAuthorByNameMenu();
                    break;
                case 2:
                    searchBookByIsbnMenu();
                    break;
                case 3:
                    searchBookByTitleMenu();
                    break;
                case 4:
                    searchBooksByAuthorMenu();
                    break;
                case 5:
                    searchBooksByPublisherMenu();
                    break;
                case 10:
                    System.out.println("Exit.");
                    break;
            }

        } while (option != 10);
    }

    public static void menu(){
        System.out.println("1.- Search author by name:");
        System.out.println("2.- Search book by ISBN:");
        System.out.println("3.- Search book by title:");
        System.out.println("4.- Search books by author:");
        System.out.println("5.- Search books by publisher:");
        System.out.println("10.- Exit.");
    }

    public static void searchAuthorByNameMenu(){
        Author author = authorService.searchByName();
        System.out.println(author);
    }

    public static void searchBookByIsbnMenu(){
        Book book = bookService.searchByIsbn();
        System.out.println(book);
    }

    public static void searchBookByTitleMenu(){
        Book book = bookService.searchByTitle();
        System.out.println(book);
    }

    public static void searchBooksByAuthorMenu(){
        List<Book> books = bookService.searchByAuthor();
        printBooks(books);
    }


    public static void searchBooksByPublisherMenu(){
        List<Book> books = bookService.searchByPublisher();
        printBooks(books);
    }

    public static void printBooks(List<Book> books){
        for (Book book: books) {
            System.out.println(book);
        }
    }


}
