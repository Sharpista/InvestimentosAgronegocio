package br.edu.infnet.alexandre;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.domain.entities.Proprietario;
import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class MyLoader implements ApplicationRunner {

    private final InvestidorService investidorService;
    private final ProprietarioService proprietarioService;

    @Autowired
    public MyLoader(InvestidorService investidorService, ProprietarioService proprietarioService) {
        this.investidorService = investidorService;
        this.proprietarioService = proprietarioService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try{

            var file = new FileReader("files/loader.txt");
            var buffer = new BufferedReader(file);
            var linha =  buffer.readLine();

            while (linha != null) {
                var campo = linha.split(";");
               switch (campo[0]) {

                   case "PROPRIETARIO":
                        this.AddProprietario(campo);
                       break;
                   case "INVESTIDOR":
                        this.AddInvestidor(campo);
                       break;
                   default:
                       break;

               }

               linha =  buffer.readLine();
            }

            buffer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void AddProprietario(String[] proprietarioString) {

        var proprietario = new Proprietario();

        proprietario.setNome(proprietarioString[1]);

        this.proprietarioService.save(proprietario);

    }

    public void AddInvestidor(String[] investidorString) {
        var investidor = new Investidor();
        investidor.setNome(investidorString[1]);
        investidor.setEmail(investidorString[2]);
        investidor.setTelefone(investidorString[3]);
        investidor.setImagem(investidorString[4]);

        this.investidorService.save(investidor);

    }
}
