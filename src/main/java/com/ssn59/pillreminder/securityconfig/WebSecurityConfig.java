//package com.ssn59.pillreminder.securityconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.ssn59.pillreminder.services.UserServices;
//
//@Configuration
//public class WebSecurityConfig {
//
//	@Autowired
//	@Lazy
//	UserServices userServices;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//		return authConfig.getAuthenticationManager();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//		authProvider.setUserDetailsService(userServices);
//		authProvider.setPasswordEncoder(passwordEncoder());
//
//		return authProvider;
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//				.antMatchers("/index**", "/register**", "/homepage**", "/login", "/js/**", "/css/**", "/img/**")
//				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
//				.logout().invalidateHttpSession(true).clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
//				.permitAll();
//		
//		http.authenticationProvider(authenticationProvider());
//
//		return http.build();
//	}
//
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//	}
//
//}
