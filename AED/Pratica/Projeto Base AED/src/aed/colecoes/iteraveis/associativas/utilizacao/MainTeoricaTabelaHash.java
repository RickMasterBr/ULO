package aed.colecoes.iteraveis.associativas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.associativas.estruturas.Associacao;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHash;
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
public class MainTeoricaTabelaHash {

    public static void main(String[] args) {
        TabelaHash<Long, Pessoa> pessoasPorBI = new TabelaHash<>(5);

        pessoasPorBI.inserir(3L, new Pessoa(3, "B"));
        pessoasPorBI.inserir(2L, new Pessoa(2, "C"));
        pessoasPorBI.remover(3L);
        System.out.println("\nPessoas por BI\n" + pessoasPorBI);
        pessoasPorBI.inserir(7L, new Pessoa(7, "C"));
        pessoasPorBI.inserir(13L, new Pessoa(13, "A"));

        System.out.println("Pessoas por BI\n" + pessoasPorBI);

        System.out.println("\nConsultar Chave: 2 " + pessoasPorBI.consultar(2L));
        System.out.println("\nConsultar Chave: 12 " + pessoasPorBI.consultar(12L));

        pessoasPorBI.inserir(12L, new Pessoa(12, "F"));
        pessoasPorBI.inserir(23L, new Pessoa(23, "H"));
        System.out.println("\nPessoas por BI\n" + pessoasPorBI);

        pessoasPorBI.remover(2L);
        System.out.println("\nPessoas por BI\n" + pessoasPorBI);

        System.out.println("\nConsultar Chave: 13 " + pessoasPorBI.consultar(13L));

        IteradorIteravel<Associacao<Long, Pessoa>> iterador = pessoasPorBI.iterador();

        System.out.println("\nPessoas com nome < C");
        Associacao<Long, Pessoa> a;
        while (iterador.podeAvancar()) {
            a = iterador.avancar();
            if (a.getValor().getNome().compareTo("C") < 0) {
                System.out.println(iterador.corrente());
            }
        }

        System.out.println("\nPessoas por BI");
        for (Pessoa pessoa : pessoasPorBI.iteradorValores()) {
            System.out.println(pessoa);
        }

        System.out.println("\nBIs");
        for (Long bi : pessoasPorBI.iteradorChaves()) {
            System.out.println(bi);
        }

        iterador.reiniciar();
        System.out.println("\nPrimeira associação");
        System.out.println(iterador.avancar());
    }
}
