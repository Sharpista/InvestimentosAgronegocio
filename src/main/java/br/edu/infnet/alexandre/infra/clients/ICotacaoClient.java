package br.edu.infnet.alexandre.infra.clients;

import br.edu.infnet.alexandre.domain.entities.Cotacoes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cotacoes", url = "https://economia.awesomeapi.com.br/json")
public interface ICotacaoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/last/{moeda}", produces = "application/json")
    Cotacoes getCotacoes(@PathVariable String moeda);
}
