package com.example.ApacheDerby.apacheDerby.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/*
//if want to use the security config add dependency for @Annote it properly and then use this class.
@Configuration

public class SecurityConfig {
	
	 
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build() ;
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http)throws Exception {
		http.authorizeHttpRequests((authz)->authz.antMatchers("/customer")
				.authenticated())
				.httpBasic() ;
		 return http.build();
	}
}


	*/

	

