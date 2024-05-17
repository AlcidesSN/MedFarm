package com.example.medfarm.Repository;

import com.example.medfarm.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
