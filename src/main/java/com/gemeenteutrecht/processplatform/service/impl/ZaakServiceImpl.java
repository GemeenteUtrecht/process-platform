package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
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

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class ZaakServiceImpl implements ZaakService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String url;
    private final String token;

    public ZaakServiceImpl(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("url.zaken") String url,
            @Value("jwt.token.zaak") String token
    ) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.url = url;
        this.token = token;
    }

    @Override
    public List<Zaak> getZaken() throws IOException {
        final HttpEntity entity = new HttpEntity<>(getHeaders());

        final ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return mapper.readValue(response.getBody(), ZaakListResponse.class).results();
        } else {
            throw new RuntimeException("Error while performing GET on /zaken with code: " + response.getStatusCode());
        }
    }

    @Override
    public Zaak createZaak(ZaakCreateRequest zaak) {
        final HttpEntity<ZaakCreateRequest> request = new HttpEntity<>(zaak, getHeaders());

        ResponseEntity<ZaakImpl> response = restTemplate.exchange(
                url,
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
