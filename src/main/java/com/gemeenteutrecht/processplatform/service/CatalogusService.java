package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;

import java.net.URI;
import java.util.List;

public interface CatalogusService {

    List<Zaak> getZakenType(URI catalogs, URI zaakType);

}
