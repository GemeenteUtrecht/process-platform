package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.listener.ZaakExecutionListener;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

@Service
public class ZaakExecutionListenerImpl implements ZaakExecutionListener {

    @Override
    public void createZaak(DelegateExecution execution) {
        //ObjectValue object = execution.getVariableTyped("zaak");
        //Zaak zaak = object.getValue(ZaakImpl.class);
    }

}
