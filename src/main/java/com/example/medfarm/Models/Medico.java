package com.example.medfarm.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_medico;
    @Column
    private String nome;
    @Column
    private String crm;
    @Column
    private String senha;
    @Column
    private String assinatura;//mudar para alguma coisa relacionada a imagem
}