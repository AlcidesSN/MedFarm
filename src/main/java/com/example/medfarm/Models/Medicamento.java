package com.example.medfarm.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

import java.util.List;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_medicamento;
    @Column
    private String nome;
    @Column
    private double dosagem;
    @Column
    private double quantidade;
    @Column
    private String viaAdiministracao;
    @Column
    private String observacao;
    @ManyToMany(mappedBy = "medicamentos")
    @JsonIgnoreProperties("medicamentos")
    private List<Receita> receitas;

}

