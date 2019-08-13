package com.gemeenteutrecht.processplatform.domain.document.impl;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.URI;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentImpl implements Document {

    private URI url;
    private URI informatieObject;
    private URI object;
    private ObjectType objectType;//
    private String aardRelatie;//TODO enum
    private String titel;
    private String beschrijving;
    private LocalDate registratiedatum;

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
    public String aardRelatie() {
        return aardRelatie;
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
    public LocalDate registratiedatum() {
        return registratiedatum;
    }
}