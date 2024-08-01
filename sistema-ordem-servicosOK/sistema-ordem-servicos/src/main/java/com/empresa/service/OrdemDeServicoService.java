package com.empresa.service;

import com.empresa.model.OrdemDeServico;
import com.empresa.repository.OrdemDeServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public OrdemDeServico save(OrdemDeServico ordemDeServico) {
        return ordemDeServicoRepository.save(ordemDeServico);
    }

    public List<OrdemDeServico> findAll() {
        return ordemDeServicoRepository.findAll();
    }

    public OrdemDeServico findById(Long id) {
        return ordemDeServicoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        ordemDeServicoRepository.deleteById(id);
    }
}
