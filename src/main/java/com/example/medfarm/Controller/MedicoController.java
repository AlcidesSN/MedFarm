package com.example.medfarm.Controller;

import com.example.medfarm.Models.Medico;


import com.example.medfarm.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
@CrossOrigin( origins = "http://localhost:4200/")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;





    @GetMapping
    public List<Medico> listar(){ return medicoService.listar();}


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Medico medico){
        if(medicoService.criar(medico) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medico);
        }
    }


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


    @GetMapping("/{id}")
    public Optional<Medico> buscarId(@PathVariable long id){
        return medicoService.buscarPorID(id);
    }


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
