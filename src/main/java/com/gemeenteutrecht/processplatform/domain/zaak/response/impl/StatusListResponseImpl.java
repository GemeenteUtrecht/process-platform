package com.gemeenteutrecht.processplatform.domain.zaak.response.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.ZaakStatus;
import com.gemeenteutrecht.processplatform.domain.zaak.response.StatusListResponse;

import java.util.Collections;
import java.util.List;

public class StatusListResponseImpl implements StatusListResponse {

    private List results;

    public StatusListResponseImpl(List results) {
        this.results = results;
    }

    @Override
    public List<ZaakStatus> results() {
        return Collections.unmodifiableList(results);
    }

}
