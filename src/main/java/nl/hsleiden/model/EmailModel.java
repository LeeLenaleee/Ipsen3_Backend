package nl.hsleiden.model;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class EmailModel extends BaseModel{
    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contact_id")
    private ContactPersonModel contactId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactPersonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersonModel contactId) {
        this.contactId = contactId;
    }
}
