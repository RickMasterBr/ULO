package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;
import aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaListaNaoOrdenada {


    static void main(String[] args) {
        Pessoa p;
        ListaNaoOrdenada<Pessoa> pessoas = new ListaNaoOrdenada<>();

        p = new Pessoa(3, "B");
        pessoas.inserirNoFim(p);

        p = new Pessoa(1, "C");
        pessoas.inserirNoInicio(p);

        p = new Pessoa(1, "C");
        pessoas.inserir(p);

        p = new Pessoa(2, "A");
        pessoas.inserirPorIndice(2, p);
        System.out.println("Pessoas\n" + pessoas);

        System.out.println("Pessoas de nome < C");

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().compareTo("C") < 0) {
                System.out.println(pessoa);
            }
        }
        System.out.println("\nPessoas");
        IteradorIteravelDuplo<Pessoa> iterador = pessoas.iterador();

        while (iterador.podeAvancar()) {
            iterador.avancar();

            System.out.println(iterador.corrente());
        }
        System.out.println("\nPessoas inverso");
        iterador.reiniciar();

        while (iterador.podeRecuar()) {
            iterador.recuar();

            System.out.println(iterador.corrente());
        }
        pessoas.removerPorReferencia(pessoas.consultarPorIndice(3));
        pessoas.removerPorIndice(1);

        pessoas.removerDoInicio();
        pessoas.removerDoFim();

        System.out.println("Pessoas\n" + pessoas);
    }
}
