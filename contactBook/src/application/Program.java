package application;

import entities.Agenda;
import entities.ContatoNaoExisteException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, telefone, email;
        int op;

        Agenda agenda = new Agenda();
        do{
            menu();
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    try {
                        if(agenda.getContatos() == null)
                            throw new NullPointerException("Nao existem contatos...");

                        System.out.println("Digite nome a ser consultado: ");
                        nome = sc.next();

                        agenda.consultarContato(nome);
                    } catch (NullPointerException | ContatoNaoExisteException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Digite nome: ");
                    nome = sc.next();
                    System.out.println("Digite telefone: ");
                    telefone = sc.next();
                    System.out.println("Digite email: ");
                    email = sc.next();

                    agenda.cadastrarContato(nome, telefone, email);
                }
                case 3 -> System.out.println("Finalizando...");
            }
        }while (op != 3);
    }

    private static void menu(){
        System.out.println("--- Agenda ---");
        System.out.println("1 - Consultar contato na agenda");
        System.out.println("2 - Adicionar novo contato");
        System.out.println("3 - Finalizar");
    }
}
