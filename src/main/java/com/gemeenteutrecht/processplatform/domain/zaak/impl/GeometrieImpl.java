package com.gemeenteutrecht.processplatform.domain.zaak.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gemeenteutrecht.processplatform.domain.zaak.Geometrie;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.Point;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeometrieImpl implements Geometrie {

    private Point coordinates;

    @Override
    public Point coordinates() {
        return coordinates;
    }
}
