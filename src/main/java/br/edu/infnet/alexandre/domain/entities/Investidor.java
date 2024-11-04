package br.edu.infnet.alexandre.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "Investidor")
public class Investidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
    private String email;
    private String telefone;
    private String imagem;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Propriedade> propriedadesInvestidas;


    public Investidor() {

    }
    public void adicionarPropriedadeInvestida(Propriedade propriedade) {
        propriedadesInvestidas.add(propriedade);
    }

}
