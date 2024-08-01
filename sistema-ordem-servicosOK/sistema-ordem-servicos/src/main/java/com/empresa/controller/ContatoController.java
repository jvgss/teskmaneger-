package com.empresa.controller;

import com.empresa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contato")
    public ModelAndView submitContactForm(@RequestParam String nome,
                                          @RequestParam String email,
                                          @RequestParam String mensagem) {
        emailService.sendSimpleMessage(email, "Nova mensagem de contato", mensagem);
        return new ModelAndView("redirect:/contato-success");
    }
}
