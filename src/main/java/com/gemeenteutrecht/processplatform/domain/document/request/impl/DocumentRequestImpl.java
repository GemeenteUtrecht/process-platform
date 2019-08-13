package com.gemeenteutrecht.processplatform.domain.document.request.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentRequestImpl implements DocumentRequest {

    private URI url;
    private URI informatieObject;
    private URI object;
    private ObjectType objectType;
    private String titel;
    private String beschrijving;

    public DocumentRequestImpl(URI informatieObject, URI object, ObjectType objectType) {
        this.informatieObject = informatieObject;
        this.object = object;
        this.objectType = objectType;
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
    public @NonNull URI informatieObject() {
        return informatieObject;
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
