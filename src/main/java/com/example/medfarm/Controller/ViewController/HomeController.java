package com.example.medfarm.Controller.ViewController;

import com.example.medfarm.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private ReceitaService receitaService;
    @Autowired
    private MedicamentoService medicamentoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping("/home/medico")
    public String MHome(@CookieValue(value = "crm",defaultValue = "nada") String cookieCrm,
                        Model model){
        if(cookieCrm.equals("nada"))
            return "redirect:/login";

        model.addAttribute("nome",medicoService.buscarPorCrm(cookieCrm).getNome());
        model.addAttribute("crm",cookieCrm);


        return "LoginMedico/home";
    }
    @GetMapping("/Medico/nova-receita")
    public String novaReceita(Model model){
        model.addAttribute("remedios",medicamentoService.listar());
        List<String> pacientesNomes = new ArrayList<>();
        for (int i = 0; i < pacienteService.listar().size(); i++) {
            pacientesNomes.add(pacienteService.listar().get(i).getName());
        }
        model.addAttribute("pacientes",pacientesNomes);
        model.addAttribute("farmacias",farmaciaService.listar());
        model.addAttribute("nome", "qualquernome");
        return "LoginMedico/novaReceita";
    }
}
