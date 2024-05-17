package com.example.medfarm.Service;

import com.example.medfarm.Models.Farmacia;
import com.example.medfarm.Repository.FarmaciaRepository;
import com.example.medfarm.Service.Interface.IFarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaciaService implements IFarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Override
    public List<Farmacia> listar() {
        return farmaciaRepository.findAll();
    }

    @Override
    public Farmacia criar(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }

    @Override
    public Farmacia atualizar(Farmacia farmacia,long id) {
        if(verificarId(id)){
            farmacia.setId_farmacia(id);
            farmaciaRepository.save(farmacia);
        }
        return null;//mudar retorno
    }

    @Override
    public Optional<Farmacia> buscarPorID(long id) {
        return farmaciaRepository.findById(id);
    }

    @Override
    public boolean deletar(long id) {
        if(verificarId(id)){
            farmaciaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean verificarId(long id) {
        return farmaciaRepository.existsById(id);
    }


}
