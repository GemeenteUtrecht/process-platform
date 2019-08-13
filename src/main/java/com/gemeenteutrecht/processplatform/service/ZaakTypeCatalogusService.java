package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;

import java.util.List;
import java.util.UUID;

public interface ZaakTypeCatalogusService {

    List<StatusTypeImpl> getZakenTypes(UUID catalogs, UUID zaakType);

}
