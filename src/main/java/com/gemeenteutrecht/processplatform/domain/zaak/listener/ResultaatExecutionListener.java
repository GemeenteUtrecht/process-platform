package com.gemeenteutrecht.processplatform.domain.zaak.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.net.URI;

public interface ResultaatExecutionListener {

    void setResultaat(DelegateExecution delegateExecution, URI resultaat);

    void setResultaat(DelegateExecution delegateExecution, URI resultaat, String toelichting);
}
