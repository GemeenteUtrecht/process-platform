package com.gemeenteutrecht.processplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gemeenteutrecht.processplatform.domain.impl.VerlengingImpl;

@JsonDeserialize(as = VerlengingImpl.class)
public interface Verlenging {

    @JsonProperty
    String reden();

    @JsonProperty
    String duur();
}
