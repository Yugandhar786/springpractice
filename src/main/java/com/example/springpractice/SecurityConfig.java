package com.example.springpractice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        httpSecurity.authorizeHttpRequests(auth ->
                auth.requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
//                        .requestMatchers("/").permitAll()
        ).formLogin(form -> form.permitAll().defaultSuccessUrl("/dashboard"))
//                .csrf(csrf -> csrf.disable())
                .csrf(AbstractHttpConfigurer::disable);


        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.withUsername("Tomahawk").password(passwordEncoder().encode("password"))
                .roles("user").build();
        UserDetails user1 = User.withUsername("Admin")
                .password(passwordEncoder().encode("admin")).roles("admin").build();

        return new InMemoryUserDetailsManager(user, user1);

    }


}
