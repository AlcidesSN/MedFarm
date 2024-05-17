package com.example.medfarm.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_paciente;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private Date birth;
    @Column
    private String planoDeSaude;
}
