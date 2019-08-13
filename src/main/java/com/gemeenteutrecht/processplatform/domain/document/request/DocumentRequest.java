package com.gemeenteutrecht.processplatform.domain.document.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import lombok.NonNull;

import java.net.URI;

public interface DocumentRequest {

    @JsonProperty
    URI url(); //TODO [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef

    @JsonProperty
    @NonNull
    URI informatieObject();

    @JsonProperty
    @NonNull
    URI object(); //[ 1 .. 200 ] characters

    @JsonProperty
    @NonNull
    ObjectType objectType(); // TODO RSIN [ 1 .. 9 ] characters https://nl.wikipedia.org/wiki/Burgerservicenummer#11-proef

    @JsonProperty
    String titel();

    @JsonProperty
    String beschrijving();

}
