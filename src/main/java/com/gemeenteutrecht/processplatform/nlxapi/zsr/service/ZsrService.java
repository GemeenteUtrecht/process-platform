package com.gemeenteutrecht.processplatform.nlxapi.zsr.service;

import com.gemeenteutrecht.processplatform.nlxapi.zsr.domain.Zaak;

import java.util.List;

public interface ZsrService {

    List<Zaak> getZaken();

    void postZaak(Zaak zaak);

    List<Result> getResultaten
}
