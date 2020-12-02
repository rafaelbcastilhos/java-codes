package entities;

public class ContatoNaoExisteException extends Exception {
    public ContatoNaoExisteException(String nome){
        super("O contato " + nome + " não está cadastrado na agenda");
    }
}
