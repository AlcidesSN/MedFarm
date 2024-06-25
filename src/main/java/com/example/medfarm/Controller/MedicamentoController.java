package com.example.medfarm.Controller;

import com.example.medfarm.Models.Medicamento;
import com.example.medfarm.Service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin( origins = "http://localhost:4200/")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;



    @GetMapping
    public List<Medicamento> listar(){ return medicamentoService.listar();}


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Medicamento medicamento){
        if(medicamentoService.criar(medicamento) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medicamento);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Medicamento medicamento,@PathVariable long id){
        if(!medicamentoService.verificarId(id)){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            medicamentoService.atualizar(medicamento,id);
            return ResponseEntity.ok(medicamento);
        }
    }


    @GetMapping("/{id}")
    public Optional<Medicamento> buscarId(@PathVariable long id){
        return medicamentoService.buscarPorID(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(medicamentoService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }

    }


}
