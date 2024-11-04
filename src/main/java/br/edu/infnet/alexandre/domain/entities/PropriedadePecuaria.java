package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PropriedadePecuaria")
public class PropriedadePecuaria extends Propriedade {

	private String tipoPecuaria;

	public PropriedadePecuaria() {

	}

	@Override
	public double calcularRetorno() {
		// TODO Auto-generated method stub
		return getCapitalNecessario() * 0.15;
	}

}
