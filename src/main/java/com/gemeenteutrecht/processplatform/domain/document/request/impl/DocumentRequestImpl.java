package com.gemeenteutrecht.processplatform.domain.document.request.impl;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentRequestImpl implements DocumentRequest, Serializable {

    private List<Document> documents;

    public DocumentRequestImpl(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public List<Document> documents() {
        return documents;
    }
}
