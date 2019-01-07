package nl.hsleiden.model;


import javax.persistence.*;

@Entity
@Table(name = "telefoonnummer")
public class TelefoonnummerModel extends BaseModel{
    @Column(name = "telnr")
    private String telnr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="contact_id")
    private ContactPersoonModel contactId;

    public String getTelnr() {
        return telnr;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

    public ContactPersoonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersoonModel contactId) {
        this.contactId = contactId;
    }
}
