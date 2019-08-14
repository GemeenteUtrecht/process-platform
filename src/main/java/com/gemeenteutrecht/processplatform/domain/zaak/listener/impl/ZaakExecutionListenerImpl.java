package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.ZaakExecutionListener;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
import com.gemeenteutrecht.processplatform.service.DocumentService;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZaakExecutionListenerImpl implements ZaakExecutionListener {

    private final ObjectMapper objectMapper;
    private final ZaakService zaakService;
    private final DocumentService documentService;
    private final ZaakTypeCatalogusService zaakTypeCatalogusService;

    public ZaakExecutionListenerImpl(
            ObjectMapper objectMapper,
            ZaakService zaakService,
            DocumentService documentService,
            ZaakTypeCatalogusService zaakTypeCatalogusService
    ) {
        this.objectMapper = objectMapper;
        this.zaakService = zaakService;
        this.documentService = documentService;
        this.zaakTypeCatalogusService = zaakTypeCatalogusService;
    }

    @Override
    public void createZaak(DelegateExecution execution) {

        ZaakImpl zaak;
        // get zaak from process vars
        try {
            final JacksonJsonNode variable = (JacksonJsonNode) execution.getVariable("zaak");
            zaak = objectMapper.readValue(variable.toString(), ZaakImpl.class);
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse zaak");
        }

        // create zaak
        zaak = zaakService.createZaak(
                new ZaakCreateRequestImpl(
                        zaak.bronorganisatie(),
                        zaak.zaaktype(),
                        zaak.verantwoordelijkeOrganisatie(),
                        zaak.startdatum()
                )
        );
        // fetch status
        List<StatusTypeImpl> zakenTypes = zaakTypeCatalogusService.getZakenTypes(zaak.catalog(), zaak.zaakType());

        // set status
        StatusTypeImpl initialStatusType = zakenTypes.get(0);
        zaakService.setStatus(new StatusCreateRequestImpl(zaak.url(), initialStatusType.url(), LocalDateTime.now(), ""));

        // link document

        // update process var
        execution.setVariable("zaak", zaak);
    }

}
