package application;

import entities.Cliente;
import entities.Diretor;
import entities.Gerente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe nome: ");
        String nome = sc.nextLine();
        System.out.println("Informe cpf: ");
        String cpf = sc.nextLine();

        System.out.println("Informe o tipo de usuario para acessar o sistema:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Diretor");
        System.out.println("3 - Cliente");
        int op = sc.nextInt(), senha, tentativas = 3;
        double salario;

        do {
            switch (op) {
                case 1 -> {
                    Gerente gerente = new Gerente();
                    gerente.setNome(nome);
                    gerente.setCpf(cpf);

                    System.out.println("Informe a senha para se autenticar: ");
                    senha = sc.nextInt();
                    if (gerente.autenticar(senha)) {
                        System.out.println("Gerente autenticado, bem vindo ao sistema!");
                        System.out.println("Informe o salario: ");
                        salario = sc.nextDouble();
                        gerente.setSalarioFixo(salario);
                        System.out.println("--- Gerente ----");
                        gerente.imprimePessoa();
                        return;
                    }
                    else {
                        tentativas--;
                        senhaInvalida(tentativas);
                    }
                }
                case 2 -> {
                    Diretor diretor = new Diretor();
                    diretor.setNome(nome);
                    diretor.setCpf(cpf);

                    System.out.println("Informe a senha para se autenticar: ");
                    senha = sc.nextInt();
                    if (diretor.autenticar(senha)) {
                        System.out.println("Diretor autenticado, bem vindo ao sistema!");
                        System.out.println("Informe o salario: ");
                        salario = sc.nextDouble();
                        diretor.setSalarioFixo(salario);
                        System.out.println("--- Diretor ----");
                        diretor.imprimePessoa();
                        return;
                    }
                    else {
                        tentativas--;
                        senhaInvalida(tentativas);
                    }
                }
                case 3 -> {
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);
                    cliente.setCpf(cpf);

                    System.out.println("Informe a senha para se autenticar: ");
                    senha = sc.nextInt();
                    if (cliente.autenticar(senha)) {
                        System.out.println("Cliente autenticado, bem vindo ao sistema!");
                        System.out.println("--- Cliente ----");
                        cliente.imprimePessoa();
                        return;
                    }
                    else {
                        tentativas--;
                        senhaInvalida(tentativas);
                    }
                }
                default -> {
                    System.out.println("Opcao invalida!");
                    return;
                }
            }
        } while (tentativas > 0);
    }

    private static void senhaInvalida(int tentativas){
        if (tentativas > 0)
            System.out.println("Senha invalida, voce ainda tem " + tentativas + " tentativas!");
        else
            System.out.println("Suas tentativas acabaram. Usuario sem permissao de acesso!");
    }
}
