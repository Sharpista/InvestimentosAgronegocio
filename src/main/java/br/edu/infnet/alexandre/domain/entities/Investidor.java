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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    @ManyToOne
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedadesInvestidas;


    public Investidor() {

    }

    public void addCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

}
