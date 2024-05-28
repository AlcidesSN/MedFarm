package com.example.medfarm.Controller;

import com.example.medfarm.Models.Farmacia;
import com.example.medfarm.Service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {


    @Autowired
    private FarmaciaService farmaciaService;


    @GetMapping
    public List<Farmacia> listar(){ return farmaciaService.listar();}


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Farmacia farmacia){
        if(farmaciaService.criar(farmacia) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(farmacia);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Farmacia farmacia,@PathVariable long id){
        if(!farmaciaService.verificarId(id)){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            farmaciaService.atualizar(farmacia,id);
            return ResponseEntity.ok(farmacia);
        }
    }


    @GetMapping("/{id}")
    public Optional<Farmacia> buscarId(@PathVariable long id){
        return farmaciaService.buscarPorID(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(farmaciaService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }

    }


 }
