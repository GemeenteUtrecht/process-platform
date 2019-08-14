package com.gemeenteutrecht.processplatform.domain.resultaat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

import java.net.URI;

public interface Resultaat {

    @JsonProperty
    URI url();

    @NonNull
    @JsonProperty
    URI zaak();

    @NonNull
    @JsonProperty
    URI resultaatType();

    @JsonProperty
    String toelichting();
}
