package com.example.medfarm.Controller;

import com.example.medfarm.Models.Medico;

import com.example.medfarm.Routes;
import com.example.medfarm.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private Routes routes;


    @GetMapping("/login")
    public ModelAndView validarLogin(@RequestParam(value = "crm") String crm,
                                     @RequestParam(value = "senha") String senha){
        if(medicoService.verificarCrm(crm)){
            if (medicoService.buscarPorCrm(crm).getSenha().equals(senha)){
                Map<String,String> map = new HashMap<>();
                map.put("nome",medicoService.buscarPorCrm(crm).getNome());
                return new ModelAndView("loginaceito",map);
            }
        }
        return null;
    }


    @ResponseBody
    @GetMapping
    public List<Medico> listar(){ return medicoService.listar();}

    @ResponseBody
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Medico medico){
        if(medicoService.criar(medico) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medico);
        }
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Medico medico,@PathVariable long id){
        if(!medicoService.verificarId(id)){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            medicoService.atualizar(medico,id);
            return ResponseEntity.ok(medico);
        }
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Medico> buscarId(@PathVariable long id){
        return medicoService.buscarPorID(id);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(medicoService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }

    }


}
