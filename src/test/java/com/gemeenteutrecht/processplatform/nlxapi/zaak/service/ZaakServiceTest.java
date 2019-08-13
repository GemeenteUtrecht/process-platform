package com.gemeenteutrecht.processplatform.nlxapi.zaak.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.Zaak;
import com.gemeenteutrecht.processplatform.nlxapi.zaak.service.dto.ZaakRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ZaakServiceTest {

    private ZaakService zaakService;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private final String url = "http://localhost:12018/gemeente-utrecht/zrc/zaken";
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImNsaWVudF9pZGVudGlmaWVyIjoicml0ZW5zZSJ9.eyJpc3MiOiJkb2NzLVU1b2FIaGYxQTJUWCIsImlhdCI6MTU0MzI0NjkwNywiemRzIjp7InNjb3BlcyI6WyJ6ZHMuc2NvcGVzLnpha2VuLmxlemVuIiwiemRzLnNjb3Blcy56YWtlbi5hYW5tYWtlbiJdLCJ6YWFrdHlwZXMiOlsiKiJdfX0.FvF76GZjd7XRmfWUSsbJUsDAemISwOhex8MYvfQNv1Y";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        zaakService = new ZaakServiceImpl(restTemplate, objectMapper, url, token);
    }

    @Test
    public void getZaken() throws IOException {
        List<Zaak> zaken = zaakService.getZaken();
        assertNotNull(zaken);
    }

    @Test
    public void createZaak() throws IOException {
        ZaakRequest zaak = new ZaakRequest(
                "002220647",
                URI.create("http://gemma-ztc.k8s.dc1.proeftuin.utrecht.nl/api/v1/catalogussen/28487d3f-6a1b-489c-b03d-c75ac6693e72/zaaktypen/7af2d4dd-511b-4b27-89a8-77ac7c8e7a82"),
                "002220647",
                LocalDate.of(2019, 6, 28)
        );
        Zaak zaak1 = zaakService.createZaak(zaak);
        assertNotNull(zaak1);
    }

}
