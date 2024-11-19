package com.FormFieldLocalizationSecurity.secondary.service;

import com.FormFieldLocalizationSecurity.secondary.model.Localization;
import com.FormFieldLocalizationSecurity.secondary.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {

    @Autowired
    private LocalizationRepository localizationRepository;

    public String processLocalization(String message) {
        Localization localizationEntity = new Localization(message);
        localizationRepository.save(localizationEntity);
        return "Processed Localization and saved message: " + message;
    }
}
