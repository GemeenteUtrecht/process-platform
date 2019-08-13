package com.gemeenteutrecht.processplatform.domain.zaak.impl;

import com.gemeenteutrecht.processplatform.domain.zaak.Opschorting;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpschortingImpl implements Opschorting {

    private boolean indicatie;
    private String reden;

    @Override
    public boolean indicatie() {
        return indicatie;
    }

    @Override
    public String reden() {
        return reden;
    }
}
