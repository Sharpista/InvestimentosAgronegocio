package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "propriedade_id")
    private List<Propriedade> propriedades;


    public void AddPropriedade(Propriedade propriedade){
        if(this.propriedades == null){
            this.propriedades = new ArrayList<>();
        }
        this.propriedades.add(propriedade);
    }


}
