package cloud.training.aws.oauth2.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${aws.cognito.logout-url}")
    private String logoutUrl;

    @Value("${aws.cognito.logout.success.redirect-url}")
    private String logoutRedirectUrl;

    @Value("${spring.security.oauth2.client.registration.cognito.client-id}")
    private String clientId;

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutSuccessHandler(new CustomLogoutHandler(logoutUrl, logoutRedirectUrl, clientId)));
        return http.build();
    }
}
