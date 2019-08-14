package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ProcessZaakHelper {

    private final ObjectMapper objectMapper;

    public ProcessZaakHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<ZaakImpl> getZaakFrom(DelegateExecution execution) {
        try {
            final JacksonJsonNode variable = (JacksonJsonNode) execution.getVariable("zaak");
            return Optional.of(objectMapper.readValue(variable.toString(), ZaakImpl.class));
        } catch (IOException e) {
            throw new RuntimeException("Cannot find zaak variable in process");
        }
    }

}
