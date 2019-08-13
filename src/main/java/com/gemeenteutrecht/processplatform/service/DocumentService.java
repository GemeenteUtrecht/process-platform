package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.document.Document;
import com.gemeenteutrecht.processplatform.domain.document.request.DocumentRequest;

public interface DocumentService {

    Document createDocument(DocumentRequest documentRequest);
}
