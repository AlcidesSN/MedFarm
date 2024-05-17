package com.example.medfarm.Service;

import com.example.medfarm.Models.Paciente;
import com.example.medfarm.Repository.PacienteRepository;
import com.example.medfarm.Service.Interface.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente criar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizar(Paciente paciente, long id) {
        if(verificarId(id)){
            paciente.setId_paciente(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public Optional<Paciente> buscarPorID(long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public boolean deletar(long id) {
        if(verificarId(id)){
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarId(long id) {
        return pacienteRepository.existsById(id);
    }
}
