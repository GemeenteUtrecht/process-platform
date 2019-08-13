package com.gemeenteutrecht.processplatform.domain.catalogus;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public interface StatusType {

    @JsonProperty
    URI url();

    @JsonProperty
    String omschrijving();

    @JsonProperty
    String omschrijvingGeneriek();

    @JsonProperty
    String statustekst();

    @JsonProperty
    URI zaaktype();

    @JsonProperty
    Integer volgnummer();

    @JsonProperty
    Boolean isEindstatus();

}
