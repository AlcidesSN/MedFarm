package com.example.medfarm.Service.Interface;

import com.example.medfarm.Models.Medicamento;

import java.util.List;
import java.util.Optional;

public interface IMedicamentoService {
    List<Medicamento> listar();
    Medicamento criar(Medicamento medicamento);
    Medicamento atualizar(Medicamento medicamento, long id);
    Optional<Medicamento> buscarPorID(long id);
    boolean deletar(long id);
    boolean verificarId(long id);

}
