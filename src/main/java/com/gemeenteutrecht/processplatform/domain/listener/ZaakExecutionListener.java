package com.gemeenteutrecht.processplatform.domain.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public interface ZaakExecutionListener {

    void createZaak(DelegateExecution execution);

}
