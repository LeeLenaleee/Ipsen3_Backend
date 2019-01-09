package nl.hsleiden.model;

import javax.persistence.*;

/**
 * @author Kasper
 */
@Entity
@Table(name = "contactpersoon")
public class ContactPersoonModel extends BaseModel {
    @Column(name = "contact_achternaam")
    private String contactAchternaam;

    @Column(name = "contact_voornaam")
    private String contactVoornaam;

    @Column(name = "contact_bedrijf")
    private String contactBedrijf;

    @Column(name = "contact_straatnaam")
    private String contactStraatnaam;

    @Column(name = "contact_postcode")
    private String contactPostcode;

    @Column(name = "contact_plaats")
    private String contactPlaats;

    @Column(name = "contact_land")
    private String contactLand;

    @Column(name = "contact_relatie")
    private String contactRelatie;

    @Column(name = "contact_website")
    private String contactWebsite;

    public String getContactAchternaam() {
        return contactAchternaam;
    }

    public void setContactAchternaam(String contactAchternaam) {
        this.contactAchternaam = contactAchternaam;
    }

    public String getContactVoornaam() {
        return contactVoornaam;
    }

    public void setContactVoornaam(String contactVoornaam) {
        this.contactVoornaam = contactVoornaam;
    }

    public String getContactBedrijf() {
        return contactBedrijf;
    }

    public void setContactBedrijf(String contactBedrijf) {
        this.contactBedrijf = contactBedrijf;
    }

    public String getContactStraatnaam() {
        return contactStraatnaam;
    }

    public void setContactStraatnaam(String contactStraatnaam) {
        this.contactStraatnaam = contactStraatnaam;
    }

    public String getContactPostcode() {
        return contactPostcode;
    }

    public void setContactPostcode(String contactPostcode) {
        this.contactPostcode = contactPostcode;
    }

    public String getContactPlaats() {
        return contactPlaats;
    }

    public void setContactPlaats(String contactPlaats) {
        this.contactPlaats = contactPlaats;
    }

    public String getContactLand() {
        return contactLand;
    }

    public void setContactLand(String contactLand) {
        this.contactLand = contactLand;
    }

    public String getContactRelatie() {
        return contactRelatie;
    }

    public void setContactRelatie(String contactRelatie) {
        this.contactRelatie = contactRelatie;
    }

    public String getContactWebsite() {
        return contactWebsite;
    }

    public void setContactWebsite(String contactWebsite) {
        this.contactWebsite = contactWebsite;
    }
}