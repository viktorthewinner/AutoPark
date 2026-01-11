/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.controller;

import com.example.demo.model.Masina;
import com.example.demo.model.Client;
import com.example.demo.repository.MasinaRepository;
import com.example.demo.repository.ClientRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MasinaController {

    @Autowired
    private MasinaRepository masinaRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/parc-auto")
    public String showCars(@RequestParam(defaultValue = "idMasina") String field,
                           @RequestParam(defaultValue = "ASC") String dir,
                           HttpSession session, Model model) {

        Sort sort = dir.equalsIgnoreCase("ASC") ? Sort.by(field).ascending() : Sort.by(field).descending();
        List<Masina> lista = masinaRepository.findAll(sort);

        model.addAttribute("listaMasini", lista);
        model.addAttribute("currentUser", session.getAttribute("loggedInUser"));
        model.addAttribute("nouaMasina", new Masina());

        model.addAttribute("listaClienti", clientRepository.findAll());

        model.addAttribute("reverseDir", dir.equalsIgnoreCase("ASC") ? "DESC" : "ASC");

        return "lista-masini";
    }

    @PostMapping("/admin/update-status")
    public String updateStatus(@RequestParam Integer masinaId, @RequestParam(required = false) Integer clientId) {
        Masina masina = masinaRepository.findById(masinaId).orElse(null);
        if (masina != null) {
            if (clientId != null) {
                Client c = clientRepository.findById(clientId).orElse(null);
                masina.setCumparator(c);
            } else {
                masina.setCumparator(null);
            }
            masinaRepository.save(masina);
        }
        return "redirect:/parc-auto";
    }

    @PostMapping("/admin/add-client-and-sell")
    public String addClientAndSell(@ModelAttribute Client client, @RequestParam Integer masinaId) {
        Client salvat = clientRepository.save(client);
        Masina masina = masinaRepository.findById(masinaId).orElse(null);
        if (masina != null) {
            masina.setCumparator(salvat);
            masinaRepository.save(masina);
        }
        return "redirect:/parc-auto";
    }

    @PostMapping("/admin/add-masina")
    public String addMasina(@ModelAttribute("nouaMasina") Masina masina) {
        masinaRepository.save(masina);
        return "redirect:/parc-auto";
    }

    @PostMapping("/admin/delete-masina")
    public String deleteMasina(@RequestParam Integer masinaId) {
        masinaRepository.deleteById(masinaId);
        return "redirect:/parc-auto";
    }
}