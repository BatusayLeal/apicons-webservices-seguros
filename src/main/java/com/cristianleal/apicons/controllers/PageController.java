package com.cristianleal.apicons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/dashboard")
    public String dashboard(Model model) {
        // Aquí más adelante cargaremos el último consumo
        model.addAttribute("mensaje", "Bienvenido al Dashboard");
        return "login"; // temporalmente usamos la misma vista
    }

    @GetMapping("/apiscon")
    public String apiscon() {
        return "apiscon";
    }

    @GetMapping("/historico")
    public String historico() {
        return "historico";
    }
}