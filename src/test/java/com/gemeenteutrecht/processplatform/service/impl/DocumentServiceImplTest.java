package com.gemeenteutrecht.processplatform.service.impl;

import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import com.gemeenteutrecht.processplatform.domain.document.request.impl.DocumentRequestImpl;
import com.gemeenteutrecht.processplatform.service.DocumentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertNotNull;

public class DocumentServiceImplTest {

    private DocumentService documentService;
    private RestTemplate restTemplate;
    private NlxEndpointProperties endpointProperties;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        endpointProperties = new NlxEndpointProperties();
        endpointProperties.setDocument("http://localhost:12018/gemeente-utrecht/drc/objectinformatieobjecten");
        documentService = new DocumentServiceImpl(restTemplate, endpointProperties);
    }

    @Test
    public void createDocument() {
        DocumentRequestImpl documentRequest = new DocumentRequestImpl(
                URI.create("http://example.com"),
                URI.create("http://gemma-zrc.k8s.dc1.proeftuin.utrecht.nl/api/v1/zaken/73bd9e00-18c9-4b05-9ed0-b78afd372a9e"),
                ObjectType.zaak);
        Document document = documentService.createDocument(documentRequest);
        assertNotNull(document);
    }

}
