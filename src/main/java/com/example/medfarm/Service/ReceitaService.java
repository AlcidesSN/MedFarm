package com.example.medfarm.Service;

import com.example.medfarm.Models.Receita;
import com.example.medfarm.Repository.ReceitaRepositrory;
import com.example.medfarm.Service.Interface.IReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService implements IReceitaService {

    @Autowired
    ReceitaRepositrory receitaRepositrory;

    @Override
    public List<Receita> listar() {
        return receitaRepositrory.findAll();
    }

    @Override
    public Receita criar(Receita receita) {
        return receitaRepositrory.save(receita);
    }

    @Override
    public Receita atualizar(Receita receita, long id) {
        if(verificarId(id)){
            receita.setId_receita(id);
            receitaRepositrory.save(receita);
        }
        return null;
    }

    @Override
    public Optional<Receita> buscarPorID(long id) {
        return receitaRepositrory.findById(id);
    }

    @Override
    public boolean deletar(long id) {
        if (verificarId(id)) {
            receitaRepositrory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarId(long id) {
        return receitaRepositrory.existsById(id);
    }
}
