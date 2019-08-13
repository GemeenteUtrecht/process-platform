package com.gemeenteutrecht.processplatform.domain.zaak.request.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ZaakCreateRequestImpl implements ZaakCreateRequest {

    @JsonProperty
    private String bronorganisatie; //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    private URI zaaktype; //[ 1 .. 1000 ] characters
    @JsonProperty
    private String verantwoordelijkeOrganisatie; // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    private String startdatum;

    public ZaakCreateRequestImpl(String bronorganisatie, URI zaaktype, String verantwoordelijkeOrganisatie, LocalDate startdatum) {
        this.bronorganisatie = bronorganisatie;
        this.zaaktype = zaaktype;
        this.verantwoordelijkeOrganisatie = verantwoordelijkeOrganisatie;
        this.startdatum = startdatum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
