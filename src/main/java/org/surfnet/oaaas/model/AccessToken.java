package org.surfnet.oaaas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.surfnet.oaaas.auth.principal.AuthenticatedPrincipal;

/**
 * Representation of an <a
 * href="http://tools.ietf.org/html/draft-ietf-oauth-v2-30#section-1.4"
 * >AccessToken</a>
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "accesstoken")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AccessToken extends AbstractEntity {

    @Column(unique = true)
    @NotNull
    private String token;

    @Column(unique = true, nullable = true)
    private String refreshToken;

    @Transient
    @XmlTransient
    private AuthenticatedPrincipal principal;

    @Lob
    @Column(length = 16384)
    @NotNull
    @XmlTransient
    private String encodedPrincipal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, updatable = false)
    @XmlTransient
    private Client client;

    /**
     * Absolute point in time (ms since epoch) when token expires.
     */
    @Column
    @XmlTransient
    private long expires;

    @ElementCollection(fetch= FetchType.EAGER)
    private List<String> scopes;

    @Column
    @NotNull
    private String resourceOwnerId;

    public AccessToken() {
        super();
    }

    public AccessToken(String token, AuthenticatedPrincipal principal, Client client, long expires, List<String> scopes) {
        this(token, principal, client, expires, scopes, null);
    }

    public AccessToken(String token, AuthenticatedPrincipal principal, Client client, long expires, List<String> scopes,
                       String refreshToken) {
        super();
        this.token = token;
        this.principal = principal;
        this.encodePrincipal();
        this.resourceOwnerId = principal.getName();
        this.client = client;
        this.expires = expires;
        this.scopes = scopes;
        this.refreshToken = refreshToken;
        invariant();
    }

    private void invariant() {
        Validate.notNull(token, "Token may not be null");
        Validate.notNull(client, "Client may not be null");
        Validate.notNull(principal, "AuthenticatedPrincipal may not be null");
        Validate.isTrue(StringUtils.isNotBlank(principal.getName()), "AuthenticatedPrincipal#name may not be null");
    }

    @PreUpdate
    @PrePersist
    public void encodePrincipal() {
        if (principal != null) {
            this.encodedPrincipal = principal.serialize();
        }
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void decodePrincipal() {
        if (StringUtils.isNotBlank(encodedPrincipal)) {
            this.principal = AuthenticatedPrincipal.deserialize(encodedPrincipal);
        }
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *          the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client
     *          the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the absolute point in time when this token expires. Use {@link #getExpiresIn()} in external communication.
     * @see #getExpiresIn()
     */
    public long getExpires() {
        return expires;
    }


    /**
     * Nr of seconds relative to 'now', when token is to expire.
     * @see #getExpires()
     */
    @XmlElement
    public long getExpiresIn() {
        if (expires == 0L) {
            return 0L;
        } else {
            long currInMs = System.currentTimeMillis();
            return Math.round((expires - currInMs) / 1000.0);
        }
    }

    /**
     * @param expires
     *          the expires to set
     */
    public void setExpires(long expires) {
        this.expires = expires;
    }

    /**
     * @return the scopes
     */
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * @param scopes
     *          the scopes to set
     */
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * @return the principal
     */
    public AuthenticatedPrincipal getPrincipal() {
        return principal;
    }

    /**
     * @return the encodedPrincipal
     */
    public String getEncodedPrincipal() {
        return encodedPrincipal;
    }

    /**
     * @return the refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken
     *          the refreshToken to set
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return the resourceOwnerId
     */
    public String getResourceOwnerId() {
        return resourceOwnerId;
    }

    @XmlElement
    public String getClientId() {
        return client.getClientId();
    }
}
