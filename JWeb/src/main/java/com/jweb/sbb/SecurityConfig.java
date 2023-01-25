package com.jweb.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 모든 인증되지 않은 요청을 허락
		http.authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
		.and()
			.csrf()
			.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
		.and()
			.headers()
			.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
		.and()
			.formLogin()
			.loginPage("/user/login")
			.defaultSuccessUrl("/question/list")
		.and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            .logoutSuccessUrl("/question/list")
            .invalidateHttpSession(true)
			;
		/// h2-console/로 시작하는 URL은 CSRF 검증을 하지 않는다는 설정이다.

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 
	 * @param authenticationConfiguration
	 * @return
	 * @throws Exception
	 * 
	 *                   빈에 등록하면 스프링 시큐리티가 알아서 처리해줌..? AuthenticationManager 빈을
	 *                   생성했다. AuthenticationManager는 스프링 시큐리티의 인증을 담당한다.
	 *                   AuthenticationManager 빈 생성시 스프링의 내부 동작으로 인해 위에서 작성한
	 *                   UserSecurityService와 PasswordEncoder가 자동으로 설정된다.
	 */

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
