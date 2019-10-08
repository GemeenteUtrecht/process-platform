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
    URI object(); //zaakUrl

    @JsonProperty
    @NonNull
    String objectType();

    @JsonProperty
    String titel();

    @JsonProperty
    String beschrijving();
}
