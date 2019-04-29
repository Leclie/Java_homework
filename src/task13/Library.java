package task13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Library {
    public static Semaphore semaphore = new Semaphore(1);
    private static CopyOnWriteArrayList<Book> booksInLibrary = new CopyOnWriteArrayList<>();
    public static void getBookInLibrary(Book book) throws Exception {
        if (booksInLibrary.contains(book)) {
            booksInLibrary.remove(book);
            return;
        }
        throw new Exception("Такой книги нет!!!");
    }
    public static void returnBook(Book book){
        if (!booksInLibrary.contains(book)) {
            booksInLibrary.add(book);
        }
        System.out.println("Книга уже возвращена!!");
    }
    public static Book findBook(String title, String author){
        for (Book book : booksInLibrary){
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)){
                return book;
            }
        }
        System.out.println("Такой книги нет!!!");
        return null;
    }

    public static void main(String[] args) {
        booksInLibrary.add(new Book("Harry", "Potter", true));
        booksInLibrary.add(new Book("War", "Peace", true));
        booksInLibrary.add(new Book("Evgeniy", "Onegin", true));
        booksInLibrary.add(new Book("Avatar", "Potter", false));
        booksInLibrary.add(new Book("King", "Artur", false));
        booksInLibrary.add(new Book("Ice", "Queen", false));

        new Thread(new Reader("John")).start();
        new Thread(new Reader("Bob")).start();
    }
}

class Reader implements Runnable{
    private String name;
    private ArrayList<Book> booksTaken = new ArrayList<>();
    private ArrayList<Book> booksForReadingInHall = new ArrayList<>();

    public String getName() {
        return name;
    } // УЗНАТЬ ИМЯ
    public Reader(String name) {
        this.name = name;
    } // КОНСТРУКТОР ЧИТАТЕЛЯ

    // МЕТОД ПОЗВОЛЯЮЩИЙ ВЗЯТЬ КНИГУ С СОБОЙ
    public void takeBook(Book book){
        if (!book.isOnlyInLibrary()) {
            try {
                Library.getBookInLibrary(book);
            } catch (Exception e) { e.printStackTrace(); }
            booksTaken.add(book);
        }
        else {
            System.out.println("Вы можете читать данную книгу только в библиотеке!");
        }
    }
    // МЕТОД ВОЗВРАЩАЕТ КНИГУ В БИБЛИОТЕКУ
    public void returnBook(Book book){
        if (booksTaken.contains(book)){
            booksTaken.remove(book);
            Library.returnBook(book);
            return;
        }
        System.out.println("У вас нет такой книги");
    }
    // МЕТОД ПОЗВОЛЯЮЩИЙ ВЗЯТЬ КНИГУ В ЧИТАЛЬНЫЙ ЗАЛ
    public void addBookForReadingInHall(Book book){
        booksForReadingInHall.add(book);
    }
    // МЕТОД ВОЗВРЩАЕТ КНИГУ В БИБЛИОТЕКУ, КОТОРАЯ БЫЛА ВЗЯТА ДЛЯ ЧИТАЛЬНОГО ЗАЛА
    public void returnBooksFromHall(Book book){
        booksForReadingInHall.remove(book);
    }

    @Override
    public void run() {
        try {
            Library.semaphore.acquire();

            System.out.println("1. Взять книгу с собой");
            System.out.println("2. Взять книгу в читальный зал");
            int answer = new Scanner(System.in).nextInt();
            System.out.println("Введите название книги");
            String newBookTitle = new Scanner(System.in).nextLine();
            System.out.println("Введите автора книги");
            String newBookAuthor = new Scanner(System.in).nextLine();
            Book newBook = Library.findBook(newBookTitle, newBookAuthor);
            if (answer == 1){
                takeBook(newBook);
            }else if (answer == 2){
                addBookForReadingInHall(newBook);
            }
            System.out.println("До свидания!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Library.semaphore.release();
    }
}


class Book{
    private String title;
    private String author;
    private boolean onlyInLibrary;

    public Book(String title, String author, boolean onlyInLibrary) {
        this.title = title;
        this.author = author;
        this.onlyInLibrary = onlyInLibrary;
    }
    // ПРОВЕРКА НА ВОЗМОЖНОСТЬ ВЗЯТЬ КНИГУ С СОБОЙ
    public boolean isOnlyInLibrary(){
        return onlyInLibrary;
    }
    // МЕТОД ПОЛУЧЕНИЯ НАЗВАНИЯ КНИГИ
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}



