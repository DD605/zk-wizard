package be.scorgar.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("develop")
public class HsqlDataConfigiuration {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HsqlDataConfigiuration.class);

	@Bean
	public DataSource dataSource() {
		LOGGER.debug("dataSource: ~~ HSQL ~~ DEVELOPMENT ~~");
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:data/schema.sql")
				.addScript("classpath:data/data.sql").build();
	}

	@Bean 
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.HSQL);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}
}
