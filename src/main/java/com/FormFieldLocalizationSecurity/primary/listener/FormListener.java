package com.FormFieldLocalizationSecurity.primary.listener;

import com.FormFieldLocalizationSecurity.primary.service.FormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FormListener {
    @Value("${app.formQueue}")
    private String formQueue;

    private final FormService formService;

    public FormListener(FormService formService) {
        this.formService = formService;
    }

    @JmsListener(destination = "${app.formQueue}")
    public void receiveFormMessage(String message) {
        String response = formService.processForm(message);
        System.out.println("Received form message: " + response);
    }

}
