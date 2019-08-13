package com.gemeenteutrecht.processplatform.domain.zaak.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface ZaakCreateRequest {

    @JsonProperty
    String bronorganisatie(); //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef

    @JsonProperty
    URI zaaktype(); //[ 1 .. 1000 ] characters

    @JsonProperty
    String verantwoordelijkeOrganisatie(); // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef

    @JsonProperty
    @JsonFormat(pattern = "YYYY-MM-dd")
    LocalDate startdatum();

}
