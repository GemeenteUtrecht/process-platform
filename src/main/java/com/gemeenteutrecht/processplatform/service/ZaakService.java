package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;
import com.gemeenteutrecht.processplatform.domain.resultaat.Resultaat;
import com.gemeenteutrecht.processplatform.domain.resultaat.request.ResultaatRequest;
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

public interface ZaakService<T_ZAAK_IMPL> {

    ListResponse getZaken();

    T_ZAAK_IMPL getZaak(String id);

    T_ZAAK_IMPL createZaak(ZaakCreateRequest zaak);

    Document createDocument(DocumentRequest documentRequest);

    List<ZaakStatusImpl> getStatussen(URI zaak);

    ZaakStatusImpl setStatus(StatusCreateRequestImpl statusCreateRequest);

    Resultaat addResultaat(ResultaatRequest resultaatRequest);

}
