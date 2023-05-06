public class Carro {
    private final double MAX_VELOCIDADE = 140.00;
    private String modelo;
    private double velocidade;

    public Carro(String modelo) {
        this.modelo = modelo;
        velocidade = 0;
    }

    public String pegarModelo() {
        return modelo;
    }

    public double pegarVelocidade() {
        return velocidade;
    }

    public void acelerar() {
        if (velocidade < MAX_VELOCIDADE) {
            velocidade += 5;
            System.out.println("Carro acelerado em 5km/h.");
        } else {
            System.out.println("Nao eh possivel acelerar seu carro.");
        }
    }

    public void reduzir() {
        if (velocidade > 0) {
            velocidade -= 5;
            System.out.println("Carro reduzido em 5km/h.");
        } else {
            System.out.println("Nao eh possivel reduzir seu carro.");
        }
    }
}