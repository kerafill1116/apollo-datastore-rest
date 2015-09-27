package org.surfnet.oaaas.repository;

import java.util.List;

import org.surfnet.oaaas.model.ResourceServer;

public interface ResourceServerRepository {

    List<ResourceServer> findByOwner(String owner);

    ResourceServer findByIdAndOwner(Long id, String owner);

    ResourceServer findByKey(String key);
}
