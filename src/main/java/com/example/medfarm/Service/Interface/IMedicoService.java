package com.example.medfarm.Service.Interface;

import com.example.medfarm.Models.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    Medico buscarPorCrm(String crm);
    List<Medico> listar();
    Medico criar(Medico medico);
    Medico atualizar(Medico medico, long id);
    Optional<Medico> buscarPorID(long id);
    boolean deletar(long id);
    boolean verificarId(long id);
    boolean verificarCrm(String crm);
}
