package br.edu.infnet.alexandre.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

		@OneToMany(mappedBy = "propriedadesInvestidas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private List<Investidor> investidores;

		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "proprietario_id")
		private Proprietario proprietario;



	public Propriedade() {
		this.investidores = new ArrayList<>();
	}

	public void AddInvestidor(Investidor investidor) {
		if (this.investidores == null) {
			this.investidores = new ArrayList<>();
		}
		this.investidores.add(investidor);
		investidor.setPropriedadesInvestidas(this);
	}
	public abstract double calcularRetorno();
}
