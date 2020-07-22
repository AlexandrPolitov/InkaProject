package code.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import code.entities.User;
import code.repo.UserRepo;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/main").authenticated() // только для зарегистрированных
                .antMatchers("/**").permitAll() // общий доступ
                .anyRequest().authenticated() // только для зарегистрированных
                .and();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/getUserInfo")
                .permitAll()
                .and();

        http.logout().clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .permitAll();

        /*      .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout.done").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)*/
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepo userRepo) {
        return map -> {
            User user =  new User();
            user.setUserPic((String) map.get("picture"));
            user.setGender((String) map.get("gender"));
            user.setLocale((String) map.get("locale"));
            user.setEmail((String) map.get("email"));
            user.setName((String) map.get("name"));
            user.setLastVisit(LocalDateTime.now());
            user.setId((String) map.get("sub"));
            return userRepo.save(user);
        };
    }
}