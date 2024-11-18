package br.edu.infnet.alexandre.domain.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String descricao;

    private String email;
    private String telefone;
    private String imagem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idInvestidor")
    @JsonManagedReference
    private List<Propriedade> propriedadesInvestidas;




    public Investidor() {

    }

}
