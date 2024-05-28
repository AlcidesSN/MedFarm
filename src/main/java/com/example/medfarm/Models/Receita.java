package com.example.medfarm.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;
import java.sql.Date;
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

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;


    @ManyToMany
    @JoinTable(
            name = "Medicamento_Receita",
            joinColumns = @JoinColumn(name = "id_receita"),
            inverseJoinColumns = @JoinColumn(name = "id_medicamento")
    )
    @JsonIgnoreProperties("receitas")
    private List<Medicamento> medicamentos;

    @ManyToOne
    private Farmacia farmacia;
    @Column
    private Date data;

}
