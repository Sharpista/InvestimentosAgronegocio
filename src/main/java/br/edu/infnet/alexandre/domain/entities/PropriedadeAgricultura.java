package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PropriedadeAgricola")
public class PropriedadeAgricultura extends Propriedade  {

	private String tipoCultura;

	public PropriedadeAgricultura() {

	}

	@Override
	public double calcularRetorno() {
		// TODO Auto-generated method stub
		return getCapitalNecessario() * 0.12;
	}

}
