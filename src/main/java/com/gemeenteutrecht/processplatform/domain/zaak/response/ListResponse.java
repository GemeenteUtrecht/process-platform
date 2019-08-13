package com.gemeenteutrecht.processplatform.domain.zaak.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.util.List;

public interface ListResponse<T_TYPE> {

    @JsonProperty
    int count();

    @JsonProperty
    URI next();

    @JsonProperty
    URI previous();

    @JsonProperty
    List<T_TYPE> results();

}
