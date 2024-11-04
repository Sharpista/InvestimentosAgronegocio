package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Proprietario")
public class Proprietario {

    public Proprietario(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nome;
    @OneToMany
    private List<Propriedade> propriedades;


}
