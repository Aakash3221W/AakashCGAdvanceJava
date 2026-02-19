package com.example.demo.Configurations;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		// Hard Coded user
//		UserDetails john = User.builder()
//				.username("john")
//				.password("{noop}test123")
//				.roles("EMPLOYEE")
//				.build();
//		
//		UserDetails mary = User.builder()
//				.username("mary")
//				.password("{noop}test123")
//				.roles("EMPLOYEE","MANAGER")
//				.build();
//		UserDetails susan = User.builder()
//				.username("suan")
//				.password("{noop}test123")
//				.roles("EMPLOYEE","MANAGER","ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(john, mary, susan);
//		
//		
//		
//	}
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests( Configurer -> 
							Configurer 
								.requestMatchers(HttpMethod.GET,"/employees/**").hasRole("EMPLOYEE")
								.requestMatchers(HttpMethod.POST,"/employees/**").hasRole("MANAGER")
								.requestMatchers(HttpMethod.PUT,"/employees/**").hasRole("MANAGER")
								.requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN"));
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(Csrf->Csrf.disable());
		
		return http.build();
	}

}
