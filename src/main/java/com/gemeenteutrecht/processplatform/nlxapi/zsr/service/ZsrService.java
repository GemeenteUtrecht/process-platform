package com.gemeenteutrecht.processplatform.nlxapi.zsr.service;

import com.gemeenteutrecht.processplatform.domain.Zaak;

import java.util.List;

public interface ZsrService {

    List<Zaak> getZaken();

    void createZaak(Zaak zaak);

}
