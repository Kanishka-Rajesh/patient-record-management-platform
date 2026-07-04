package com.karthick.patientrecordmanagement.security.filter;

import com.karthick.patientrecordmanagement.security.jwt.JwtService;
import com.karthick.patientrecordmanagement.security.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



@Component
@RequiredArgsConstructor


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;


    @Override

    
    protected void doFilterInternal(

        

        
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // Read Authorization Header
        String authHeader = request.getHeader("Authorization");

        System.out.println("==============");
System.out.println("Authorization Header = " + authHeader);

        // If no Bearer token, continue the request
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer "
        String jwt = authHeader.substring(7);

        // Extract username from JWT
        String username = jwtService.extractUsername(jwt);

        System.out.println("Username = " + username);

        // Authenticate only if user is not already authenticated
        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails =
                    customUserDetailsService.loadUserByUsername(username);

            // Validate JWT
            if (jwtService.isTokenValid(jwt, userDetails.getUsername())) {

                System.out.println("TOKEN VALID");

                System.out.println("JWT VALID");
System.out.println("User : " + userDetails.getUsername());

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

                        System.out.println("Authentication set successfully");
            }
        }

        filterChain.doFilter(request, response);
    }
}