package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;

import java.util.List;
import java.util.UUID;

public interface ZaakTypeCatalogusService {

    List<StatusType> getZakenTypes(UUID catalogs, UUID zaakType);

}
