package io.github.books_test_task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("John")
                .password("{noop}pas1")
                .roles("USER")
                .build();

        UserDetails mary = User.builder()
                .username("Mary")
                .password("{noop}pas2")
                .roles("USER")
                .build();

        UserDetails susan = User.builder()
                .username("Susan")
                .password("{noop}pas3")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}
