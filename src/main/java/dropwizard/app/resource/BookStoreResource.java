package dropwizard.app.resource;

import dropwizard.app.model.external.Book;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String health(){
        return "BookStore is up";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookByTitle(@PathParam("name") String name){
        Book book = new Book();
        book.setAuthor("Default");
        book.setTitle(name);
        return book;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(@Valid Book book){
        throw new RuntimeException("Not implemented yet");
    }

}
