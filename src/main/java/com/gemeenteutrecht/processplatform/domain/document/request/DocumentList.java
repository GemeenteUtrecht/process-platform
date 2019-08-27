package com.gemeenteutrecht.processplatform.domain.document.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.document.impl.DocumentImpl;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface DocumentList {

    @JsonProperty
    List<DocumentImpl> documents();

}
