package br.edu.infnet.alexandre.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Propriedade")
@Inheritance(strategy = InheritanceType.JOINED)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value =  PropriedadeAgricultura.class, name = "agricola"),
		@JsonSubTypes.Type(value =  PropriedadeAquicultura.class, name = "aquicultura"),
		@JsonSubTypes.Type(value =  PropriedadePecuaria.class, name = "pecuaria")

})
public abstract class Propriedade {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private int id;
	    private String nome;

		@NotBlank(message = "A descrição do produto é obrigatória.")
		@Size(max = 50, message = "A descrição deve ter no máximo 50 caracteres.")
		private  String descricao;

	    private String localizacao;

		@PositiveOrZero
	    private double capitalNecessario;
	    private String imagemPropriedade;
	    private Boolean investimentoDeRisco;


		@ManyToOne
		@JoinColumn(name = "idInvestidor")
		@JsonBackReference
		private Investidor investidor;

		@ManyToOne
		@JoinColumn(name = "idProprietario")
		@JsonBackReference
			private Proprietario proprietario;


	public abstract double calcularRetorno();
}
