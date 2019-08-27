package com.gemeenteutrecht.processplatform.domain.zaak.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.Geometrie;
import com.gemeenteutrecht.processplatform.domain.zaak.Kenmerk;
import com.gemeenteutrecht.processplatform.domain.zaak.Opschorting;
import com.gemeenteutrecht.processplatform.domain.zaak.Verlenging;
import com.gemeenteutrecht.processplatform.domain.zaak.Zaak;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * see https://directory.demo.nlx.io/documentation/gemeente-utrecht/zrc#operation/zaak_create
 */
public class ZaakImpl implements Zaak {

    private String bronorganisatie; //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    private URI zaaktype; //[ 1 .. 1000 ] characters
    private String verantwoordelijkeOrganisatie; // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef
    private LocalDate startdatum;
    private URI url;
    private String identificatie;
    private String omschrijving;
    private String toelichting;
    private LocalDate registratiedatum;
    private LocalDate einddatumGepland;
    private LocalDate uiterlijkeEinddatumAfdoening;
    private LocalDate publicatiedatum;
    private URI communicatiekanaal;
    private List<URI> productenOfDiensten;
    private String vertrouwelijkheidaanduiding;
    private Betalingsindicatie betalingsindicatie;
    private LocalDateTime laatsteBetaaldatum;
    private Geometrie geometrie;
    private Verlenging verlenging;
    private Opschorting opschorting;
    private URI selectielijstklasse;
    private URI hoofdzaak;
    private List<URI> relevanteAndereZaken;
    private List<Kenmerk> kenmerken;
    private ArchiefNominatie archiefNominatie;
    private ArchiefStatus archiefStatus;
    private LocalDate archiefActieDatum;

    public ZaakImpl() {
    }

    @Override
    public URI url() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    @Override
    public String identificatie() {
        return identificatie;
    }

    @Override
    public String bronorganisatie() {
        return bronorganisatie;
    }

    @Override
    public String omschrijving() {
        return omschrijving;
    }

    @Override
    public String toelichting() {
        return toelichting;
    }

    @Override
    public URI zaaktype() {
        return zaaktype;
    }

    @Override
    public LocalDate registratiedatum() {
        return registratiedatum;
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
        return einddatumGepland;
    }

    @Override
    public LocalDate uiterlijkeEinddatumAfdoening() {
        return uiterlijkeEinddatumAfdoening;
    }

    @Override
    public LocalDate publicatiedatum() {
        return publicatiedatum;
    }

    @Override
    public URI communicatiekanaal() {
        return communicatiekanaal;
    }

    @Override
    public List<URI> productenOfDiensten() {
        return productenOfDiensten;
    }

    @Override
    public String vertrouwelijkheidaanduiding() {
        return vertrouwelijkheidaanduiding;
    }

    @Override
    public Betalingsindicatie betalingsindicatie() {
        return betalingsindicatie;
    }

    @Override
    public LocalDateTime laatsteBetaaldatum() {
        return laatsteBetaaldatum;
    }

    @Override
    public Geometrie geometrie() {
        return geometrie;
    }

    @Override
    public Verlenging verlenging() {
        return verlenging;
    }

    @Override
    public Opschorting opschorting() {
        return opschorting;
    }

    @Override
    public URI selectielijstklasse() {
        return selectielijstklasse;
    }

    @Override
    public URI hoofdzaak() {
        return hoofdzaak;
    }

    @Override
    public List<URI> relevanteAndereZaken() {
        return relevanteAndereZaken;
    }

    @Override
    public List<Kenmerk> kenmerken() {
        return kenmerken;
    }

    @Override
    public ArchiefNominatie archiefNominatie() {
        return archiefNominatie;
    }

    @Override
    public ArchiefStatus archiefStatus() {
        return archiefStatus;
    }

    @Override
    public LocalDate archiefActieDatum() {
        return archiefActieDatum;
    }

    public UUID catalog() {
        final String uuidAsString = StringUtils.substringBetween(zaaktype().toString(), "catalogussen/", "/");
        return UUID.fromString(uuidAsString);
    }

    public UUID zaakType() {
        final String uuidAsString = StringUtils.substringAfter(zaaktype().toString(), "zaaktypen/");
        return UUID.fromString(uuidAsString);
    }

    public UUID zaakId() {
        final String uuidAsString = StringUtils.substringAfter(url().toString(), "zaken/");
        return UUID.fromString(uuidAsString);
    }
}
