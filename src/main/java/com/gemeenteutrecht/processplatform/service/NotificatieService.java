package com.gemeenteutrecht.processplatform.service;

import com.gemeenteutrecht.processplatform.domain.notificatie.Notificatie;
import com.gemeenteutrecht.processplatform.domain.notificatie.request.PublishNotificatieRequest;

public interface NotificatieService {

    Notificatie publish(PublishNotificatieRequest request);

}
