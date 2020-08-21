package com.team5.Noteapp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.logout()
				.disable()
		.authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and().cors().and().csrf().disable();
	}
}
