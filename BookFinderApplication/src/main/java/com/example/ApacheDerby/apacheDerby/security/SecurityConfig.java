package com.example.ApacheDerby.apacheDerby.security;
/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;



@Configuration
public class SecurityConfig  {
	
	@Bean
	public InMemoryUserDetailsManager userDetalService() {
		UserDetails user= User.withDefaultPasswordEncoder()
				.username("user")
				.password("root")
				.roles("USER")
				.build();
		UserDetails user2= User.withDefaultPasswordEncoder()
				.username("admin")
				.password("root")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user ,user2);
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((authz)-> authz
				.antMatchers("/customer").hasRole("USER")
	            .antMatchers("/cart").hasRole("USER")
	            .antMatchers("/payment").hasRole("USER")
	            .antMatchers("/product").hasRole("ADMIN")
	            .antMatchers("/test").hasRole("USER")
	            .anyRequest()
				.authenticated()).httpBasic();
		
	      return http.build();

				
				
	}
	
	
	
	
	
}
*/
