package org.surfnet.oaaas.repository;

import org.surfnet.oaaas.model.AccessToken;
import org.surfnet.oaaas.model.Client;

import java.util.List;

public interface AccessTokenRepository {

    AccessToken findByToken(String token);

    AccessToken findByTokenAndClient(String token, Client client);

    AccessToken findByRefreshToken(String refreshToken);

    List<AccessToken> findByResourceOwnerIdAndClient(String resourceOwnerId, Client client);

    List<AccessToken> findByResourceOwnerId(String resourceOwnerId);

    AccessToken findByIdAndResourceOwnerId(Long id, String owner);

    //@Query(value = "select count(distinct resourceOwnerId) from accesstoken where client_id = ?1", nativeQuery = true)
    Number countByUniqueResourceOwnerIdAndClientId(long clientId);

    //@Transactional
    void delete(AccessToken token);

    //@Query(value="select * from accesstoken where expires > 0 and expires < ?1", nativeQuery = true)
    List<AccessToken> findByMaxExpires(long expiresBoundary);
}
