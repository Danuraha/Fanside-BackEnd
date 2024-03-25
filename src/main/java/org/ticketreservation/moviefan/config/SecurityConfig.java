package org.ticketreservation.moviefan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.ticketreservation.moviefan.Security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        //database connectivity
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //1st line
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // if u need to uncomment the 1st line then dlt it
        return provider;
    }

//    @Bean
//    public JwtTokenProvider jwtTokenProvider() {
//        return new JwtTokenProvider();
//    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
//configurer.disable();
//            }
//        };
//
//        http.csrf(custCsrf);
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>custHttp=new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry  registry) {
//                registry.anyRequest().authenticated();
//            }
//        };
//        http.authorizeHttpRequests(custHttp);

        http
                .csrf(customizer->customizer.disable())
                .authorizeHttpRequests(authorize ->{

                    authorize.requestMatchers("/register").permitAll()
//                            .requestMatchers("/loginU").permitAll()
                            .anyRequest().authenticated();
                })
//              .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //make it stateless session

    return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user= User
//                            .withDefaultPasswordEncoder()
//                            .username("danuraha")
//                            .password("12345")
//                            .roles("USER")
//                            .build();
//        UserDetails admin= User
//                            .withDefaultPasswordEncoder()
//                            .username("Thanu")
//                            .password("54321")
//                            .roles("ADMIN")
//                            .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }



}
