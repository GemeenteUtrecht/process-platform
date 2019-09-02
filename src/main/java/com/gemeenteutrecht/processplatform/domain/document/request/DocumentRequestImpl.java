package com.gemeenteutrecht.processplatform.domain.document.request;

import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import lombok.NonNull;

import java.net.URI;

public class DocumentRequestImpl implements DocumentRequest{

    private URI url;
    private URI informatieobject;
    private URI object;
    private ObjectType objectType;
    private String titel;
    private String beschrijving;

    public DocumentRequestImpl(URI informatieobject, ObjectType objectType, String titel, String beschrijving) {
        this.informatieobject = informatieobject;
        this.objectType = objectType;
        this.titel = titel;
        this.beschrijving = beschrijving;
    }

    @Override
    public URI url() {
        return url;
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
    public @NonNull ObjectType objectType() {
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

    @Override
    public void addObject(URI object) {
        this.object = object;
    }

    @Override
    public void addUrl(URI url) {
        this.url = url;
    }
}
