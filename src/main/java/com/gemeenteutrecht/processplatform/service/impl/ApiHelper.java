package com.gemeenteutrecht.processplatform.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class ApiHelper {

    protected static HttpHeaders headers(String token) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        headers.add("Accept-Crs", "EPSG:4326");
        headers.add("Content-Crs", "EPSG:4326");
        return headers;
    }

}
