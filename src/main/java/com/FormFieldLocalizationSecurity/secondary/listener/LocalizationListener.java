package com.FormFieldLocalizationSecurity.secondary.listener;

import com.FormFieldLocalizationSecurity.secondary.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LocalizationListener {

    @Value("${app.Queue}")
    private String localizationQueue;

    @Autowired
    private LocalizationService localizationService;

    public LocalizationListener(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @JmsListener(destination = "${app.Queue}")
    public void receiveLocalizationMessage(String message) {
        String response = localizationService.processLocalization(message);
        System.out.println("Received localization message: " + response);
    }
}
