package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.resultaat.request.ResultaatRequest;
import com.gemeenteutrecht.processplatform.domain.resultaat.request.impl.ResultaatRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.ResultaatExecutionListener;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class ResultaatExecutionListenerImpl implements ResultaatExecutionListener {

    private final ProcessZaakHelper processZaakHelper;
    private final ZaakService zaakService;

    public ResultaatExecutionListenerImpl(ProcessZaakHelper processZaakHelper, ZaakService zaakService) {
        this.processZaakHelper = processZaakHelper;
        this.zaakService = zaakService;
    }

    @Override
    public void setResultaat(DelegateExecution delegateExecution, URI resultaatType, String toelichting) {
        final ZaakImpl zaak = processZaakHelper.getZaakFrom(delegateExecution).orElseThrow();
        ResultaatRequest resultaatRequest = new ResultaatRequestImpl(zaak.url(), resultaatType, toelichting);
        zaakService.setResultaat(resultaatRequest);
    }

    @Override
    public void setResultaat(DelegateExecution delegateExecution, URI resultaat) {
        setResultaat(delegateExecution, resultaat, "");
    }

}
