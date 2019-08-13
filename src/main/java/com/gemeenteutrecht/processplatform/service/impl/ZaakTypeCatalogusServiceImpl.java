package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;
import com.gemeenteutrecht.processplatform.domain.catalogus.response.impl.StatusTypeListResponseImpl;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ZaakTypeCatalogusServiceImpl implements ZaakTypeCatalogusService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String token;
    private final NlxEndpointProperties endpointProperties;

    public ZaakTypeCatalogusServiceImpl(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            NlxEndpointProperties endpointProperties,
            @Value("jwt.token.zaak") String token
    ) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.endpointProperties = endpointProperties;
        this.token = token;
    }

    @Override
    public List<StatusType> getZakenTypes(UUID catalog, UUID zaakType) {
        final HttpEntity entity = new HttpEntity<>(getHeaders());

        // URI (URL) parameters
        Map<String, String> uriParams = Map.ofEntries(
                Map.entry("catalogus_uuid", catalog.toString()),
                Map.entry("zaaktype_uuid", zaakType.toString())
        );

        final UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(endpointProperties.getCatalogusZaakType());

        final ResponseEntity<String> response = restTemplate.exchange(
                builder.buildAndExpand(uriParams).toUri(),
                HttpMethod.GET,
                entity,
                String.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                return mapper.readValue(response.getBody(), StatusTypeListResponseImpl.class).results();
            } catch (IOException e) {
                throw new RuntimeException("Parsing error " + e.getMessage(), e);
            }
        } else {
            throw new RuntimeException("Error while performing GET on /status with code: " + response.getStatusCode());
        }
    }

    private HttpHeaders getHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        headers.add("Accept-Crs", "EPSG:4326");
        headers.add("Content-Crs", "EPSG:4326");

        return headers;
    }


}
