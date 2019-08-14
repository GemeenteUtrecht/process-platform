package com.gemeenteutrecht.processplatform.domain.zaak.impl;

import org.junit.Test;

import java.net.URI;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class ZaakImplTest {

    @Test
    public void catalog() {
        ZaakImpl zaak = new ZaakImpl();
        zaak.setUrl(URI
                .create("http://gemma-ztc.k8s.dc1.proeftuin.utrecht.nl/api/v1/catalogussen/28487d3f-6a1b-489c-b03d-c75ac6693e72/zaaktypen/7af2d4dd-511b-4b27-89a8-77ac7c8e7a82"));
        UUID catalog = zaak.catalog();
        assertNotNull(catalog);

        UUID zaakType = zaak.zaakType();
        assertNotNull(zaakType);
   }

    @Test
    public void zaakTypeUUID() {
    }
}
