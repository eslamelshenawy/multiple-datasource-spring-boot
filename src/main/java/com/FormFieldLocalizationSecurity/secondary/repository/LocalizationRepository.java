package com.FormFieldLocalizationSecurity.secondary.repository;

import com.FormFieldLocalizationSecurity.secondary.model.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {
}
