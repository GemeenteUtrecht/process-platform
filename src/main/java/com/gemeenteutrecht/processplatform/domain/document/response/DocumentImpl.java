package com.gemeenteutrecht.processplatform.domain.document.response;

import com.gemeenteutrecht.processplatform.domain.document.ObjectType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.URI;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentImpl implements Document {

    private URI url;
    private URI informatieobject;
    private URI object;
    private ObjectType objectType;//
    private String titel;
    private String beschrijving;
    private LocalDate registratiedatum;

    public DocumentImpl(
            URI url,
            URI informatieobject,
            URI object,
            ObjectType objectType,
            String titel,
            String beschrijving,
            LocalDate registratiedatum
    ) {
        this.url = url;
        this.informatieobject = informatieobject;
        this.object = object;
        this.objectType = objectType;
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.registratiedatum = registratiedatum;
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
    public LocalDate registratiedatum() {
        return registratiedatum;
    }

}
