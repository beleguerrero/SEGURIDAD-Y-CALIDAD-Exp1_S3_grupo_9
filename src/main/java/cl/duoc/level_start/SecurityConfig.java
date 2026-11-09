package cl.duoc.level_start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cl.duoc.level_start.jwt.JwtFilter;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig {

    private final JwtFilter jwtFilter;


    SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }


    @Bean 
    @Order(1)
    public SecurityFilterChain apFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
        .securityMatcher("/api/**")
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll().anyRequest().authenticated())
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
    
    @Bean 
    @Order(2)
    public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
        http
        .headers(headers -> headers
            .contentSecurityPolicy(csp -> csp
                .policyDirectives(
                    "default-src 'self'; " +
                    "script-src 'self'; " +
                    "style-src 'self'; " +
                    "style-src-elem 'self'; " +
                    "style-src-attr 'none'; " +
                    "font-src 'self'; " +
                    "img-src 'self' data:; " +
                    "object-src 'none'; " +
                    "base-uri 'self'; " +
                    "form-action 'self'; " +
                    "frame-ancestors 'self'; " +
                    "connect-src 'self'; " +
                    "media-src 'self'"
                )
            )
            .contentTypeOptions(Customizer.withDefaults())
        )
        .authorizeHttpRequests(
            requests -> requests
            .requestMatchers("/", "/home", "/login", "/403", "/registro").permitAll()
            // .requestMatchers("/tailwind.config.js").permitAll()
            .requestMatchers("/**.css", "/css/**.css").permitAll()
            .requestMatchers("/fonts/**").permitAll()
            .anyRequest().authenticated()
        )
        .exceptionHandling(
            exception -> exception
            .authenticationEntryPoint((request, response, authException) ->
                response.sendRedirect("/403")
            )
            .accessDeniedPage("/403")
        )
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("usuario")
            .passwordParameter("password")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/login?error")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID", "jwt")
            .permitAll()
        );
        // .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
