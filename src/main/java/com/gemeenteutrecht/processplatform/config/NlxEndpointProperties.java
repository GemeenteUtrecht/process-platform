package com.gemeenteutrecht.processplatform.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nlx")
public class NlxEndpointProperties {

    private String token;

    private String zaak;

    private String status;

    private String catalogusZaakType;

    private String document;

    private String resultaat;

    private String notificatie;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getZaak() {
        return zaak;
    }

    public void setZaak(String zaak) {
        this.zaak = zaak;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCatalogusZaakType() {
        return catalogusZaakType;
    }

    public void setCatalogusZaakType(String catalogusZaakType) {
        this.catalogusZaakType = catalogusZaakType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getResultaat() {
        return resultaat;
    }

    public void setResultaat(String resultaat) {
        this.resultaat = resultaat;
    }

    public String getNotificatie() {
        return notificatie;
    }

    public void setNotificatie(String notificatie) {
        this.notificatie = notificatie;
    }
}
