package entities;

public abstract class Funcionario extends Pessoa {
    private double salarioFixo;

    public Funcionario() {}

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public abstract double calcularSalario();
}