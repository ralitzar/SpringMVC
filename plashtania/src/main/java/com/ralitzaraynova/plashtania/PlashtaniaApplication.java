package com.ralitzaraynova.plashtania;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class PlashtaniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlashtaniaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("bg-BG"));
	}
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
