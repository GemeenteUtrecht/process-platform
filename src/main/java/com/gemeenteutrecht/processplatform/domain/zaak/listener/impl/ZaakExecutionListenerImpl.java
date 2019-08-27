package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentList;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.ZaakExecutionListener;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.ZaakCreateRequestImpl;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZaakExecutionListenerImpl implements ZaakExecutionListener {

    private final ProcessZaakHelper processZaakHelper;
    private final ZaakService<ZaakImpl> zaakService;
    private final ZaakTypeCatalogusService zaakTypeCatalogusService;

    public ZaakExecutionListenerImpl(
            ProcessZaakHelper processZaakHelper, ZaakService zaakService,
            ZaakTypeCatalogusService zaakTypeCatalogusService
    ) {
        this.processZaakHelper = processZaakHelper;
        this.zaakService = zaakService;
        this.zaakTypeCatalogusService = zaakTypeCatalogusService;
    }

    @Override
    public void createZaak(DelegateExecution execution) {
        ZaakImpl zaak = processZaakHelper.getZaakFrom(execution).orElseThrow();//TODO rewrite to use request object

        // create zaak
        zaak = zaakService.createZaak(
                new ZaakCreateRequestImpl(
                        zaak.bronorganisatie(),
                        zaak.zaaktype(),
                        zaak.verantwoordelijkeOrganisatie(),
                        zaak.startdatum()
                )
        );
        List<StatusTypeImpl> zakenTypes = zaakTypeCatalogusService.getZakenTypes(zaak.catalog(), zaak.zaakType());
        // set initial status
        StatusTypeImpl initialStatusType = zakenTypes
                .stream()
                .filter(statusType -> statusType.volgnummer().equals(1))
                .findFirst()
                .orElseThrow();

        zaakService.setStatus(
                new StatusCreateRequestImpl(
                        zaak.url(),
                        initialStatusType.url(),
                        LocalDateTime.now(),
                        ""
                )
        );

        DocumentList documentList = processZaakHelper.getDocumentRequestFrom(execution).orElseThrow();

        documentList.documents().forEach(zaakService::createDocument);

        // update process var
        execution.setVariable("zaakId", zaak.zaakId());
    }

}
