package com.empresa.converter;

import com.empresa.model.Servico;
import com.empresa.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToServicoConverter implements Converter<String, Servico> {

    @Autowired
    private ServicoService servicoService;

    @Override
    public Servico convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(source);
        return servicoService.findById(id).orElse(null);
    }
}
