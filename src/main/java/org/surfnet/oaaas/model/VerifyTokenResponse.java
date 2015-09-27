package org.surfnet.oaaas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.surfnet.oaaas.auth.principal.AuthenticatedPrincipal;

@SuppressWarnings("serial")
@XmlRootElement
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VerifyTokenResponse implements Serializable {
    /*
     * The application that is the intended target of the token.
     */
    private String audience;
    /*
     * The space delimited set of scopes that the user consented to.
     */
    private List<String> scopes;
    /*
     * The principal
     */
    private AuthenticatedPrincipal principal;
    /*
     * The number of seconds left in the lifetime of the token.
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /*
     * If the token is no good then we return with an error
     */
    private String error;

    public VerifyTokenResponse() {
        super();
    }

    public VerifyTokenResponse(String error) {
        super();
        this.error = error;
    }

    public VerifyTokenResponse(String audience, List<String> scopes, AuthenticatedPrincipal principal, Long expiresIn) {
        super();
        this.audience = audience;
        this.scopes = scopes;
        this.principal = principal;
        this.expiresIn = expiresIn;
    }

    /**
     * @return the audience
     */
    public String getAudience() {
        return audience;
    }

    /**
     * @param audience
     *          the audience to set
     */
    public void setAudience(String audience) {
        this.audience = audience;
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
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     *          the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the expiresIn
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn the expiresIn to set
     */
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @return the principal
     */
    public AuthenticatedPrincipal getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(AuthenticatedPrincipal principal) {
        this.principal = principal;
    }
}
