package com.capolavoroprova.capolavoro.Configuration;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

//import com.capolavoroprova.capolavoro.Models.UserAuthenticated;
//import com.capolavoroprova.capolavoro.Services.AuthenticationService;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
public class FirebaseAuthenticationFilter implements Filter {

    //private final AuthenticationService authenticationService;



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("\n\n\n\nEntro dentro al filtro di autenticazione\n\n\n\n");
//        /*4° letto*/
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        String uri = httpServletRequest.getRequestURI();
//
//        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//            filterChain.doFilter(request, response);
//        }
//
//        String idToken = httpServletRequest.getHeader("Authorization");
//        System.out.println("valore che ho trovato nel Authorization: " + idToken);
//
//        if (idToken != null) {
//            try {
//                System.out.println(idToken);
//                FirebaseAuth auth = FirebaseAuth.getInstance();
//                FirebaseToken firebaseToken = auth.verifyIdToken(idToken);
//                httpServletRequest.setAttribute("userId", firebaseToken.getUid());
//                UserAuthenticated userAuthenticated = authenticationService.getAuthentication(
//                        firebaseToken.getUid()
//                );
//                SecurityContextHolder.getContext().setAuthentication(
//                        new UsernamePasswordAuthenticationToken(
//                                userAuthenticated, null,
//                                Collections.singletonList(
//                                        new SimpleGrantedAuthority(
//                                                userAuthenticated.getRuolo().name()
//                                            )
//                                )
//                        )
//                );
//                filterChain.doFilter(httpServletRequest, httpServletResponse);
//            } catch (FirebaseException e) {
//                e.printStackTrace();
//                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
//        }
//        else {
//            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
        System.out.println("Entro");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String uri = httpServletRequest.getRequestURI();
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        filterChain.doFilter(request, httpServletResponse);
    }
}

