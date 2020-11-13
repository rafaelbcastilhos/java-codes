package entities;

public class Cliente extends Pessoa implements Autenticavel {
    private static final int SENHA_GERENTE = 123;

    @Override
    public boolean autenticar(int senha){
        return SENHA_GERENTE == senha;
    }

    @Override
    public void imprimePessoa() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Cpf: " + this.getCpf());
    }
}
