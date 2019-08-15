package com.gemeenteutrecht.processplatform.domain.notificatie.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public interface NotificatieExecutionListener {

    void publishNotification(DelegateExecution execution, String kanaal, String actie);

}
