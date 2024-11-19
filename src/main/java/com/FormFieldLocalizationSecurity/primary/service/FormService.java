package com.FormFieldLocalizationSecurity.primary.service;

import com.FormFieldLocalizationSecurity.primary.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    private com.FormFieldLocalizationSecurity.primary.repository.FormRepository formRepository;

    public String processForm(String formData) {
        Form formEntity = new Form(formData);
        formRepository.save(formEntity);
        return "Processed Form and saved formData: " + formData;
    }
}
