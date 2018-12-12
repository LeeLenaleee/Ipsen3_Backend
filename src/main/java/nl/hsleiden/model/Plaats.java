package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Plaats {

    @NotEmpty
    @Length(min = 3, max = 50)
    @JsonView(View.Public.class)
    private String streetName;

    @NotEmpty
    @Length(min = 5, max = 7)
    @JsonView(View.Public.class)
    private String postCode;

    @NotEmpty
    @Length(min = 3, max = 30)
    @JsonView(View.Public.class)
    private String woonPlaats;

    @NotEmpty
    @Length(min = 3, max = 50)
    @JsonView(View.Public.class)
    private String country;

    public Plaats() {
    }

    public Plaats(String streetName, String postCode, String woonPlaats, String country) {
        this.streetName = streetName;
        this.postCode = postCode;
        this.woonPlaats = woonPlaats;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
