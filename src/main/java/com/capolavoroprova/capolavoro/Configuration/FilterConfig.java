package com.capolavoroprova.capolavoro.Configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
     public FilterRegistrationBean<FirebaseAuthenticationFilter> firebaseAuthenticationFilter(){
        System.out.println("\n\n\nentro filter\n\n\n");
         FilterRegistrationBean<FirebaseAuthenticationFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
         filterFilterRegistrationBean.setFilter(new FirebaseAuthenticationFilter());
        filterFilterRegistrationBean.addUrlPatterns("/**");
        filterFilterRegistrationBean.addUrlPatterns("/api/v1/caseList/**");
//        filterFilterRegistrationBean.addUrlPatterns("/**");
//        filterFilterRegistrationBean.addUrlPatterns("/**");
//        filterFilterRegistrationBean.addUrlPatterns("/**");
         return filterFilterRegistrationBean;
     }
}
