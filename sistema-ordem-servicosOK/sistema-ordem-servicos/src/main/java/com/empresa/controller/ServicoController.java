package com.empresa.controller;

import com.empresa.model.Servico;
import com.empresa.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public String listServicos(Model model) {
        List<Servico> servicos = servicoService.findAll();
        model.addAttribute("servicos", servicos);
        return "servicos";
    }

    @GetMapping("/new")
    public String newServico(Model model) {
        model.addAttribute("servico", new Servico());
        return "servico-form";
    }

    @PostMapping
    public String saveServico(@ModelAttribute("servico") Servico servico) {
        servicoService.save(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/edit/{id}")
    public String editServico(@PathVariable Long id, Model model) {
        Optional<Servico> servicoOptional = servicoService.findById(id);
        if (servicoOptional.isPresent()) {
            model.addAttribute("servico", servicoOptional.get());
            return "servico-form";
        } else {
            return "redirect:/servicos";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteServico(@PathVariable Long id) {
        servicoService.delete(id);
        return "redirect:/servicos";
    }
}
