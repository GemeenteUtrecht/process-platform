package com.gemeenteutrecht.processplatform.domain.resultaat.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface ResultaatRequest {

    @JsonProperty
    URI zaak();

    @JsonProperty
    URI resultaatType();

    @JsonProperty
    String toelichting();
}
