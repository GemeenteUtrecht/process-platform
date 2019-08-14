package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakStatusImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.ListResponse;
import com.gemeenteutrecht.processplatform.domain.zaak.response.impl.ZaakListResponse;

import java.net.URI;
import java.util.List;

public interface ZaakService {

    ListResponse getZaken();

    ZaakImpl createZaak(ZaakCreateRequest zaak);

    List<ZaakStatusImpl> getStatussen(URI zaak);

    ZaakStatusImpl setStatus(StatusCreateRequestImpl statusCreateRequest);

}
