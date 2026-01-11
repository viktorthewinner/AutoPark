/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.controller;

import com.example.demo.model.Utilizator;
import com.example.demo.repository.UtilizatorRepository;
import jakarta.servlet.http.HttpSession; // <--- ACEST IMPORT LIPSÈA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UtilizatorController {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("utilizator", new Utilizator());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("utilizator") Utilizator utilizator) {
        utilizatorRepository.save(utilizator);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String parola,
                            HttpSession session,
                            Model model) {

        Optional<Utilizator> userFound = utilizatorRepository.findByUsername(username);

        if (userFound.isPresent()) {
            Utilizator u = userFound.get();
            if (u.getParola().equals(parola)) {
                // Salvăm utilizatorul în sesiune pentru a-l recunoaște în Parc Auto
                session.setAttribute("loggedInUser", username);
                return "redirect:/parc-auto";
            }
        }

        model.addAttribute("error", "Username sau parolă incorectă!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/contacts")
    public String showContacts() {
        return "contacts";
    }
}