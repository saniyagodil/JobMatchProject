package com.company.resume.Security;
import com.company.resume.UserSetup.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Autowired
    private SSUserDetailsService  userDetailsService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetailsService userDetailsServiceBean() throws  Exception {

        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/", "/employerregistration", "/appregistration", "/css/**", "/Images/**").permitAll()
                .antMatchers("/basicform", "/sform", "/eduform", "/expform", "/eduupdate", "/expupdate", "/supdate", "/mod", "/refform", "/sdelete", "/edudelete", "/expdelete", "/resume", "/references", "/coverletter", "/cldelete", "/clupdate", "/clform", "/refupdate", "/refdelete").access("hasAuthority('APPLICANT')")
                .antMatchers("/resume", "/coverletter").access("hasAnyAuthority('EMPLOYER', 'APPLICANT')")


                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll().permitAll()
                .and()
                .httpBasic();

        http
                .csrf().disable();


        http
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().
                withUser("applicant").password("apassword").authorities("APPLICANT");
        auth.inMemoryAuthentication().
                withUser("employer").password("epassword").authorities("EMPLOYER");
        auth.inMemoryAuthentication().
                withUser("recruiter").password("rpassword").authorities("RECRUITER");
        auth.userDetailsService(userDetailsServiceBean());

    }


}