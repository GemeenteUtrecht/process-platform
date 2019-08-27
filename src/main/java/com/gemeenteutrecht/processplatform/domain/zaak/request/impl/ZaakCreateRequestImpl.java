package com.gemeenteutrecht.processplatform.domain.zaak.request.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;

import java.net.URI;
import java.time.LocalDate;

public class ZaakCreateRequestImpl implements ZaakCreateRequest {

    private String bronorganisatie; //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    private URI zaaktype;
    private String verantwoordelijkeOrganisatie; // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    private LocalDate startdatum;

    public ZaakCreateRequestImpl(
        String bronorganisatie,
        URI zaaktype,
        String verantwoordelijkeOrganisatie,
        LocalDate startdatum
    ) {
        this.bronorganisatie = bronorganisatie;
        this.zaaktype = zaaktype;
        this.verantwoordelijkeOrganisatie = verantwoordelijkeOrganisatie;
        this.startdatum = startdatum;
    }

    @Override
    public String bronorganisatie() {
        return bronorganisatie;
    }

    @Override
    public URI zaaktype() {
        return zaaktype;
    }

    @Override
    public String verantwoordelijkeOrganisatie() {
        return verantwoordelijkeOrganisatie;
    }

    @Override
    public LocalDate startdatum() {
        return startdatum;
    }
}
