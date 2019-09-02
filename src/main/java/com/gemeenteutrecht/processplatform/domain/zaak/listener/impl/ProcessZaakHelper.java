package com.gemeenteutrecht.processplatform.domain.zaak.listener.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.document.impl.DocumentImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequestImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.processvariable.DocumentList;
import com.gemeenteutrecht.processplatform.domain.document.request.processvariable.impl.DocumentListImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
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

    public Optional<DocumentList> getDocumentRequestFrom(DelegateExecution execution) {
        try {
            final JacksonJsonNode variable = (JacksonJsonNode) execution.getVariable("documenten");
            List<DocumentRequestImpl> documents = objectMapper.readValue(variable.toString(), new TypeReference<List<DocumentRequestImpl>>() {
            });
            final DocumentListImpl documentList = new DocumentListImpl(documents);
            return Optional.of(documentList);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find documenten variable in process due to exception: " + e.getMessage());
        }
    }

}
