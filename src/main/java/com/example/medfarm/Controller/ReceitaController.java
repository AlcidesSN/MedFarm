package com.example.medfarm.Controller;

import com.example.medfarm.Models.Receita;
import com.example.medfarm.Service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @ResponseBody
    @GetMapping
    public List<Receita> listar(){ return receitaService.listar();}

    @ResponseBody
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Receita receita){
        if(receitaService.criar(receita) == null){
            String mensagem = "O Funcionario ou o Animal não exitem, por favor verifique e faça a requisição novamente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(receita);
        }
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Receita receita,@PathVariable long id){
        if(!receitaService.verificarId(id)){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            receitaService.atualizar(receita,id);
            return ResponseEntity.ok(receita);
        }
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Receita> buscarId(@PathVariable long id){
        return receitaService.buscarPorID(id);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(receitaService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }

    }
}
