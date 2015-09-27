package org.surfnet.oaaas.model;

public interface TokenResponseCache {

    VerifyTokenResponse getVerifyToken(String accessToken);

    void storeVerifyToken(String accessToken, VerifyTokenResponse tokenResponse);
}
