package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ZaakServiceImplTest {

    private ZaakService zaakService;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private NlxEndpointProperties nlxEndpointProperties;
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImNsaWVudF9pZGVudGlmaWVyIjoicml0ZW5zZSJ9.eyJpc3MiOiJkb2NzLVU1b2FIaGYxQTJUWCIsImlhdCI6MTU0MzI0NjkwNywiemRzIjp7InNjb3BlcyI6WyJ6ZHMuc2NvcGVzLnpha2VuLmxlemVuIiwiemRzLnNjb3Blcy56YWtlbi5hYW5tYWtlbiJdLCJ6YWFrdHlwZXMiOlsiKiJdfX0.FvF76GZjd7XRmfWUSsbJUsDAemISwOhex8MYvfQNv1Y";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        nlxEndpointProperties = new NlxEndpointProperties();
        nlxEndpointProperties.setZaak(URI.create("http://localhost:12018/gemeente-utrecht/zrc/zaken"));
        nlxEndpointProperties.setStatus(URI.create("http://localhost:12018/gemeente-utrecht/zrc/statussen"));
        zaakService = new ZaakServiceImpl(restTemplate, objectMapper, nlxEndpointProperties, token);
    }

    @Test
    public void getZaken() {
        List<Zaak> zaken = zaakService.getZaken();
        assertNotNull(zaken);
    }

    @Test
    public void createZaak() {
        ZaakCreateRequestImpl zaakRequest = new ZaakCreateRequestImpl(
                "002220647",
                URI.create("http://gemma-ztc.k8s.dc1.proeftuin.utrecht.nl/api/v1/catalogussen/28487d3f-6a1b-489c-b03d-c75ac6693e72/zaaktypen/7af2d4dd-511b-4b27-89a8-77ac7c8e7a82"),
                "002220647",
                LocalDate.of(2019, 6, 28)
        );
        Zaak zaak = zaakService.createZaak(zaakRequest);
        assertNotNull(zaak);
    }
}
