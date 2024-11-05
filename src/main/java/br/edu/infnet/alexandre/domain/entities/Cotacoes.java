package br.edu.infnet.alexandre.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotacoes {

    @JsonProperty("USDBRL")
    private Cotacao USDBRL;

    @JsonProperty("EURBRL")
    private Cotacao EURBRL;
}

