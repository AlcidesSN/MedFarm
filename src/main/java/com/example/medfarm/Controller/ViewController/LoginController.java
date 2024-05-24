package com.example.medfarm.Controller.ViewController;

import com.example.medfarm.Service.MedicoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/login")
    public String index(){
        return "LoginMedico/login";
    }

    @PostMapping("/logar")
    public String logar(Model model, String crm, String senha, HttpServletResponse response){
        if(medicoService.verificarCrm(crm) && medicoService.buscarPorCrm(crm).getSenha().equals(senha)){
            //criar cockies
            String nome = medicoService.buscarPorCrm(crm).getNome().replace(" ", "-");
            Cookie cookieCrm = new Cookie("crm",crm);
            cookieCrm.setMaxAge(120);
            response.addCookie(cookieCrm);

            return "redirect:/home/medico";
        }
        model.addAttribute("erro","CRM ou senha invalidos.");
        model.addAttribute("crm",crm);
        return "LoginMedico/login";
    }

}
