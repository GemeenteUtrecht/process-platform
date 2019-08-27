package com.gemeenteutrecht.processplatform.config;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyImpl {

    private static final Logger log = LoggerFactory.getLogger(ApplicationReadyImpl.class);

    private final IdentityService identityService;

    public ApplicationReadyImpl(IdentityService identityService) {
        this.identityService = identityService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handle() {

        if (identityService.isReadOnly()) {
            log.info("Identity service provider is Read Only, not creating any demo users.");
            return;
        }

        User singleResult = identityService.createUserQuery().userId("john").singleResult();
        if (singleResult != null) {
            return;
        }

        log.info("Generating demo data for BiNG showcase");

        User user = identityService.newUser("john");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("demo");
        user.setEmail("john@doe.org");
        identityService.saveUser(user);

        Group demoGroup = identityService.newGroup("demoGroep");
        demoGroup.setName("Demo groep");
        demoGroup.setType("WORKFLOW");
        identityService.saveGroup(demoGroup);

        //Link
        identityService.createMembership(user.getId(), demoGroup.getId());

    }

}
