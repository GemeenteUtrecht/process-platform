package com.gemeenteutrecht.processplatform.domain.notificatie.impl;

import com.gemeenteutrecht.processplatform.domain.notificatie.Notificatie;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

public class NotificatieImpl implements Notificatie {

    private String kanaal;
    private URI hoofdObject;
    private String resource;
    private URI resourceUrl;
    private String actie;
    private LocalDateTime aanmaakdatum;
    private Map kenmerken;

    public NotificatieImpl(
            String kanaal,
            URI hoofdObject,
            String resource,
            URI resourceUrl,
            String actie,
            LocalDateTime aanmaakdatum,
            Map kenmerken
    ) {
        this.kanaal = kanaal;
        this.hoofdObject = hoofdObject;
        this.resource = resource;
        this.resourceUrl = resourceUrl;
        this.actie = actie;
        this.aanmaakdatum = aanmaakdatum;
        this.kenmerken = kenmerken;
    }

    @Override
    public String kanaal() {
        return kanaal;
    }

    @Override
    public URI hoofdObject() {
        return hoofdObject;
    }

    @Override
    public String resource() {
        return resource;
    }

    @Override
    public URI resourceUrl() {
        return resourceUrl;
    }

    @Override
    public String actie() {
        return actie;
    }

    @Override
    public LocalDateTime aanmaakdatum() {
        return aanmaakdatum;
    }

    @Override
    public Map kenmerken() {
        return kenmerken;
    }

}
