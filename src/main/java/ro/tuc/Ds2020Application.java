package ro.tuc;

//import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ro.tuc.webapp.controllers.AuthenticationController;

import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@Validated
public class Ds2020Application extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Ds2020Application.class);
    }

//    @Retryable(value = PSQLException.class, maxAttempts = 10, backoff = @Backoff(delay = 1000))
    public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		LOGGER.warn("______________________________ RESTARTING APP________________________________");
        SpringApplication.run(Ds2020Application.class, args);
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsCfg = new CorsConfiguration();
        corsCfg.applyPermitDefaultValues();
        corsCfg.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsCfg.setAllowCredentials(true);
        corsCfg.addAllowedOrigin("*");
        corsCfg.addAllowedHeader("*");
        corsCfg.addAllowedMethod(HttpMethod.DELETE);
        corsCfg.addAllowedMethod(HttpMethod.PUT);
        source.registerCorsConfiguration("/**", corsCfg);
        return source;
    }
}
