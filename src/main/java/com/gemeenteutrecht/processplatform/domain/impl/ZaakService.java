package com.gemeenteutrecht.processplatform.domain.impl;

import com.gemeenteutrecht.processplatform.domain.Zaak;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

@Component
public class ZaakService {

    public void create(DelegateExecution execution) {

        //ObjectValue object = execution.getVariableTyped("zaak");
        //Zaak zaak = object.getValue(ZaakImpl.class);

    }

}
