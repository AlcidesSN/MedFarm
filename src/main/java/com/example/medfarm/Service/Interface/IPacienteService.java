package com.example.medfarm.Service.Interface;

import com.example.medfarm.Models.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> listar();
    Paciente criar(Paciente paciente);
    Paciente atualizar(Paciente paciente, long id);
    Optional<Paciente> buscarPorID(long id);
    boolean deletar(long id);
    boolean verificarId(long id);
}
