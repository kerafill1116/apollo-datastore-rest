package org.surfnet.oaaas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representation of the server hosting the protected resources, capable of
 * accepting and responding to protected resource requests using access tokens.
 */
@SuppressWarnings("serial")
@Entity
@Table(name="resourceowner", uniqueConstraints =
@UniqueConstraint(columnNames = {"username"})
)
@XmlRootElement
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public class ResourceOwner extends AbstractEntity {

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password; // TODO -- store encrypted

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
