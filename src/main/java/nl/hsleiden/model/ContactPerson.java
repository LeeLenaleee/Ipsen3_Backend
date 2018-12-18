package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.security.Principal;
import java.util.ArrayList;

/**
 * @author Kasper
 */
@Entity
@Table(name = "contactpersoon")
public class ContactPerson extends BaseModel implements Principal {
    @Column(name = "contact_achternaam")
    private String contact_achternaam;

    @Column(name = "contact_voornaam")
    private String contact_voornaam;

    @Column(name = "contact_bedrijf")
    private String contact_bedrijf;

    @Column(name = "contact_straatnaam")
    private String contact_straatnaam;

    @Column(name = "contact_postcode")
    private String contact_postcode;

    @Column(name = "contact_plaats")
    private String contact_plaats;

    @Column(name = "contact_land")
    private String contact_land;

    @Column(name = "contact_relatie")
    private String contact_relatie;

    @Column(name = "contact_website")
    private String contact_website;

    public String getContact_achternaam() {
        return contact_achternaam;
    }

    public void setContact_achternaam(String contact_achternaam) {
        this.contact_achternaam = contact_achternaam;
    }

    public String getContact_voornaam() {
        return contact_voornaam;
    }

    public void setContact_voornaam(String contact_voornaam) {
        this.contact_voornaam = contact_voornaam;
    }

    public String getContact_bedrijf() {
        return contact_bedrijf;
    }

    public void setContact_bedrijf(String contact_bedrijf) {
        this.contact_bedrijf = contact_bedrijf;
    }

    public String getContact_straatnaam() {
        return contact_straatnaam;
    }

    public void setContact_straatnaam(String contact_straatnaam) {
        this.contact_straatnaam = contact_straatnaam;
    }

    public String getContact_postcode() {
        return contact_postcode;
    }

    public void setContact_postcode(String contact_postcode) {
        this.contact_postcode = contact_postcode;
    }

    public String getContact_plaats() {
        return contact_plaats;
    }

    public void setContact_plaats(String contact_plaats) {
        this.contact_plaats = contact_plaats;
    }

    public String getContact_land() {
        return contact_land;
    }

    public void setContact_land(String contact_land) {
        this.contact_land = contact_land;
    }

    public String getContact_relatie() {
        return contact_relatie;
    }

    public void setContact_relatie(String contact_relatie) {
        this.contact_relatie = contact_relatie;
    }

    public String getContact_website() {
        return contact_website;
    }

    public void setContact_website(String contact_website) {
        this.contact_website = contact_website;
    }

    public ContactPerson() {}

    public String getName() {
        return contact_voornaam + contact_achternaam;
    }
}