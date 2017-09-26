package dropwizard.app;


import dropwizard.app.model.external.Book;

public class BookStoreService {

    public Book getBookByTitle(String name) {
        Book book = new Book();
        book.setAuthor("Default");
        book.setTitle(name);
        return book;
    }
}
