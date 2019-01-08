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
    @Column(name = "emailAddress")
    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAddress;

    @Column(name = "password")
    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String password;

    @Column(name = "role")
    @JsonView(View.Public.class)
    private String role;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean hasRole(String roleName) {
        if (role != null) {
            if (roleName.equals(role)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(GebruikerModel gebruikerModel) {
        return emailAddress.equals(gebruikerModel.getEmailAddress());
    }

    @Override
    public String getName() {
        return null;
    }
}