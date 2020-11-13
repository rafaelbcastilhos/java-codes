package entities;

public class Gerente extends Funcionario implements Autenticavel {
    private static final int SENHA_GERENTE = 1234;

    @Override
    public double calcularSalario() {
        return super.getSalarioFixo() * 1.20;
    }

    @Override
    public boolean autenticar(int senha){
        return SENHA_GERENTE == senha;
    }

    @Override
    public void imprimePessoa() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Cpf: " + this.getCpf());
        System.out.printf("Salario: %.2f%n", this.calcularSalario());
    }
}