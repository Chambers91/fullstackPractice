package com.example.fullstackPractice.security.config;


import com.example.fullstackPractice.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

@Autowired
private AppUserService appUserService;
//    public AppUserService appUserService(){
//        return appUserService();
//    };
    @Bean("pwEncoder")
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer = http.authorizeRequests()
                .requestMatchers("/api/v*/registration/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin();

        return http.build();
    }
//
//    @Bean
//    public WebSecurityCustomizer WebSecurityCustomizer(){
//    return this.WebSecurityCustomizer();
//    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}


