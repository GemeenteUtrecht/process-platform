package com.gemeenteutrecht.processplatform.domain.zaak.request.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.request.StatusCreateRequest;

import java.net.URI;
import java.time.LocalDateTime;

public class StatusCreateRequestImpl implements StatusCreateRequest {

    private URI zaak;
    private URI statusType;
    private LocalDateTime datumStatusGezet;
    private String statustoelichting;

    public StatusCreateRequestImpl(URI zaak, URI statusType, LocalDateTime datumStatusGezet, String statustoelichting) {
        this.zaak = zaak;
        this.statusType = statusType;
        this.datumStatusGezet = datumStatusGezet;
        this.statustoelichting = statustoelichting;
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
