package com.FormFieldLocalizationSecurity;

import com.FormFieldLocalizationSecurity.primary.service.FormService;
import com.FormFieldLocalizationSecurity.secondary.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FormFieldLocalizationSecurity {

	@Value("${app.serviceType}")
	private String serviceType;
	@Autowired
	private LocalizationService localizationService;
	private static final Logger logger = LoggerFactory.getLogger(FormFieldLocalizationSecurity.class);

	@Autowired
	private FormService formService;

	public static void main(String[] args) {
		SpringApplication.run(FormFieldLocalizationSecurity.class, args);
	}

	@PostConstruct
	public void run() {
		logger.info("Service Type: {}", serviceType); //

		if ("localization".equalsIgnoreCase(serviceType)) {
			String response = localizationService.processLocalization("Hello from Localization");
			logger.info("Localization Response: {}", response);
		} else if ("form".equalsIgnoreCase(serviceType)) {
			String response = formService.processForm("Hello from Form");
			logger.info("Form Response: {}", response);
		} else {
			logger.warn("No valid service type specified.");
		}
	}

}
