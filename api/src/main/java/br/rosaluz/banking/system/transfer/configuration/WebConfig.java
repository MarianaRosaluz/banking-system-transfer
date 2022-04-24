package br.rosaluz.banking.system.transfer.configuration;

import br.rosaluz.banking.system.transfer.dto.converter.TransferDTOToTransfer;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new TransferDTOToTransfer());
    }
}
