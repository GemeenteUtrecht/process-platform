package com.gemeenteutrecht.processplatform.domain.document.request;

import lombok.NonNull;

import java.net.URI;

public class DocumentRequestImpl implements DocumentRequest{

    private URI informatieobject;
    private URI zaak;
    private String titel;
    private String beschrijving;

    public DocumentRequestImpl(URI informatieobject, URI zaak) {
        this.zaak = zaak;
        this.informatieobject = informatieobject;
        this.titel = "title";
        this.beschrijving = "beschrijving";
    }

    @Override
    public @NonNull URI informatieobject() {
        return informatieobject;
    }

    @Override
    public @NonNull URI zaak() {
        return zaak;
    }

    @Override
    public String titel() {
        return titel;
    }

    @Override
    public String beschrijving() {
        return beschrijving;
    }
}
