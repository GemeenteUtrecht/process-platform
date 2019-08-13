package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakStatusImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.impl.StatusListResponseImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.impl.ZaakListResponse;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class ZaakServiceImpl implements ZaakService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String token;
    private final NlxEndpointProperties endpointProperties;

    public ZaakServiceImpl(
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
    public List<Zaak> getZaken() {
        final HttpEntity entity = new HttpEntity<>(getHeaders());

        final ResponseEntity<String> response = restTemplate.exchange(
                endpointProperties.getZaak(),
                HttpMethod.GET,
                entity,
                String.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                return mapper.readValue(response.getBody(), ZaakListResponse.class).results();
            } catch (IOException e) {
                throw new RuntimeException("Parsing error " + e.getMessage(), e);
            }
        } else {
            throw new RuntimeException("Error while performing GET on /zaken with code: " + response.getStatusCode());
        }
    }

    @Override
    public Zaak createZaak(ZaakCreateRequestImpl zaakCreateRequest) {
        final HttpEntity<ZaakCreateRequestImpl> request = new HttpEntity<>(zaakCreateRequest, getHeaders());

        ResponseEntity<ZaakImpl> response = restTemplate.exchange(
                endpointProperties.getZaak(),
                HttpMethod.POST,
                request,
                ZaakImpl.class
        );
        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing POST on /zaak with code: " + response.getStatusCode());
        }
    }

    @Override
    public ZaakStatusImpl setStatus(StatusCreateRequestImpl statusCreateRequest) {
        final HttpEntity request = new HttpEntity<>(statusCreateRequest, getHeaders());

        final ResponseEntity<ZaakStatusImpl> response = restTemplate.exchange(
                endpointProperties.getStatus(),
                HttpMethod.POST,
                request,
                ZaakStatusImpl.class
        );
        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing GET on /status with code: " + response.getStatusCode());
        }
    }

    @Override
    public List<ZaakStatus> getStatussen(URI zaak) {
        final HttpEntity entity = new HttpEntity<>(getHeaders());
        final UriComponentsBuilder builder = UriComponentsBuilder.fromUri(endpointProperties.getStatus())
                .queryParam("zaak", zaak.toString());

        final ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                return mapper.readValue(response.getBody(), StatusListResponseImpl.class).results();
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
