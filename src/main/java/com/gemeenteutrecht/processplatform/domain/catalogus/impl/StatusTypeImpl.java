package com.gemeenteutrecht.processplatform.domain.catalogus.impl;

import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;

import java.net.URI;

public class StatusTypeImpl implements StatusType {

    private URI url;
    private String omschrijving;
    private String omschrijvingGeneriek;
    private String statustekst;
    private URI zaaktype;
    private Integer volgnummer;
    private Boolean isEindstatus;

    public StatusTypeImpl() {
    }

    public StatusTypeImpl(URI url, String omschrijving, String omschrijvingGeneriek, String statustekst, URI zaaktype, Integer volgnummer, Boolean isEindstatus) {
        this.url = url;
        this.omschrijving = omschrijving;
        this.omschrijvingGeneriek = omschrijvingGeneriek;
        this.statustekst = statustekst;
        this.zaaktype = zaaktype;
        this.volgnummer = volgnummer;
        this.isEindstatus = isEindstatus;
    }

    @Override
    public URI url() {
        return url;
    }

    @Override
    public String omschrijving() {
        return omschrijving;
    }

    @Override
    public String omschrijvingGeneriek() {
        return omschrijvingGeneriek;
    }

    @Override
    public String statustekst() {
        return statustekst;
    }

    @Override
    public URI zaaktype() {
        return zaaktype;
    }

    @Override
    public Integer volgnummer() {
        return volgnummer;
    }

    @Override
    public Boolean isEindstatus() {
        return isEindstatus;
    }
}
