package com.gemeenteutrecht.processplatform.domain.document.request.processvariable.impl;

import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequestImpl;
import com.gemeenteutrecht.processplatform.domain.document.request.processvariable.DocumentList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentListImpl implements DocumentList, Serializable {

    private List<DocumentRequestImpl> documents;

    public DocumentListImpl(List<DocumentRequestImpl> documents) {
        this.documents = documents;
    }

    @Override
    public List<DocumentRequestImpl> documents() {
        return documents;
    }
}
