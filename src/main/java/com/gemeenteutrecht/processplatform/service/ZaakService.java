package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.Zaak;
import com.gemeenteutrecht.processplatform.service.dto.ZaakRequest;

import java.io.IOException;
import java.util.List;

public interface ZaakService {

    List<Zaak> getZaken() throws IOException;

    Zaak createZaak(ZaakRequest zaak) throws IOException;

}
