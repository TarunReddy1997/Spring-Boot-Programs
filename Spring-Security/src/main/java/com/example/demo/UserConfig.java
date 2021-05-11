package com.example.demo;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class UserConfig {

	@Bean
	protected UserDetailsService detailsService() {
		java.util.List<UserDetails> list = new ArrayList<UserDetails>();
		list.add(User.withDefaultPasswordEncoder().username("tarun").password("1234").roles("USER").build());
		return new InMemoryUserDetailsManager(list);
		}
}
