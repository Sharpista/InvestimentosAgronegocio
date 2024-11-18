package br.edu.infnet.alexandre.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PropriedadeAquicultura")
public class PropriedadeAquicultura extends Propriedade {

	private String tipoDePeixe;

	@Override
	public double calcularRetorno() {
		// TODO Auto-generated method stub
		return getCapitalNecessario() * 0.18;
	}
}
