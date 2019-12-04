package com.gemeenteutrecht.processplatform.domain.document.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.URI;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentImpl implements Document {

    private URI url;
    private URI informatieobject;
    private URI zaak;
    private String titel;
    private String beschrijving;
    private LocalDate registratiedatum;

    public DocumentImpl(
            URI url,
            URI informatieobject,
            URI zaak,
            String titel,
            String beschrijving,
            LocalDate registratiedatum
    ) {
        this.url = url;
        this.informatieobject = informatieobject;
        this.zaak = zaak;
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

    @Override
    public LocalDate registratiedatum() {
        return registratiedatum;
    }

}
