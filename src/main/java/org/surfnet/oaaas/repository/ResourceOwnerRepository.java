package org.surfnet.oaaas.repository;

import org.surfnet.oaaas.model.ResourceOwner;

public interface ResourceOwnerRepository {

    ResourceOwner findByUsername(String username);
}
