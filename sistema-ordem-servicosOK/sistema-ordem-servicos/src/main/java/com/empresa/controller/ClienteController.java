package com.empresa.controller;

import com.empresa.model.Cliente;
import com.empresa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("./")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes";
    }

    @GetMapping("/new")
    public String newCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String editCliente(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
        } else {
            model.addAttribute("error", "Cliente não encontrado");
            return "redirect:/clientes";
        }
        return "cliente-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}
