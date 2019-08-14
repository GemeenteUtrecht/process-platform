package com.gemeenteutrecht.processplatform.service.impl;

import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakStatusImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.impl.ZaakListResponse;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import static com.gemeenteutrecht.processplatform.service.impl.ApiHelper.headers;

@Service
public class ZaakServiceImpl implements ZaakService {

    private final RestTemplate restTemplate;
    private final NlxEndpointProperties endpointProperties;

    public ZaakServiceImpl(RestTemplate restTemplate, NlxEndpointProperties endpointProperties) {
        this.restTemplate = restTemplate;
        this.endpointProperties = endpointProperties;
    }

    @Override
    public ZaakListResponse getZaken() {
        final HttpEntity entity = new HttpEntity<>(headers(endpointProperties.getToken()));

        final ResponseEntity<ZaakListResponse> response = restTemplate.exchange(
                endpointProperties.getZaak(),
                HttpMethod.GET,
                entity,
                ParameterizedTypeReference.forType(ZaakListResponse.class)
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing GET on /zaken with code: " + response.getStatusCode());
        }
    }

    @Override
    public ZaakImpl createZaak(ZaakCreateRequest zaakCreateRequest) {
        final HttpEntity<ZaakCreateRequest> request = new HttpEntity<>(zaakCreateRequest, headers(endpointProperties.getToken()));

        ResponseEntity<ZaakImpl> response = restTemplate.exchange(
                URI.create(endpointProperties.getZaak()),
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
        final HttpEntity request = new HttpEntity<>(statusCreateRequest, headers(endpointProperties.getToken()));

        final ResponseEntity<ZaakStatusImpl> response = restTemplate.exchange(
                URI.create(endpointProperties.getStatus()),
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
    public List<ZaakStatusImpl> getStatussen(URI zaak) {
        final HttpEntity entity = new HttpEntity<>(headers(endpointProperties.getToken()));
        final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpointProperties.getStatus())
                .queryParam("zaak", zaak.toString());

        final ResponseEntity<List<ZaakStatusImpl>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<ZaakStatusImpl>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing GET on /status with code: " + response.getStatusCode());
        }
    }

}
