package entities;

public class Diretor extends Funcionario implements Autenticavel {
    private static final int SENHA_DIRETOR = 12345;

    @Override
    public double calcularSalario() {
        return super.getSalarioFixo() * 1.40;
    }

    @Override
    public boolean autenticar(int senha){
        return SENHA_DIRETOR == senha;
    }

    @Override
    public void imprimePessoa() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Cpf: " + this.getCpf());
        System.out.println("Salario: " + this.calcularSalario());
    }
}