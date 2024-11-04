package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PropriedadeAquicultura")
public class PropriedadeAquicultura extends Propriedade {

	private String tipoDePeixe;


	public PropriedadeAquicultura() {

	}
	@Override
	public double calcularRetorno() {
		// TODO Auto-generated method stub
		return getCapitalNecessario() * 0.18;
	}
}
