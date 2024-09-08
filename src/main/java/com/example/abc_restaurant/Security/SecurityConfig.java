package com.example.abc_restaurant.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.abc_restaurant.Auth.CustomAuthenticationSuccessHandler;
import com.example.abc_restaurant.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final AuthenticationSuccessHandler successHandler;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService, CustomAuthenticationSuccessHandler successHandler) {
        this.userDetailsService = userDetailsService;
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/register", "/api/login", "/api/dishes/all", "/queries/all", "/reservations/all", "/api/services/all", "/gallery/all", "/api/offers/all", "/api/facilities/all", "/api/dishes/add", "/api/dishes/update/{id}", "/api/dishes/delete/{id}",
                "/api/restaurants/add", "/api/facilities/add", "/gallery/add", "/api/offers/add", 
                "/api/offers/update/{id}", "/api/offers/delete/{id}", "/api/services/category/{category}",
                "/api/services/add", "/api/services/delete/{id}", "/api/facilities/update/{id}", "/api/facilities/delete/{id}",
                "/gallery/update/{id}", "/gallery/delete/{id}", "/api/offers/add", "/api/offers/update/{id}",
                "/api/offers/delete/{id}", "/payments/update/{id}", "/queries/add", "/queries/update/{id}", "/queries/delete/{id}", "/queries/{id}", "/queries/respond/{id}", "/queries/user/{userId}", "/reservations/add",
                "/reservations/update/{id}", "/reservations/delete/{id}","/reservations/all", "/payments/all", "/api/restaurants/all", "/api/restaurants/search/name", "/api/restaurants/search/dish").permitAll() 
                
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")  
                .requestMatchers("/staff/**").hasAuthority("ROLE_STAFF")  
                .requestMatchers("/customer/**").hasAuthority("ROLE_CUSTOMER")
                .anyRequest().authenticated()) 
            .formLogin(form -> form
                .loginProcessingUrl("/api/login")
                .successHandler(successHandler)) 
            .logout(logout -> logout
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/api/login"))  
            .sessionManagement(session -> session
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true));  
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(java.util.List.of("http://localhost:5173")); 
        configuration.setAllowedMethods(java.util.List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); 
        configuration.setAllowedHeaders(java.util.List.of("*")); 
        configuration.setAllowCredentials(true);  

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
