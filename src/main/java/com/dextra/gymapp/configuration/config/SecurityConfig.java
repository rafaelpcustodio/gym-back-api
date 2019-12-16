package com.dextra.gymapp.configuration.config;

import com.dextra.gymapp.configuration.security.CustomUserDetailsService;
import com.dextra.gymapp.configuration.security.JwtAuthenticationEntryPoint;
import com.dextra.gymapp.configuration.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity // enables web security in a project (Spring)
@EnableGlobalMethodSecurity(
        securedEnabled = true, // it enables Secured to protect controller and service methods
        jsr250Enabled = true, // it enables RolesAllowed
        prePostEnabled = true // it enables more complex expression based access control syntax
)                             // like isAnonymous, hasRole, etc..
public class SecurityConfig extends WebSecurityConfigurerAdapter { // default security config, allows classes to extend
                                                                    // it and customize the security config by overriding methods.

    // to authenticate an user or perform  various role-based checks.
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    // is used to return 401 unauthorized error to clients that try to access a protected resource.
    // without permissions.
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    // read JWT authentication token from Authorization header of all requests
    // validates token
    // loads the user detail associated with that token
    //sets the user details in Spring security security context. Spring security uses the user details
    // to perform authorization checks. We can also access the user details stored in the security context
    // in our controllers to perform our business logig.
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }


    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                .permitAll()
                .antMatchers("/auth/**")
                .permitAll()
                .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
