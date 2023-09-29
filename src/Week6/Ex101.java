package Week6;

import Week5.Ex88;

import java.util.ArrayList;

public class Ex101 {

    private static class Book {
        private String title;
        private String publisher;
        private int year;

        public Book(String title, String publisher, int year) {
            this.title = title;
            this.publisher = publisher;
            this.year = year;
        }

        public String title() {
            return this.title;
        }

        public String publisher() {
            return this.publisher;
        }

        public int year() {
            return this.year;
        }

        public String toString() {
            return this.title + ", " + this.publisher + ", " + this.year;
        }
    }

    private static class Library {
        private ArrayList<Book> library = new ArrayList<>();

        public Library() {

        }

        public void addBook(Book newBook) {
            this.library.add(newBook);
        }

        public void printBooks() {
            for (Book book : library) {
                System.out.println(book.toString());
            }
        }

        public ArrayList<Book> searchByTitle(String title) {
            ArrayList<Book> found = new ArrayList<Book>();

            for (Book book : this.library) {
                if (StringUtils.included(book.title(), title)) {
                    found.add(book);
                }
            }

            return found;
        }

        public ArrayList<Book> searchByPublisher(String publisher) {
            ArrayList<Book> found = new ArrayList<Book>();

            for (Book book : this.library) {
                if (StringUtils.included(book.publisher(), publisher)) {
                    found.add(book);
                }
            }

            return found;
        }

        public ArrayList<Book> searchByYear(int year) {
            ArrayList<Book> found = new ArrayList<Book>();

            for (Book book : this.library) {
                if (book.year == year) {
                    found.add(book);
                }
            }
            return found;
        }
    }

    private static class StringUtils {
        public static boolean included(String word, String searched) {
            return word.toUpperCase().contains(searched.trim().toUpperCase());
        }
    }

    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        for (Book book : Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book : Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }
    }
}
