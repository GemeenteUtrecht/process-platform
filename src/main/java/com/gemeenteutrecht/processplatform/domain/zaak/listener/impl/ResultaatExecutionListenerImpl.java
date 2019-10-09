package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.resultaat.request.ResultaatRequest;
import com.gemeenteutrecht.processplatform.domain.resultaat.request.impl.ResultaatRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.ResultaatExecutionListener;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

@Service
public class ResultaatExecutionListenerImpl implements ResultaatExecutionListener {

    private final ZaakService<ZaakImpl> zaakService;

    public ResultaatExecutionListenerImpl(ZaakService zaakService) {
        this.zaakService = zaakService;
    }

    @Override
    public void setResultaat(DelegateExecution delegateExecution, String resultaatType, String toelichting) {
        final UUID zaakId = (UUID) delegateExecution.getVariable("zaakId");
        final ZaakImpl zaak = zaakService.getZaak(zaakId);

        ResultaatRequest resultaatRequest = new ResultaatRequestImpl(zaak.url(), URI.create(resultaatType), toelichting);
        zaakService.setResultaat(resultaatRequest);
    }

    @Override
    public void setResultaat(DelegateExecution delegateExecution, String resultaat) {
        setResultaat(delegateExecution, resultaat, "");
    }

}
