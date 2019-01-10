package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.security.Principal;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 *
 * @author Peter van Vliet
 */
@Entity
@Table(name = "gebruiker")
public class GebruikerModel extends BaseModel implements Principal
{
    @Column(name = "email_adres")
    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAdres;

    @Column(name = "gebruikersnaam")
    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String gebruikersnaam;

    @Column(name = "wachtwoord")
    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String wachtwoord;

    @Column(name = "rol")
    @JsonView(View.Public.class)
    private String rol;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean hasRol(String rolName) {
        if (rol != null) {
            if (rolName.equals(rol)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(GebruikerModel gebruikerModel) {
        return emailAdres.equals(gebruikerModel.getEmailAdres());
    }

    @Override
    public String getName() {
        return null;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }
}