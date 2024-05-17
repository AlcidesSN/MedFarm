package com.example.medfarm.Service;

import com.example.medfarm.Models.Medico;
import com.example.medfarm.Repository.MedicoRepository;
import com.example.medfarm.Service.Interface.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements IMedicoService {

   @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico criar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico atualizar(Medico medico, long id) {
        if (verificarId(id)){
            medico.setId_medico(id);
            return medicoRepository.save(medico);
        }
        return null;
    }

    @Override
    public Optional<Medico> buscarPorID(long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public boolean deletar(long id) {
        if (verificarId(id)){
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarId(long id) {
        return medicoRepository.existsById(id);
    }
}
