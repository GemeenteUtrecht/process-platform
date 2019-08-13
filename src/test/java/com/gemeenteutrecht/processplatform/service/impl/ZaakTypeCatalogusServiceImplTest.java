package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.config.RestTemplateConfiguration;
import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class ZaakTypeCatalogusServiceImplTest {

    private ZaakTypeCatalogusService zaakTypeCatalogusService;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private NlxEndpointProperties nlxEndpointProperties;
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImNsaWVudF9pZGVudGlmaWVyIjoicml0ZW5zZSJ9.eyJpc3MiOiJkb2NzLVU1b2FIaGYxQTJUWCIsImlhdCI6MTU0MzI0NjkwNywiemRzIjp7InNjb3BlcyI6WyJ6ZHMuc2NvcGVzLnpha2VuLmxlemVuIiwiemRzLnNjb3Blcy56YWtlbi5hYW5tYWtlbiIsInpkcy5zY29wZXMuemFrZW4uYmlqd2Vya2VuIiwiemRzLnNjb3Blcy56YWFrdHlwZXMubGV6ZW4iLCJ6ZHMuc2NvcGVzLnN0YXR1c3Nlbi50b2V2b2VnZW4iXSwiemFha3R5cGVzIjpbIioiXX19.YQWGsb295I6jAN6Etv7lNaPaD4sxRvWILe9oY-17XYk";

    @Before
    public void setUp() {
        restTemplate = new RestTemplateConfiguration().restTemplate(new RestTemplateBuilder());
        objectMapper = new ObjectMapper();
        nlxEndpointProperties = new NlxEndpointProperties();
        nlxEndpointProperties.setCatalogusZaakType("http://localhost:12018/gemeente-utrecht/ztc/catalogussen/{catalogus_uuid}/zaaktypen/{zaaktype_uuid}/statustypen");
        zaakTypeCatalogusService = new ZaakTypeCatalogusServiceImpl(restTemplate, objectMapper, nlxEndpointProperties, token);
    }

    @Test
    public void shouldGetZakenTypes() {
        UUID catalog = UUID.fromString("28487d3f-6a1b-489c-b03d-c75ac6693e72");
        UUID zaakType = UUID.fromString("7af2d4dd-511b-4b27-89a8-77ac7c8e7a82");
        List<StatusType> zakenTypes = zaakTypeCatalogusService.getZakenTypes(catalog, zaakType);
        assertNotNull(zakenTypes);
    }

}
