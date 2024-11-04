package br.edu.infnet.alexandre.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Propriedade")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Propriedade {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private int id;
	    private String nome;
		private  String descricao;
	    private String localizacao;
	    private double capitalNecessario;
	    private String imagemPropriedade;
	    private Boolean investimentoDeRisco;
		@ManyToMany
		private List<Investidor> investidores;
		@ManyToOne
		private Proprietario proprietario;



	public Propriedade() {

	}

	public abstract double calcularRetorno();
}
