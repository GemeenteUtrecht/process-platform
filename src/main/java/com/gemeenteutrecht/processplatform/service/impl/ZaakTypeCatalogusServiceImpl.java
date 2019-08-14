package com.gemeenteutrecht.processplatform.service.impl;

import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.gemeenteutrecht.processplatform.service.impl.ApiHelper.headers;

@Service
public class ZaakTypeCatalogusServiceImpl implements ZaakTypeCatalogusService {

    private final RestTemplate restTemplate;
    private final NlxEndpointProperties endpointProperties;

    public ZaakTypeCatalogusServiceImpl(RestTemplate restTemplate, NlxEndpointProperties endpointProperties) {
        this.restTemplate = restTemplate;
        this.endpointProperties = endpointProperties;
    }

    @Override
    public List<StatusTypeImpl> getZakenTypes(UUID catalog, UUID zaakType) {
        final HttpEntity entity = new HttpEntity<>(headers(endpointProperties.getToken()));

        final Map<String, String> uriParams = Map.ofEntries(
                Map.entry("catalogus_uuid", catalog.toString()),
                Map.entry("zaaktype_uuid", zaakType.toString())
        );

        final UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(endpointProperties.getCatalogusZaakType());

        final ResponseEntity<List<StatusTypeImpl>> response = restTemplate.exchange(
                builder.buildAndExpand(uriParams).toUri(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<StatusTypeImpl>>() {
                }
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing GET on /status with code: " + response.getStatusCode());
        }
    }

}
