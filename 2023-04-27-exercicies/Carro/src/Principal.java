import java.util.Scanner;

public class Principal {
    private final int MAX_CAPACIDADE_CARRO = 5;
    private int indiceControle;
    private Carro[] muitosCarros;
    private Scanner entrada;

    private void menu() {
        System.out.println("1. Criar o carro");
        System.out.println("2. Acelerar o carro");
        System.out.println("3. Reduzir a velocidade");
        System.out.println("4. Exibir os dados do carro");
        System.out.println("5. Sair");
    }

    private String informarModelo() {
        String modelo;
        System.out.println("Informe o modelo do carro: ");
        modelo = entrada.nextLine();

        return modelo;
    }

    private int retornarPosCarro(Carro vetorDeCarros[], int indiceControle, String busca) {
        boolean achouModelo = false;
        int i = 0;

        while (achouModelo != true && i < indiceControle) {
            if (vetorDeCarros[i].pegarModelo().equals(busca)) {
                achouModelo = true;
                return i;
            }
            i++;
        }
        return -1;
    }

    private void tratarOpcao(int opcao) {
        if (opcao == 1) {
            if (indiceControle < MAX_CAPACIDADE_CARRO) {
                Carro umCarro = new Carro(informarModelo());

                muitosCarros[indiceControle] = umCarro;
                indiceControle++;
            } else {
                System.out.println("Nao eh possivel criar mais carros. ");
            }
        } else if (opcao == 2) {
            String modelo = informarModelo();

            try {
                muitosCarros[retornarPosCarro(muitosCarros, indiceControle, modelo)].acelerar();
            } catch (Exception e) {
                System.out.println("Carro nao encontrado.");
            }
        } else if (opcao == 3) {
            String modelo = informarModelo();

            try {
                muitosCarros[retornarPosCarro(muitosCarros, indiceControle, modelo)].reduzir();
            } catch (Exception e) {
                System.out.println("Carro nao encontrado.");
            }
        } else if (opcao == 4) {
            for (int i = 0; i < indiceControle; i++) {
                System.out.println("Carro " + (i + 1));
                System.out.println("Modelo: " + muitosCarros[i].pegarModelo());
                System.out.println("Velocidade: " + muitosCarros[i].pegarVelocidade() + "Km/h\n");
            }
        }
    }

    public Principal() {
        muitosCarros = new Carro[MAX_CAPACIDADE_CARRO];
        entrada = new Scanner(System.in);
        indiceControle = 0;
    }

    public void executar() {
        int opcao;
        do {
            menu();
            opcao = Integer.parseInt(entrada.nextLine());
            tratarOpcao(opcao);
        } while (opcao != 5);
    }
}
