package com.example.medfarm.Repository;

import com.example.medfarm.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Medico findByCrm(String crm);
    boolean existsByCrm(String crm);
}
