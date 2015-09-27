package org.surfnet.oaaas.auth;

@SuppressWarnings("serial")
public class ValidationResponseException extends RuntimeException {

    public final OAuth2Validator.ValidationResponse v;

    public ValidationResponseException(OAuth2Validator.ValidationResponse v) {
        this.v = v;
    }
}
