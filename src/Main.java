import br.com.alura.buscaCEP.classes.BuscaApi;
import br.com.alura.buscaCEP.classes.CepGson;
import br.com.alura.buscaCEP.classes.CepJson;
import br.com.alura.buscaCEP.classes.GeraArquivo;
import br.com.alura.buscaCEP.exececoes.ErroDeBadRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        String cepInformado = "";
        List<CepGson> lista = new ArrayList<CepGson>();
        GeraArquivo geraArquivo = new GeraArquivo();
        BuscaApi buscaApi = new BuscaApi();

        while (!cepInformado.equalsIgnoreCase("sair")) {
            System.out.println("  |--------------------------------------------|");
            System.out.println("--|Se desejar encerrar o programa digite 'sair'|--");
            System.out.println("--|     Informe o CEP que deseja buscar:       |--");
            System.out.println("  |--------------------------------------------|");
            cepInformado = leitor.nextLine();

            if (cepInformado.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                CepJson meuCepJson = buscaApi.consultaApi(cepInformado);
                CepGson meuCepGson = new CepGson(meuCepJson);

                System.out.println("Informações sobre o CEP inserido: " + meuCepGson);

                lista.add(meuCepGson);
                geraArquivo.gerarArquivo(lista);

            } catch (ErroDeBadRequest e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERRO, CEP inválido: " + e.getMessage());
            }
        }
        System.out.println("Programa finalizou corretamente.");
    }
}