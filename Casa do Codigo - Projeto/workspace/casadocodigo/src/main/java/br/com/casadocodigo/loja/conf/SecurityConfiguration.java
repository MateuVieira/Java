package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.casadocodigo.loja.dao.UsuarioDAO;


@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		    .antMatchers("/resources/**").permitAll()
		    .antMatchers("/carrinho/**").permitAll()
		    .antMatchers("/pagamento/**").permitAll()
		    .antMatchers("/produtos/form").hasRole("ADMIN")
		    .antMatchers("/produtos").hasRole("ADMIN")
		    .antMatchers("/produtos/**").permitAll()
		    .antMatchers("/").permitAll()
		    .anyRequest().authenticated()
		    .and().formLogin();
	}
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(usuarioDao)
	     	.passwordEncoder(new BCryptPasswordEncoder());
	 }
}