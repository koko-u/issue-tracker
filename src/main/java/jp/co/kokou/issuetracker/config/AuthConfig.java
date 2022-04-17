package jp.co.kokou.issuetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/css/**", "/js/**").permitAll()
                .mvcMatchers("/issues/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/auth/logout").permitAll();
    }
}