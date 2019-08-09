package com.gemeenteutrecht.processplatform.nlxapi.zsr.service;

import com.gemeenteutrecht.processplatform.domain.Zaak;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ZsrServiceImpl implements ZsrService {

    RestTemplate restTemplate;

    private final String url = "http://localhost:8080/spring-rest/foos";

    @Override
    public List<Zaak> getZaken() {
        return null;
    }

    @Override
    public void createZaak(Zaak zaak) {

    }
}
