package org.surfnet.oaaas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean representation of a Access Token response.
 * See <a href="https://tools.ietf.org/html/draft-ietf-oauth-v2-30#section-4.1.3">this
 * section</a> of the spec for more info.
 *
 */
@XmlRootElement
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AccessTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private long expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String scope;

    public AccessTokenResponse() {
        super();
    }

    public AccessTokenResponse(String accessToken, String tokenType, long expiresIn, String refreshToken, String scope) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
    }

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken
     *          the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return the tokenType
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * @param tokenType
     *          the tokenType to set
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * @return the expiresIn
     */
    public long getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn
     *          the expiresIn to set
     */
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
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
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     *          the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AccessTokenResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn + ", refreshToken=" + refreshToken + ", scope=" + scope + "]";
    }
}
