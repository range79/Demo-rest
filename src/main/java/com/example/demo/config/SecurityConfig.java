package com.example.demo.config;

import com.example.demo.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final CustomUserDetailService customUserDetailService;
    private final CustomPasswordEncoder customPasswordEncoder;
    public SecurityConfig(CustomUserDetailService customUserDetailService,CustomPasswordEncoder customPasswordEncoder) {
        this.customUserDetailService = customUserDetailService;
        this.customPasswordEncoder = customPasswordEncoder;
    }




    @Bean
    public SecurityFilterChain   securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->authorizeRequests
                        .requestMatchers("/user/login").permitAll()
                        .requestMatchers("/user/register").permitAll()
                        .requestMatchers("user/delete/").hasAnyRole("ADMIN","MODERATOR","KING")
                        .requestMatchers("user/update/").hasAnyRole("ADMIN","MODERATOR","KING")
                        .requestMatchers("user/update/password").hasAnyRole("ADMIN","MODERATOR","KING")
                                      .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()

                        .anyRequest().authenticated()


                ).httpBasic(Customizer.withDefaults());
        return http.build();

    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailService);
        authProvider.setPasswordEncoder(customPasswordEncoder.passwordEncoder());
    return authProvider;
    }


}
