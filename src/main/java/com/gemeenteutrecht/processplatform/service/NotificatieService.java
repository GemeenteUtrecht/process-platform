package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakStatusImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.request.ZaakCreateRequest;
import com.gemeenteutrecht.processplatform.domain.zaak.request.impl.StatusCreateRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.response.ListResponse;

import java.net.URI;
import java.util.List;

public interface NotificatieService {

    ListResponse publish();

}
