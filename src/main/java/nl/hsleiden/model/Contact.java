package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;

public class Contact {

    @NotEmpty
    @Length(min = 1)
    @JsonView(View.Public.class)
    private Integer contactId;

    @NotEmpty
    @Length(min = 3, max = 20)
    @JsonView(View.Public.class)
    private String voornaam;

    @NotEmpty
    @Length(min = 3, max = 20)
    @JsonView(View.Public.class)
    private String achternaam;

    @NotEmpty
    @Length(min = 3, max = 50)
    @JsonView(View.Public.class)
    private String company;

//    @NotEmpty
//    @Length(min = 1)
    @JsonView(View.Public.class)
    private ArrayList<String> phoneNumbers = new ArrayList<>();

//    @NotEmpty
//    @Length(min = 1)
    @JsonView(View.Public.class)
    private ArrayList<String> emails = new ArrayList<>();

    @NotEmpty
//    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private Plaats plaats;

    @NotEmpty
    @Length(min = 3, max = 30)
    @JsonView(View.Public.class)
    private String relatie;

    @NotEmpty
    @Length(min = 4)
    @JsonView(View.Public.class)
    private String website;

    public Contact() {
    }

    public Contact(Integer contactId, String voornaam, String achternaam, String company,
                   ArrayList<String> phoneNumbers, ArrayList<String> emails,
                   Plaats plaats, String relatie, String website) {
        this.contactId = contactId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.company = company;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.plaats = plaats;
        this.relatie = relatie;
        this.website = website;
    }

    public Contact(Integer contactId, String voornaam, String achternaam,
                   String company, Plaats plaats, String relatie, String website) {

        this.contactId = contactId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.company = company;
        this.plaats = plaats;
        this.relatie = relatie;
        this.website = website;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public Plaats getPlaats() {
        return plaats;
    }

    public void setPlaats(Plaats plaats) {
        this.plaats = plaats;
    }

    public String getRelatie() {
        return relatie;
    }

    public void setRelatie(String relatie) {
        this.relatie = relatie;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
