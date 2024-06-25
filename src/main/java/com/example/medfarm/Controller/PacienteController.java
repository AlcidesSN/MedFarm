package com.example.medfarm.Controller;

import com.example.medfarm.Models.Paciente;
import com.example.medfarm.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin( origins = "http://localhost:4200/")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;


    @GetMapping
    public List<Paciente> listar(){ return pacienteService.listar();}


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Paciente paciente){
        if(pacienteService.criar(paciente) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(paciente);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Paciente paciente,@PathVariable long id){
        if(!pacienteService.verificarId(id)){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            pacienteService.atualizar(paciente,id);
            return ResponseEntity.ok(paciente);
        }
    }


    @GetMapping("/{id}")
    public Optional<Paciente> buscarId(@PathVariable long id){
        return pacienteService.buscarPorID(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(pacienteService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }

    }


}
