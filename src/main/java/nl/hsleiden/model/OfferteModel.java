package nl.hsleiden.model;

import javax.persistence.*;

@Entity
@Table(name = "offerte")
public class OfferteModel extends BaseModel{
    @Column(name = "opdracht_omschrijving")
    private String opdrachtOmschrijving;

    @Column(name = "opdracht_afrondingsdatum")
    private String opdrachtAfrondingsDatum;

    @Column(name = "opdracht_kosten")
    private double opdrachtKosten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="contact_id")
    private ContactPersonModel contactId;

    public String getOpdrachtOmschrijving() {
        return opdrachtOmschrijving;
    }

    public void setOpdrachtOmschrijving(String opdrachtOmschrijving) {
        this.opdrachtOmschrijving = opdrachtOmschrijving;
    }

    public String getOpdrachtAfrondingsDatum() {
        return opdrachtAfrondingsDatum;
    }

    public void setOpdrachtAfrondingsDatum(String opdrachtAfrondingsDatum) {
        this.opdrachtAfrondingsDatum = opdrachtAfrondingsDatum;
    }

    public double getOpdrachtKosten() {
        return opdrachtKosten;
    }

    public void setOpdrachtKosten(double opdrachtKosten) {
        this.opdrachtKosten = opdrachtKosten;
    }

    public ContactPersonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersonModel contactId) {
        this.contactId = contactId;
    }
}
