package com.gemeenteutrecht.processplatform.domain.notificatie.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

public interface PublishNotificatieRequest {

    @JsonProperty
    String kanaal();

    @JsonProperty
    URI hoofdObject();

    @JsonProperty
    String resource();

    @JsonProperty
    URI resourceUrl();

    @JsonProperty
    String actie();

    @JsonProperty
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    LocalDateTime aanmaakdatum();

    @JsonProperty
    Map kenmerken();

}
