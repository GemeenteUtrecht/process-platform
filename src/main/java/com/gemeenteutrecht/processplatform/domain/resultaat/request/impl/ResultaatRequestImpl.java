package com.gemeenteutrecht.processplatform.domain.resultaat.request.impl;

import com.gemeenteutrecht.processplatform.domain.resultaat.request.ResultaatRequest;

import java.io.Serializable;
import java.net.URI;

public class ResultaatRequestImpl implements ResultaatRequest, Serializable {

    private URI zaak;
    private URI resultaatType;
    private String toelichting;

    public ResultaatRequestImpl(URI zaak, URI resultaatType, String toelichting) {
        this.zaak = zaak;
        this.resultaatType = resultaatType;
        this.toelichting = toelichting;
    }

    @Override
    public URI zaak() {
        return zaak;
    }

    @Override
    public URI resultaatType() {
        return resultaatType;
    }

    @Override
    public String toelichting() {
        return toelichting;
    }
}
