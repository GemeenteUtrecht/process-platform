package com.gemeenteutrecht.processplatform.domain.notificatie.listener.impl;

import com.gemeenteutrecht.processplatform.domain.notificatie.listener.NotificatieExecutionListener;
import com.gemeenteutrecht.processplatform.domain.notificatie.request.impl.PublishNotificatieRequestImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.impl.ZaakImpl;
import com.gemeenteutrecht.processplatform.domain.zaak.listener.impl.ProcessZaakHelper;
import com.gemeenteutrecht.processplatform.service.NotificatieService;
import com.gemeenteutrecht.processplatform.service.ZaakService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class NotificatieExecutionListenerImpl implements NotificatieExecutionListener {

    private final ProcessZaakHelper processZaakHelper;
    private final ZaakService zaakService;
    private final NotificatieService notificatieService;

    public NotificatieExecutionListenerImpl(ProcessZaakHelper processZaakHelper, ZaakService zaakService, NotificatieService notificatieService) {
        this.processZaakHelper = processZaakHelper;
        this.zaakService = zaakService;
        this.notificatieService = notificatieService;
    }

    @Override
    public void publishNotification(DelegateExecution execution, String kanaal, String actie) {
        final ZaakImpl zaak = processZaakHelper.getZaakFrom(execution).orElseThrow();
        var request = new PublishNotificatieRequestImpl(
                kanaal,
                null,//TODO ask sergio
                null,//TODO ask sergio
                null,//TODO ask sergio
                actie,
                LocalDateTime.now(),
                Collections.emptyMap()
        );
        notificatieService.publish(request);
    }

}
