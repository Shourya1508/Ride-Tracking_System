package com.example.demo.config;


//import com.tungvo.gwtspringbootexample.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtAuthenticationEntrypoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity)
            throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
            authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        return authenticationManagerBuilder.build();
    }
    @SuppressWarnings({ "deprecation", "removal" })
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);

        httpSecurity.csrf().disable()
                .authorizeRequests()
                // dont authenticate this particular request
                .requestMatchers("/authenticate").permitAll()
                // all other requests need to be authenticated
                .anyRequest().authenticated()
                .and()
                // make sure we use stateless session; session won't be used to
                // store user's state.
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/authenticate");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
