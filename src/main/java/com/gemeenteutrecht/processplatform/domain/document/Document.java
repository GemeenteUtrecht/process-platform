package com.gemeenteutrecht.processplatform.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.gemeenteutrecht.processplatform.domain.document.impl.ObjectType;
import lombok.NonNull;

import java.net.URI;
import java.time.LocalDate;

public interface Document {

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
    String aardRelatie();

    @JsonProperty
    String titel();

    @JsonProperty
    String beschrijving();

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate registratiedatum();
}
