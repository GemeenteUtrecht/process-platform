package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.resultaat.Resultaat;
import com.gemeenteutrecht.processplatform.domain.resultaat.request.ResultaatRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakStatusImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.ListResponse;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface ZaakService<T_ZAAK_IMPL> {

    ListResponse getZaken();

    T_ZAAK_IMPL getZaak(UUID id);

    T_ZAAK_IMPL createZaak(ZaakCreateRequest zaak);

    Document createDocument(Document documentRequest);

    List<ZaakStatusImpl> getStatussen(URI zaak);

    ZaakStatusImpl setStatus(StatusCreateRequestImpl statusCreateRequest);

    Resultaat setResultaat(ResultaatRequest resultaatRequest);

}
