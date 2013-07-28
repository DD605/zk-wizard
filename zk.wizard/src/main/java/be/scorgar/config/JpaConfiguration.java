package be.scorgar.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories("be.scorgar.demo.repository" )
public class JpaConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoConfiguration.class);
	
	@Inject private DataSource dataSource;
	@Inject private JpaVendorAdapter jpaVendorAdapter;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setPackagesToScan("be.scorgar.demo.domain");
		em.setDataSource(dataSource);
		LOGGER.debug("~~ EntityManagerFactory ~~ "+em);
		return em;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		LOGGER.debug("~~ PlatformTransactionManager ~~ "+txManager);
		return txManager;
	}
}
