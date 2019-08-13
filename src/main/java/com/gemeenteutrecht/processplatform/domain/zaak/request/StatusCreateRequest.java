package com.gemeenteutrecht.processplatform.domain.zaak.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDateTime;

public interface StatusCreateRequest {

    @JsonProperty
    URI zaak();

    @JsonProperty
    URI statusType();

    @JsonProperty
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    LocalDateTime datumStatusGezet();

    @JsonProperty
    String statustoelichting();

}
