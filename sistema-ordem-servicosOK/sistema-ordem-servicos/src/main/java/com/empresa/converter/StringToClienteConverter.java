package com.empresa.converter;

import com.empresa.model.Cliente;
import com.empresa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToClienteConverter implements Converter<String, Cliente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Cliente convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Long id = Long.parseLong(source);
        return clienteService.findById(id).orElse(null);
    }
}
