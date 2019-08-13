package com.gemeenteutrecht.processplatform.domain.impl;

import com.gemeenteutrecht.processplatform.domain.Verlenging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VerlengingImpl implements Verlenging {

    private String reden;
    private String duur;

    @Override
    public String reden() {
        return reden;
    }

    @Override
    public String duur() {
        return duur;
    }
}
