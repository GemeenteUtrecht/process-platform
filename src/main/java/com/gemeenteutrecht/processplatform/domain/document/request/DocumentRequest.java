package com.gemeenteutrecht.processplatform.domain.document.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import java.net.URI;

public interface DocumentRequest {

    @JsonProperty
    @NonNull
    URI informatieobject(); //documentUrl

    @JsonProperty
    @NonNull
    URI zaak(); //zaakUrl

    @JsonProperty
    String titel();

    @JsonProperty
    String beschrijving();
}
