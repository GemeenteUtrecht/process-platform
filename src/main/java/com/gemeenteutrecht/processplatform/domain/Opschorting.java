package com.gemeenteutrecht.processplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gemeenteutrecht.processplatform.domain.impl.OpschortingImpl;

@JsonDeserialize(as = OpschortingImpl.class)
public interface Opschorting {

    @JsonProperty
    boolean indicatie();

    @JsonProperty
    String reden();

}
