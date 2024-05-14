//package com.capolavoroprova.capolavoro.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@CrossOrigin("*")
//public class WebSecurityConfiguration {
//
//    private static final String[] GET_WHITELIST = {
//            "/api/v1/caseList/**",
//            "/api/v1/caseList",
//            "/api/v1/caseList/cerca/*/*/*/*"
//    };
//
//    private static final String[] POST_WHITELIST = {
//            "/api/v1/caseList"
//    };
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(HttpMethod.GET, GET_WHITELIST).permitAll()
//                        .requestMatchers(HttpMethod.POST, POST_WHITELIST).permitAll()
//                        .anyRequest().permitAll()
//                );
//
//
//        return http.build();
//    }
//}
