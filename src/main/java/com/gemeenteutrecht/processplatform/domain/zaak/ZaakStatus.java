package com.gemeenteutrecht.processplatform.domain.zaak;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDateTime;

public interface ZaakStatus {

    @JsonProperty
    URI url();

    @JsonProperty
    URI zaak();

    @JsonProperty
    URI statusType();

    @JsonProperty
    LocalDateTime datumStatusGezet();

    @JsonProperty
    String statustoelichting();

}
