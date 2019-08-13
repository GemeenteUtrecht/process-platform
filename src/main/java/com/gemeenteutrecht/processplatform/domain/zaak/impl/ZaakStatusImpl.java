package com.gemeenteutrecht.processplatform.domain.zaak.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;

import java.net.URI;
import java.time.LocalDateTime;

public class ZaakStatusImpl implements ZaakStatus {

    private URI url;
    private URI zaak;
    private URI statusType;
    private LocalDateTime datumStatusGezet;
    private String statustoelichting;

    public ZaakStatusImpl() {
    }

    public ZaakStatusImpl(URI url, URI zaak, URI statusType, LocalDateTime datumStatusGezet, String statustoelichting) {
        this.url = url;
        this.zaak = zaak;
        this.statusType = statusType;
        this.datumStatusGezet = datumStatusGezet;
        this.statustoelichting = statustoelichting;
    }

    @Override
    public URI url() {
        return url;
    }

    @Override
    public URI zaak() {
        return zaak;
    }

    @Override
    public URI statusType() {
        return statusType;
    }

    @Override
    public LocalDateTime datumStatusGezet() {
        return datumStatusGezet;
    }

    @Override
    public String statustoelichting() {
        return statustoelichting;
    }

}
