package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.security.Principal;

@Table(name = "gebruiker")
@Entity
public class GebruikerModel extends BaseModel implements Principal {
    @Column(name = "email_adres")
    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAdres;

    @Column(name = "wachtwoord")
    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String wachtwoord;


    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    @JsonView(View.Public.class)
    private Role role;


    public boolean hasRole(Role role) {
        return this.role.hasRole(role);
    }

    public String getName() { return this.emailAdres; }

    public GebruikerModel() {}

    public GebruikerModel(String emailAdres, String wachtwoord, Role role) {
        this.emailAdres = emailAdres;
        this.wachtwoord = wachtwoord;
        this.role = role;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}