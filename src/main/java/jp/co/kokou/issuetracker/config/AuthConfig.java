package jp.co.kokou.issuetracker.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/css/**", "/js/**").permitAll()
                .mvcMatchers("/issues/**").authenticated()
                .and()
                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/auth/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .logoutUrl("/auth/logout").permitAll();
    }
}
