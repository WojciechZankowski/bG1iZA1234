package pl.lodomaniak.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import pl.lodomaniak.auth.CustomCorsFilter;
import pl.lodomaniak.auth.UnauthorizedEntryPoint;
import pl.lodomaniak.auth.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;
    private final CustomCorsFilter corsFilter;

    @Autowired
    public SecurityConfiguration(final JwtFilter jwtFilter, final CustomCorsFilter corsFilter) {
        this.jwtFilter = jwtFilter;
        this.corsFilter = corsFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .exceptionHandling()
            .authenticationEntryPoint(http401UnauthorizedEntryPoint())
        .and()
            .csrf().disable()
            .logout().disable()
            .authorizeRequests()
            .antMatchers("/signin/**").permitAll()
            .antMatchers("/api/register").permitAll()
            .antMatchers("/api/activate").permitAll()
            .antMatchers("/api/account/password-reset").permitAll()
            .antMatchers("/api/account/password-reset/init").permitAll()
            .antMatchers("/api/authenticate").permitAll()
            .antMatchers("/api/authenticate/social/facebook").permitAll()
            .antMatchers("/api/image").permitAll()
            .antMatchers("/api/icecreamshop/cities").permitAll()
            .antMatchers("/api/icecreamshop/last").permitAll()
            .antMatchers("/api/icecreamshop/top").permitAll()
            .antMatchers(HttpMethod.GET, "/api/icecreamshop").permitAll()
            .antMatchers("/api/flavor/schedule/today").permitAll()
            .antMatchers("/api/flavor/schedule/list").permitAll()
            .antMatchers("/api/flavor/top").permitAll()
            .antMatchers(HttpMethod.GET, "/api/flavor").permitAll()
            .antMatchers("/api/**").authenticated()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(corsFilter, CorsFilter.class)
            .headers().cacheControl();
        // @formatter:on
    }

    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Bean
    public UnauthorizedEntryPoint http401UnauthorizedEntryPoint() {
        return new UnauthorizedEntryPoint();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Ensures the filter is fired only once per request.
     */
    @Bean
    public FilterRegistrationBean jwtAuthenticationFilterRegistration(final JwtFilter filter) {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
