package com.gemeenteutrecht.processplatform.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ZaakRequest implements Serializable {

    @JsonProperty
    private String bronorganisatie; //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    private URI zaaktype; //[ 1 .. 1000 ] characters
    @JsonProperty
    private String verantwoordelijkeOrganisatie; // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    @JsonProperty
    private String startdatum;

    public ZaakRequest(String bronorganisatie, URI zaaktype, String verantwoordelijkeOrganisatie, LocalDate startdatum) {
        this.bronorganisatie = bronorganisatie;
        this.zaaktype = zaaktype;
        this.verantwoordelijkeOrganisatie = verantwoordelijkeOrganisatie;
        this.startdatum = startdatum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
