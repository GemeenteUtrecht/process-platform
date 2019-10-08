package com.gemeenteutrecht.processplatform.domain.document.request;

import lombok.NonNull;

import java.net.URI;

public class DocumentRequestImpl implements DocumentRequest{

    private URI informatieobject;
    private URI object;
    private String objectType;
    private String titel;
    private String beschrijving;

    public DocumentRequestImpl(URI informatieobject, URI object) {
        this.object = object;
        this.informatieobject = informatieobject;
        this.objectType = "zaak";
        this.titel = "title";
        this.beschrijving = "beschrijving";
    }

    @Override
    public @NonNull URI informatieobject() {
        return informatieobject;
    }

    @Override
    public @NonNull URI object() {
        return object;
    }

    @Override
    public @NonNull String objectType() {
        return objectType;
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
