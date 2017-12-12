package tmarshal.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/images/**","/css/**","/login","/js/**","/forgot-username","/forgot-password","/v1").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                // Below is for the rest controllers???
                .and()
                .httpBasic().and().authorizeRequests().antMatchers("/v1/**")
                .hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
                .csrf().disable().headers().frameOptions().disable()
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tony").password(encoder.encode("password")).roles("USER", "ADMIN")
                .and()
                .withUser("tom").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("jerry").password(encoder.encode("password")).roles("USER");
    }
}