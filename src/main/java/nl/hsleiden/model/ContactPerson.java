package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.security.Principal;
import java.util.ArrayList;

/**
 * @author Kasper
 */
public class ContactPerson implements Principal {
    @NotEmpty
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String fullName;

    @NotEmpty
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String firstName;

    @NotEmpty
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String lastName;

    @NotEmpty
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String company;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private ArrayList<String> emails = new ArrayList<>();

    public String getName() {
        return this.firstName + this.lastName;
    }
}