package com.gemeenteutrecht.processplatform.domain.document.request.impl;

import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentRequestImpl implements DocumentRequest, Serializable {

    private URI url;
    private URI informatieobject;
    private URI object;
    private ObjectType objectType;
    private String titel;
    private String beschrijving;

    public DocumentRequestImpl(URI informatieobject, URI object, ObjectType objectType) {
        this.informatieobject = informatieobject;
        this.object = object;
        this.objectType = objectType;
        this.titel = "";
        this.beschrijving = "";
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setBeschrijving(String beschrijving) {
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
}
