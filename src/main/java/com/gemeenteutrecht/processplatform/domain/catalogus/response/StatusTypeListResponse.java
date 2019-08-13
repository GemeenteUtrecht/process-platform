package com.gemeenteutrecht.processplatform.domain.catalogus.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;
import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;

import java.util.List;

public interface StatusTypeListResponse {

    @JsonProperty
    List<StatusType> results();

}
