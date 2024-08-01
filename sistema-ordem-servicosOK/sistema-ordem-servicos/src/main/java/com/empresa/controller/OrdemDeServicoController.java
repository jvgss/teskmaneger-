package com.empresa.controller;

import com.empresa.model.OrdemDeServico;
import com.empresa.service.ClienteService;
import com.empresa.service.OrdemDeServicoService;
import com.empresa.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ordens")
public class OrdemDeServicoController {

    @Autowired
    private OrdemDeServicoService ordemDeServicoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public String listOrdens(Model model) {
        List<OrdemDeServico> ordens = ordemDeServicoService.findAll();
        model.addAttribute("ordens", ordens);
        return "ordens";
    }

    @GetMapping("/new")
    public String newOrdem(Model model) {
        model.addAttribute("ordem", new OrdemDeServico());
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("servicos", servicoService.findAll());
        return "ordem-form";
    }

    @PostMapping
    public String saveOrdem(@ModelAttribute("ordem") OrdemDeServico ordemDeServico) {
        ordemDeServicoService.save(ordemDeServico);
        return "redirect:/ordens";
    }

    @GetMapping("/edit/{id}")
    public String editOrdem(@PathVariable Long id, Model model) {
        OrdemDeServico ordem = ordemDeServicoService.findById(id);
        model.addAttribute("ordem", ordem);
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("servicos", servicoService.findAll());
        return "ordem-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrdem(@PathVariable Long id) {
        ordemDeServicoService.delete(id);
        return "redirect:/ordens";
    }
}
