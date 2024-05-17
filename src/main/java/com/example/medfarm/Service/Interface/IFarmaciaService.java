package com.example.medfarm.Service.Interface;

import com.example.medfarm.Models.Farmacia;

import java.util.List;
import java.util.Optional;

public interface IFarmaciaService {
    public List<Farmacia> listar();
    public Farmacia criar(Farmacia farmacia);
    public Farmacia atualizar( Farmacia farmacia,long id);
    public Optional<Farmacia> buscarPorID(long id);
    public boolean deletar(long id);
    public boolean verificarId(long id);

}
