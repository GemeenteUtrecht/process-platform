package com.gemeenteutrecht.processplatform.domain.zaak.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public interface ZaakExecutionListener {

    void createZaak(DelegateExecution execution);

}
