package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.impl.DocumentImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;
import com.gemeenteutrecht.processplatform.service.DocumentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String url;
    private final String token;//TODO token voor drc

    public DocumentServiceImpl(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("url.document") String url,
            @Value("jwt.token.document") String token
    ) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.url = url;
        this.token = token;
    }

    @Override
    public Document createDocument(DocumentRequest documentRequest) {
        final HttpEntity<DocumentRequest> request = new HttpEntity<>(documentRequest, getHeaders());

        ResponseEntity<DocumentImpl> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                DocumentImpl.class
        );
        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error while performing POST on /objectinformatieobjecten with code: "
                    + response.getStatusCode());
        }
    }

    private HttpHeaders getHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        return headers;
    }
}
