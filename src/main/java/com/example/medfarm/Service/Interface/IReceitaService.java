package com.example.medfarm.Service.Interface;

import com.example.medfarm.Models.Receita;

import java.util.List;
import java.util.Optional;

public interface IReceitaService {
    List<Receita> listar();
    Receita criar(Receita receita);
    Receita atualizar(Receita receita, long id);
    Optional<Receita> buscarPorID(long id);
    boolean deletar(long id);
    boolean verificarId(long id);
}
