package dropwizard.app.model.external;


import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSnakeCase
public class Book {
    private String title;
    private String author;
}
