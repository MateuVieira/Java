package br.com.casadocodigo.loja.conf;

import java.beans.PropertyVetoException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Profile("prod")
public class JPAProductionConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public Properties aditionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	public DataSource getDataSource() throws PropertyVetoException, URISyntaxException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("org.postgresql.Driver");

		//usuario:senha@host:port/path
		URI dbURL = new URI(environment.getProperty("DATABASE_URL"));
		dataSource.setUser(dbURL.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbURL.getUserInfo().split(":")[1]);
		dataSource.setJdbcUrl("jdbc:postgresql://" + dbURL.getHost()
				+ ":" + dbURL.getPort() + dbURL.getPath());
		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(2);
		//dataSource.setNumHelperThreads(10);
		
		return dataSource;
	}
}
