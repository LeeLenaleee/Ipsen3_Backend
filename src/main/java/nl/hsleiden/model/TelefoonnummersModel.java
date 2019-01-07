package nl.hsleiden.model;


import javax.persistence.*;

@Entity
@Table(name = "telefoonnummers")
public class TelefoonnummersModel extends BaseModel{
    @Column(name = "telnr")
    private String telnr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="contact_id")
    private ContactPersonModel contactId;

    public String getTelnr() {
        return telnr;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

    public ContactPersonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersonModel contactId) {
        this.contactId = contactId;
    }
}
