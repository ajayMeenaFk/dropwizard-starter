package dropwizard.app.resource;

import dropwizard.app.BookStoreService;
import dropwizard.app.model.external.Book;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/book-store")
public class BookStoreResource {
    private final BookStoreService bookStoreService;

    @Inject
    public BookStoreResource(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String health(){
        return "BookStore is up";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookByTitle(@PathParam("name") String name){
        return bookStoreService.getBookByTitle(name);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(@Valid Book book){
        throw new RuntimeException("Not implemented yet");
    }

}
