package com.gemeenteutrecht.processplatform.domain.listener.impl;

import com.gemeenteutrecht.processplatform.domain.listener.ZaakExecutionListener;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Service;

@Service
public class ZaakExecutionListenerImpl implements ZaakExecutionListener {

    @Override
    public void createZaak(DelegateExecution execution) {
        //ObjectValue object = execution.getVariableTyped("zaak");
        //Zaak zaak = object.getValue(ZaakImpl.class);
    }

}
