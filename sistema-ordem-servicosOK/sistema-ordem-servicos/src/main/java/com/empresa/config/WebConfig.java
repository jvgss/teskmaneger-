package com.empresa.config;

import com.empresa.converter.StringToClienteConverter;
import com.empresa.converter.StringToServicoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.ComponentScan;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringToClienteConverter stringToClienteConverter;
    private final StringToServicoConverter stringToServicoConverter;

    public WebConfig(StringToClienteConverter stringToClienteConverter, StringToServicoConverter stringToServicoConverter) {
        this.stringToClienteConverter = stringToClienteConverter;
        this.stringToServicoConverter = stringToServicoConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToClienteConverter);
        registry.addConverter(stringToServicoConverter);
    }
}





