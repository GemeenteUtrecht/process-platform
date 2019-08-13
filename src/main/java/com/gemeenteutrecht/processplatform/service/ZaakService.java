package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;

import java.io.IOException;
import java.util.List;

public interface ZaakService {

    List<Zaak> getZaken() throws IOException;

    Zaak createZaak(ZaakCreateRequestImpl zaak) throws IOException;

}
