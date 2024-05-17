package com.example.medfarm.Service;

import com.example.medfarm.Models.Medicamento;
import com.example.medfarm.Repository.MedicamentoRepository;
import com.example.medfarm.Service.Interface.IMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService implements IMedicamentoService {

   @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listar() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento criar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public Medicamento atualizar(Medicamento medicamento, long id) {
        if (verificarId(id)){
            medicamento.setId_medicamento(id);
            return medicamentoRepository.save(medicamento);
        }
        return null;
    }

    @Override
    public Optional<Medicamento> buscarPorID(long id) {
        return medicamentoRepository.findById(id);
    }

    @Override
    public boolean deletar(long id) {
        if (verificarId(id)) {
            medicamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarId(long id) {
        return medicamentoRepository.existsById(id);

    }
}
