package br.com.casadocodigo.loja.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@SuppressWarnings("deprecation")
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/produtos/form").hasRole("ADMIN")
//			.antMatchers("/carrinho").permitAll()
//			.antMatchers("/produtos").hasRole("ADIMIM")
//			.antMatchers("/produtos/**").permitAll()
//			.antMatchers("/").permitAll()
//			.anyRequest().authenticated().and().formLogin();
//	}
}
