package com.gemeenteutrecht.processplatform.domain.resultaat.impl;

import com.gemeenteutrecht.processplatform.domain.resultaat.Resultaat;
import lombok.NonNull;

import java.net.URI;

public class ResultaatImpl implements Resultaat {

    private URI url;
    private URI zaak;
    private URI resultaatType;
    private String toelichting;

    @Override
    public URI url() {
        return url;
    }

    @Override
    public @NonNull URI zaak() {
        return null;
    }

    @Override
    public @NonNull URI resultaatType() {
        return null;
    }

    @Override
    public String toelichting() {
        return null;
    }
}
