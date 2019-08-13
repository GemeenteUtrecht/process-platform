package com.gemeenteutrecht.processplatform.domain.impl;

import com.gemeenteutrecht.processplatform.domain.Kenmerk;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KenmerkImpl implements Kenmerk {

    private String kenmerk;
    private String bron;

    @Override
    public String kenmerk() {
        return kenmerk;
    }

    @Override
    public String bron() {
        return bron;
    }
}
