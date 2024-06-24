package com.cidadeLimpa.cidadeLimpa.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CheckToken checkToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                    .requestMatchers(HttpMethod.POST, "/lixeirasParaColeta").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/lixeirasParaColeta/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/lixeirasParaColeta").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/lixeirasParaColeta").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/lixeirasParaColeta/*").hasAnyRole("ADMIN", "USER")

                    .requestMatchers(HttpMethod.POST, "/lixeiras").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/lixeiras/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/lixeiras").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/lixeiras").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/lixeiras/*").hasAnyRole("ADMIN", "USER")

                    .requestMatchers(HttpMethod.POST, "/rotas").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/rotas/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/rotas").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/rotas").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/rotas/*").hasAnyRole("ADMIN", "USER")

                    .requestMatchers(HttpMethod.POST, "/caminhoes").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/caminhoes/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/caminhoes").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/caminhoes").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/caminhoes/*").hasAnyRole("ADMIN", "USER")

                    .requestMatchers(HttpMethod.POST, "/coletas").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/coletas/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/coletas").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/coletas/*").hasAnyRole("ADMIN", "USER")

                    .anyRequest().authenticated()
                )
                .addFilterBefore(
                    this.checkToken,
                    UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
