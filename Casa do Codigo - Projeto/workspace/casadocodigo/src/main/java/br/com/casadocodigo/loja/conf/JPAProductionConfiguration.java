package br.com.casadocodigo.loja.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
public class JPAProductionConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public Properties aditionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		return properties;
	}

	@Bean
	public DriverManagerDataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");

		//usuario:senha@host:port/path
		URI dbURL = new URI(environment.getProperty("DATABASE_URL"));
		dataSource.setUsername(dbURL.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbURL.getUserInfo().split(":")[1]);
		dataSource.setUrl("jdbc:postgresql://" + dbURL.getHost()
				+ ":" + dbURL.getPort() + dbURL.getPath());
		return dataSource;
	}
}
