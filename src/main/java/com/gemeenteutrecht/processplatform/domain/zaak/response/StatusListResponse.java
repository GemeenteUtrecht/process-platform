package com.gemeenteutrecht.processplatform.domain.zaak.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;

import java.util.List;

public interface StatusListResponse {

    @JsonProperty
    List<ZaakStatus> results();

}
