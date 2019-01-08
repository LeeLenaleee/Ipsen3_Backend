package nl.hsleiden.model;


import javax.persistence.*;

@Entity
@Table (name = "factuur")
public class FactuurModel extends BaseModel{
    @Column(name = "factuur_beschrijving")
    private String factuurBeschrijving;

    @Column(name = "factuur_status")
    private String factuurStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="offerte_id")
    private OfferteModel offerteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="contact_id")
    private ContactPersoonModel contactId;

    public String getFactuurBeschrijving() {
        return factuurBeschrijving;
    }

    public void setFactuurBeschrijving(String factuurBeschrijving) {
        this.factuurBeschrijving = factuurBeschrijving;
    }

    public String getFactuurStatus() {
        return factuurStatus;
    }

    public void setFactuurStatus(String factuurStatus) {
        this.factuurStatus = factuurStatus;
    }

    public OfferteModel getOfferteId() {
        return offerteId;
    }

    public void setOfferteId(OfferteModel offerteId) {
        this.offerteId = offerteId;
    }

    public ContactPersoonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersoonModel contactId) {
        this.contactId = contactId;
    }
}
