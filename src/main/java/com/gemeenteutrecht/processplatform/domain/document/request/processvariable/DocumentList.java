package com.gemeenteutrecht.processplatform.domain.document.request.processvariable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequestImpl;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface DocumentList {

    @JsonProperty
    List<DocumentRequestImpl> documents();

}
