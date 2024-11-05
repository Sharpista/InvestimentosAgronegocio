package br.edu.infnet.alexandre.service;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import br.edu.infnet.alexandre.infra.clients.ICotacaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestidorService extends GenericService<Investidor, Integer> {

    private final ICotacaoClient cotacaoClient;

    @Autowired
    protected InvestidorService(IGenericRepository<Investidor, Integer> repository, ICotacaoClient cotacaoClient) {
        super(repository);

        this.cotacaoClient = cotacaoClient;
    }

    public  List<Double> getSaldoCarteira(int id){
        var carteira  = this.findById(id).get().getCarteira();
        var listSaldos = new ArrayList<Double>();
        var saldoEmDolares = carteira.getSaldoCarteira() *  getCotacaoDolar();
        var saldoemReais = carteira.getSaldoCarteira();
        var saldoEmEuros = carteira.getSaldoCarteira() * getCotacaoEuro();


        listSaldos.add(saldoEmDolares);
        listSaldos.add(saldoemReais);
        listSaldos.add(saldoEmEuros);

        return listSaldos;
    }

    private Double getCotacaoDolar() {

        var cotacoes = this.cotacaoClient.getCotacoes("USD-BRL");
        System.out.println(cotacoes);

        var cotacaoDolar = cotacoes.getUSDBRL().getHigh();

        return Double.valueOf(cotacaoDolar);
    }

    private Double getCotacaoEuro() {

        var cotacoes = this.cotacaoClient.getCotacoes("EUR-BRL");
        System.out.println(cotacoes);
        var cotacaoEuro = cotacoes.getEURBRL().getHigh();

        return Double.valueOf(cotacaoEuro);
    }


}
