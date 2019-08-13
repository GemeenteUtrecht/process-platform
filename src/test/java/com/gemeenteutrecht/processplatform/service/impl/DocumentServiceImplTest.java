package com.gemeenteutrecht.processplatform.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.service.DocumentService;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class DocumentServiceImplTest {

    private DocumentService documentService;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private final String url = "http://localhost:12018/gemeente-utrecht/drc/objectinformatieobjecten";
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImNsaWVudF9pZGVudGlmaWVyIjoicml0ZW5zZSJ9.eyJpc3MiOiJkb2NzLVU1b2FIaGYxQTJUWCIsImlhdCI6MTU0MzI0NjkwNywiemRzIjp7InNjb3BlcyI6WyJ6ZHMuc2NvcGVzLnpha2VuLmxlemVuIiwiemRzLnNjb3Blcy56YWtlbi5hYW5tYWtlbiJdLCJ6YWFrdHlwZXMiOlsiKiJdfX0.FvF76GZjd7XRmfWUSsbJUsDAemISwOhex8MYvfQNv1Y";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        documentService = new DocumentServiceImpl(restTemplate, objectMapper, url, token);
    }

    @Test
    public void createDocument() {
    }
}
