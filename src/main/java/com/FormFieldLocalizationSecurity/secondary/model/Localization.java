package com.FormFieldLocalizationSecurity.secondary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "localizations")
@AllArgsConstructor
@NoArgsConstructor
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    public Localization(String message) {
        this.message = message;
    }

}
