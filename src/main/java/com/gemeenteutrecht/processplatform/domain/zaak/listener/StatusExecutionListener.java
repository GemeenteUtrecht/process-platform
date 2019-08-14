package com.gemeenteutrecht.processplatform.domain.zaak.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public interface StatusExecutionListener {

    void setStatus(DelegateExecution execution, Integer status, String toelichting);

    void setStatus(DelegateExecution execution, Integer status);

}
