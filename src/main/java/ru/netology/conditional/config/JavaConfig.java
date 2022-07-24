package ru.netology.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.conditional.profile.DevProfile;
import ru.netology.conditional.profile.ProductionProfile;
import ru.netology.conditional.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(name = "springboot.profiles.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile getProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value= "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
