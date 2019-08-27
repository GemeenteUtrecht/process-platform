package com.gemeenteutrecht.processplatform.domain.document.request.impl;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentListImpl implements DocumentList, Serializable {

    private List<Document> documents;

    public DocumentListImpl(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public List<Document> documents() {
        return documents;
    }
}
