package com.csye6220.carrentalsystem.config;

import com.csye6220.carrentalsystem.service.MyUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final MyUserDetailsService userDetailsService;

    public WebSecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	      
	           http.csrf(csrf -> csrf.disable())
	          .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	          .authorizeHttpRequests(auth -> auth
	          .requestMatchers("/", "/cars", "/rental-agencies", "/users").permitAll()
	          .anyRequest()
	          .authenticated());
    
	          return http.build();
	  }
    
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                (authorize) -> authorize
//                        .requestMatchers("/", "/error", "/signup", "/login", "/movie", "/theater", "/showtime", "/details/", "/search", "/booking/**").permitAll()
//                        .requestMatchers("/add", "/delete", "/users/**").hasAnyAuthority("ADMIN", "STAFF")
//                        .requestMatchers("*/approve").hasAnyAuthority("ADMIN")
//                        .anyRequest().authenticated()
//        )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/", true)
//                        .failureHandler((request, response, exception) -> {
//                            String errorMessage;
//                            if (exception instanceof UsernameNotFoundException) {
//                                errorMessage = "User not found";
//                            } else if (exception instanceof BadCredentialsException) {
//                                errorMessage = "Invalid password";
//                            } else {
//                                errorMessage = "Authentication failed";
//                            }
//
//                        request.getSession().setAttribute("error", errorMessage);
//                new DefaultRedirectStrategy().sendRedirect(request, response, "/login?error=true");
//            })
//    )
//    .logout((logout) -> logout
//            .permitAll()
//            .logoutUrl("/")
//    );
//
//        	return http.build();
//    }
}    
