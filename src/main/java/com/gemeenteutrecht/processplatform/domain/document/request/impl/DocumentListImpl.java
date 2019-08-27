package com.gemeenteutrecht.processplatform.domain.document.request.impl;

import com.gemeenteutrecht.processplatform.domain.document.impl.DocumentImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentListImpl implements DocumentList, Serializable {

    private List<DocumentImpl> documents;

    public DocumentListImpl(List<DocumentImpl> documents) {
        this.documents = documents;
    }

    @Override
    public List<DocumentImpl> documents() {
        return documents;
    }
}
