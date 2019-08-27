package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.catalogus.impl.StatusTypeImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.StatusExecutionListener;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import com.gemeenteutrecht.processplatform.service.ZaakTypeCatalogusService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusExecutionListenerImpl implements StatusExecutionListener {

    private final ZaakService<ZaakImpl> zaakService;
    private final ZaakTypeCatalogusService zaakTypeCatalogusService;

    public StatusExecutionListenerImpl(
            ZaakService zaakService,
            ZaakTypeCatalogusService zaakTypeCatalogusService
    ) {
        this.zaakService = zaakService;
        this.zaakTypeCatalogusService = zaakTypeCatalogusService;
    }

    @Override
    public void setStatus(DelegateExecution execution, Integer volgnummer, String toelichting) {
        final UUID zaakId = (UUID) execution.getVariable("zaakId");

        final ZaakImpl zaak = zaakService.getZaak(zaakId);

        final List<StatusTypeImpl> zakenTypes = zaakTypeCatalogusService.getZakenTypes(zaak.catalog(), zaak.zaakType());
        final Optional<StatusTypeImpl> type = zakenTypes
                .stream()
                .filter(statusType -> statusType.volgnummer().equals(volgnummer))
                .findFirst();

        type.ifPresentOrElse(statusType -> {
            StatusCreateRequestImpl statusCreateRequest = new StatusCreateRequestImpl(
                    zaak.url(),
                    statusType.url(),
                    LocalDateTime.now(),
                    toelichting
            );
            zaakService.setStatus(statusCreateRequest);
        }, () -> new RuntimeException("Cannot set status"));

    }

    @Override
    public void setStatus(DelegateExecution execution, Integer status) {
        setStatus(execution, status, "");
    }

}
