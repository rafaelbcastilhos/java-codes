package entities;

import java.util.ArrayList;

public class Agenda {
    ArrayList<Contato> contatos;

    public Agenda() {}

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void consultarContato(String nome) throws ContatoNaoExisteException {
        int aux = 0;

        for(Contato contato : this.getContatos()){
            if(contato.getNome().equals(nome)) {
                contato.imprimirContato();
                aux = 1;
            }
        }

        if(aux == 0)
            throw new ContatoNaoExisteException(nome);
    }

    public void cadastrarContato(String nome, String telefone, String email){
        if(this.getContatos() == null)
            contatos = new ArrayList<>();

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        contatos.add(contato);
    }
}
