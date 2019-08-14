package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.ZaakExecutionListener;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
import com.gemeenteutrecht.processplatform.service.DocumentService;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZaakExecutionListenerImpl implements ZaakExecutionListener {

    private final ProcessZaakHelper processZaakHelper;
    private final ZaakService zaakService;
    private final DocumentService documentService;
    private final ZaakTypeCatalogusService zaakTypeCatalogusService;

    public ZaakExecutionListenerImpl(
            ProcessZaakHelper processZaakHelper, ZaakService zaakService,
            DocumentService documentService,
            ZaakTypeCatalogusService zaakTypeCatalogusService
    ) {
        this.processZaakHelper = processZaakHelper;
        this.zaakService = zaakService;
        this.documentService = documentService;
        this.zaakTypeCatalogusService = zaakTypeCatalogusService;
    }

    @Override
    public void createZaak(DelegateExecution execution) {
        ZaakImpl zaak = processZaakHelper.getZaakFrom(execution).orElseThrow();
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
