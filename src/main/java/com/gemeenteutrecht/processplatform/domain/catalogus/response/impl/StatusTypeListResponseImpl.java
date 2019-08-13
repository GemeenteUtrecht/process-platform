package com.gemeenteutrecht.processplatform.domain.catalogus.response.impl;

import com.gemeenteutrecht.processplatform.domain.catalogus.StatusType;
import com.gemeenteutrecht.processplatform.domain.catalogus.response.StatusTypeListResponse;

import java.util.Collections;
import java.util.List;

public class StatusTypeListResponseImpl implements StatusTypeListResponse {

    private List results;

    public StatusTypeListResponseImpl() {
    }

    public StatusTypeListResponseImpl(List results) {
        this.results = results;
    }

    @Override
    public List<StatusType> results() {
        return Collections.unmodifiableList(results);
    }

}
