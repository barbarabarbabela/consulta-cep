import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o CEP que deseja consultar");
        String cep = input.nextLine();

        ConsultaCEP novaConsulta = new ConsultaCEP();
        try {
            Endereco novoEndereco = novaConsulta.buscaEndereco(cep);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
            if (novoEndereco.cep() == null) {
                System.out.println("Cep inválido. Finalizando a aplicação.");
            } else {
                System.out.println(novoEndereco);
            }


        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}
