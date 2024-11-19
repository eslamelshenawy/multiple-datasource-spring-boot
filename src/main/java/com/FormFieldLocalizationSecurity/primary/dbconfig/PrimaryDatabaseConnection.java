package com.FormFieldLocalizationSecurity.primary.dbconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "primaryEntityManagerFactory", 
		transactionManagerRef = "primaryTransactionManager", 
		basePackages = {"com.FormFieldLocalizationSecurity.primary.repository"})
public class PrimaryDatabaseConnection {

	@Value("${spring.primary.datasource.url}")
	private String url;
	
	@Value("${spring.primary.datasource.username}")
	private String username;
	
	@Value("${spring.primary.datasource.password}")
	private String password;
	
	@Primary
    @Bean(name="primaryDbDataSource")
    public DataSource primaryDbDataSource() {
        return DataSourceBuilder.create()
        		.url(url)
        		.username(username)
        		.password(password)
        		.build();
    }
	
	@Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
    		EntityManagerFactoryBuilder builder,
			@Qualifier("primaryDbDataSource") DataSource primaryDataSource) {
        return builder
        		.dataSource(primaryDataSource)
        		.packages("com.FormFieldLocalizationSecurity.primary.model")
                .build();
    }
	

	@Primary
	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager primaryTransactionManager(
			@Qualifier("primaryEntityManagerFactory") EntityManagerFactory
			primaryEntityManagerFactory) {
		return new JpaTransactionManager(primaryEntityManagerFactory);
	}
	
}
