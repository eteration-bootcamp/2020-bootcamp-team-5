package com.team5.Noteapp.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.team5.Noteapp.Util.AuthenticationInterceptor;

@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
	private static List<String> excludePathPatterns;
	
	static {
		excludePathPatterns = new ArrayList<String>();
		excludePathPatterns.add("/login");
	}
	
	
	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
	}
}
