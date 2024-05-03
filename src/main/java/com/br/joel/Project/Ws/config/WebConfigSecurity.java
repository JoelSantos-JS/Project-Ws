package com.br.joel.Project.Ws.config;

import com.br.joel.Project.Ws.filter.AuthenticationFilter;
import com.br.joel.Project.Ws.repository.UserCredentialsRepository;
import com.br.joel.Project.Ws.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenService tokenService;


    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    // Pela configuraçao de Usuarios
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().antMatchers(HttpMethod.POST,"/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/subs").permitAll()
                .antMatchers(HttpMethod.GET, "/subs/*").permitAll()
                .antMatchers(HttpMethod.POST, "/subs").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST , "/payment").permitAll()
                .antMatchers(HttpMethod.POST, "/payment/*").permitAll()
                .anyRequest().authenticated().and().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AuthenticationFilter(tokenService, userCredentialsRepository), UsernamePasswordAuthenticationFilter.class);
    }

    //Responsavel Pela Configuraçao de authenticaçao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Responsavel Pela configuraçao de Arquivos Staticos
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

    //Pela Conf

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }



}
