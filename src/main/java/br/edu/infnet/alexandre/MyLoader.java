package br.edu.infnet.alexandre;

import br.edu.infnet.alexandre.domain.entities.*;
import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.PropriedadeService;
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
    private final PropriedadeService propriedadeService;

    @Autowired
    public MyLoader(InvestidorService investidorService,
                    ProprietarioService proprietarioService,
                    PropriedadeService propriedadeService) {
        this.investidorService = investidorService;
        this.proprietarioService = proprietarioService;
        this.propriedadeService = propriedadeService;
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

                   case "INVESTIDOR":
                        this.AddInvestidor(campo);
                       break;
                   case "PROPRIETARIO":
                        this.AddProprietario(campo);
                       break;
                   default:
                        this.AddRelacionamentoInvestidorPropriedade();
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
        var propriedadeAgricultura = new PropriedadeAgricultura();
        var propriedadeAquicultura = new PropriedadeAquicultura();
        var propriedadePecuaria = new PropriedadePecuaria();

        proprietario.setNome(proprietarioString[1]);

        propriedadeAgricultura.setTipoCultura("Soja");
        propriedadeAgricultura.setNome("Campo Novo do Parecis");
        propriedadeAgricultura.setProprietario(proprietario);
        propriedadeAgricultura.setImagemPropriedade("https://th.bing.com/th/id/R.6276607bcf52913c14e684db6359a005?rik=XyH1FmojTrquow&pid=ImgRaw&r=0");
        propriedadeAgricultura.setDescricao("Fazenda de Soja");
        propriedadeAgricultura.setInvestimentoDeRisco(true);
        propriedadeAgricultura.setCapitalNecessario(1000000);
        propriedadeAgricultura.setLocalizacao("Av. Brasil, 380 - s-22 - Centro" + "Av. Brasil, 380 - s-22 - Centro, Campo Novo do Parecis - MT, 78360-000");

        propriedadeAquicultura.setTipoDePeixe("Tilapia");
        propriedadeAquicultura.setNome("Campo Novo do Parecis - Peixe");
        propriedadeAquicultura.setProprietario(proprietario);
        propriedadeAquicultura.setImagemPropriedade("https://www.embrapa.br/documents/1355746/26319346/aquicultura-JeffersonCHRISTOFOLETTI.jpg/a4afc890-87a0-0072-2d6a-1bf5731a78a7?t=1513340347902");
        propriedadeAquicultura.setDescricao("Fazenda de Peixe");
        propriedadeAquicultura.setInvestimentoDeRisco(false);

        propriedadeAquicultura.setCapitalNecessario(100000);
        propriedadeAquicultura.setLocalizacao("Av. Brasil, 380 - s-22 - Centro" + "Av. Brasil, 380 - s-22 - Centro, Campo Novo do Parecis - MT, 78360-000");


        propriedadePecuaria.setTipoPecuaria("Gado");
        propriedadePecuaria.setNome("Campo Novo do Parecis - GADO");
        propriedadePecuaria.setProprietario(proprietario);
        propriedadePecuaria.setImagemPropriedade("https://th.bing.com/th/id/OIP.x6bVr8f6ynkKh0qjaU3HDgHaDC?rs=1&pid=ImgDetMain");
        propriedadePecuaria.setDescricao("Fazenda de Gado");
        propriedadePecuaria.setInvestimentoDeRisco(true);
        propriedadePecuaria.setCapitalNecessario(200000);
        propriedadePecuaria.setLocalizacao("Av. Brasil, 380 - s-22 - Centro" + "Av. Brasil, 380 - s-22 - Centro, Campo Novo do Parecis - MT, 78360-000");

        proprietario.AddPropriedade(propriedadeAgricultura);
        proprietario.AddPropriedade(propriedadeAquicultura);
        proprietario.AddPropriedade(propriedadePecuaria);
        this.proprietarioService.save(proprietario);
    }

    public  void AddRelacionamentoInvestidorPropriedade() {
        var propriedade = propriedadeService.findById(1)
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrada"));


        var investidor = investidorService.findById(1)
                .orElseThrow(() -> new RuntimeException("Investidor não encontrado"));


        propriedade.AddInvestidor(investidor);

        propriedadeService.save(propriedade);
    }

    public void AddInvestidor(String[] investidorString) {
        var investidor = new Investidor();
        var carteira = new Carteira();

        investidor.setNome(investidorString[1]);
        investidor.setEmail(investidorString[2]);
        investidor.setTelefone(investidorString[3]);
        investidor.setImagem(investidorString[4]);

        carteira.setSaldoCarteira(100000.00);
        carteira.setInvestidor(investidor);

        investidor.setCarteira(carteira);

        this.investidorService.save(investidor);

    }
}
