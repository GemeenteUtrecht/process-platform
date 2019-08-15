package com.gemeenteutrecht.processplatform.service.impl;

import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.notificatie.impl.NotificatieImpl;
import com.gemeenteutrecht.processplatform.domain.notificatie.request.PublishNotificatieRequest;
import com.gemeenteutrecht.processplatform.service.NotificatieService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.gemeenteutrecht.processplatform.service.impl.ApiHelper.headers;

@Service
public class NotificatieServiceImpl implements NotificatieService {

    private final RestTemplate restTemplate;
    private final NlxEndpointProperties endpointProperties;

    public NotificatieServiceImpl(RestTemplate restTemplate, NlxEndpointProperties endpointProperties) {
        this.restTemplate = restTemplate;
        this.endpointProperties = endpointProperties;
    }

    @Override
    public NotificatieImpl publish(PublishNotificatieRequest request) {
        final HttpEntity entity = new HttpEntity<>(request, headers(endpointProperties.getToken()));

        final ResponseEntity<NotificatieImpl> response = restTemplate.exchange(
                URI.create(endpointProperties.getNotificatie()),
                HttpMethod.POST,
                entity,
                NotificatieImpl.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing POST on /notificaties with code: " + response.getStatusCode());
        }
    }
}
