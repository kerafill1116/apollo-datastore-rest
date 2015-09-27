package org.surfnet.oaaas.repository;

import java.util.List;

import org.surfnet.oaaas.model.Client;
import org.surfnet.oaaas.model.ResourceServer;

public interface ClientRepository {

    List<Client> findByResourceServer(ResourceServer resourceServer);

    Client findByIdAndResourceServer(Long id, ResourceServer resourceServer);

    Client findByClientId(String clientId);
}
