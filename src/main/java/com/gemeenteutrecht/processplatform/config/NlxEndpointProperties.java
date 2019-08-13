package com.gemeenteutrecht.processplatform.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nlx", ignoreUnknownFields = false)
public class NlxEndpointProperties {

    private String zaak;

    private String status;

    private String catalogusZaakType;

    private String document;

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
}
