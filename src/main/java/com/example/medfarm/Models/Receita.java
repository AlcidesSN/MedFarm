package com.example.medfarm.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_receita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;


    @ManyToMany
    @JoinTable(
            name = "Medicamento_Receita",
            joinColumns = @JoinColumn(name = "id_medicamento"),
            inverseJoinColumns = @JoinColumn(name = "id_receita")
    )
    private List<Medicamento> medicamentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_farmacia")
    private Farmacia farmacia;
    @Column
    private Date data;
}
