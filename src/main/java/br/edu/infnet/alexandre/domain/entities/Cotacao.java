package br.edu.infnet.alexandre.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Cotacao{
    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String timestamp;
    private String createDate;
}
