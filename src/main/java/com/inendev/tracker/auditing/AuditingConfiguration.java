package com.inendev.tracker.auditing;

import com.inendev.tracker.security.utils.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfiguration {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return SecurityUtils::getCurrentUserLogin;
    }
}
