package aed.colecoes.naoiteraveis.utilizacao;

import aed.colecoes.naoiteraveis.estruturas.Pilha;
import aed.modelo.pessoas.Pessoa;

public class MainTeoricaPilha {

    public static void main(String[] args) {
        Pilha<Pessoa> pessoas = new Pilha<>();

        pessoas.inserir(new Pessoa(3, "B"));
        pessoas.inserir(new Pessoa(1, "C"));
        pessoas.inserir(new Pessoa(2, "A"));

        System.out.println("Pessoas\n" + pessoas);

        pessoas.remover();
        System.out.println("Pessoas\n" + pessoas);

        System.out.println(pessoas.consultar());

        pessoas.remover();
        System.out.println("Pessoas\n" + pessoas);
    }
}
