package com.empresa.service;

import com.empresa.model.Servico;
import com.empresa.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Optional<Servico> findById(Long id) {
        return servicoRepository.findById(id);
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public void save(Servico servico) {
        servicoRepository.save(servico);
    }

    public void delete(Long id) {
        servicoRepository.deleteById(id);
    }
}
