package org.surfnet.oaaas.repository;

import org.surfnet.oaaas.model.AuthorizationRequest;

public interface AuthorizationRequestRepository {

    AuthorizationRequest findByAuthState(String authState);
    AuthorizationRequest findByAuthorizationCode(String authorizationCode);
}
