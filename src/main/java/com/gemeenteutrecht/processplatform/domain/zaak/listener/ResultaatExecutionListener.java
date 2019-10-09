package com.gemeenteutrecht.processplatform.domain.zaak.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public interface ResultaatExecutionListener {

    void setResultaat(DelegateExecution delegateExecution, String resultaat);

    void setResultaat(DelegateExecution delegateExecution, String resultaat, String toelichting);
}
