package com.gemeenteutrecht.processplatform.domain.zaak.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public interface ZaakCreateRequest {

    @JsonProperty
    String bronorganisatie(); //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    URI zaaktype(); //[ 1 .. 1000 ] characters
    @JsonProperty
    String verantwoordelijkeOrganisatie(); // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    String startdatum();

}
