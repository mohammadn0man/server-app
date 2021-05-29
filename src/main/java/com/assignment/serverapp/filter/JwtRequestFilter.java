package com.assignment.serverapp.filter;

import com.assignment.serverapp.service.JwtService;
import com.assignment.serverapp.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                username = jwtService.extractUsername(jwt);
            } catch (ExpiredJwtException e) {
                //is it fine?
                var sb = new StringBuilder();
                sb.append("{ ");
                sb.append("\"error\": \"Unauthorized\",\n");
                sb.append("\"message\": \"TOKEN_EXPIRED\",\n");
                sb.append("\"path\": \"").append(request.getRequestURL()).append("\"");
                sb.append("} ");
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(sb.toString());
                return;
            }
        }


        if (username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {

            var userDetails = this.userDetailsService.loadUserByUsername(username);

            if (Boolean.TRUE.equals(jwtService.validateToken(jwt, userDetails))) {

                var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
