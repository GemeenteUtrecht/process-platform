package com.gemeenteutrecht.processplatform.domain.impl;

import com.gemeenteutrecht.processplatform.domain.ArchiefNominatie;
import com.gemeenteutrecht.processplatform.domain.ArchiefStatus;
import com.gemeenteutrecht.processplatform.domain.Geometrie;
import com.gemeenteutrecht.processplatform.domain.Kenmerk;
import com.gemeenteutrecht.processplatform.domain.Opschorting;
import com.gemeenteutrecht.processplatform.domain.Verlenging;
import com.gemeenteutrecht.processplatform.domain.Zaak;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * see https://directory.demo.nlx.io/documentation/gemeente-utrecht/zrc#operation/zaak_create
 */
public class ZaakImpl implements Zaak {

    final String bronorganisatie; //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    final URI zaaktype; //[ 1 .. 1000 ] characters
    final String verantwoordelijkeOrganisatie; // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    final LocalDate startdatum;

    public ZaakImpl(String bronorganisatie, URI zaaktype, String verantwoordelijkeOrganisatie, LocalDate startdatum) {
        this.bronorganisatie = bronorganisatie;
        this.zaaktype = zaaktype;
        this.verantwoordelijkeOrganisatie = verantwoordelijkeOrganisatie;
        this.startdatum = startdatum;
    }

    @Override
    public String identificatie() {
        return null;
    }

    @Override
    public String bronorganisatie() {
        return bronorganisatie;
    }

    @Override
    public String omschrijving() {
        return null;
    }

    @Override
    public String toelichting() {
        return null;
    }

    @Override
    public URI zaaktype() {
        return zaaktype;
    }

    @Override
    public LocalDate registratiedatum() {
        return null;
    }

    @Override
    public String verantwoordelijkeOrganisatie() {
        return verantwoordelijkeOrganisatie;
    }

    @Override
    public LocalDate startdatum() {
        return startdatum;
    }

    @Override
    public LocalDate einddatumGepland() {
        return null;
    }

    @Override
    public LocalDate uiterlijkeEinddatumAfdoening() {
        return null;
    }

    @Override
    public LocalDate publicatiedatum() {
        return null;
    }

    @Override
    public URI communicatiekanaal() {
        return null;
    }

    @Override
    public List<URI> productenOfDiensten() {
        return null;
    }

    @Override
    public String vertrouwelijkheidaanduiding() {
        return null;
    }

    @Override
    public String betalingsindicatie() {
        return null;
    }

    @Override
    public LocalDateTime laatsteBetaaldatum() {
        return null;
    }

    @Override
    public Geometrie geometrie() {
        return null;
    }

    @Override
    public Verlenging verlenging() {
        return null;
    }

    @Override
    public Opschorting opschorting() {
        return null;
    }

    @Override
    public URI selectielijstklasse() {
        return null;
    }

    @Override
    public URI hoofdzaak() {
        return null;
    }

    @Override
    public List<URI> relevanteAndereZaken() {
        return null;
    }

    @Override
    public List<Kenmerk> kenmerken() {
        return null;
    }

    @Override
    public ArchiefNominatie archiefNominatie() {
        return null;
    }

    @Override
    public ArchiefStatus archiefStatus() {
        return null;
    }

    @Override
    public LocalDate archiefActieDatum() {
        return null;
    }
}
