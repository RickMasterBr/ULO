package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaOrdenada;
import aed.modelo.pessoas.Pessoa;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorBIAsc;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorNomeAsc;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaListaOrdenada {

    public static void main(String[] args) {
        Pessoa p;
        ListaOrdenada<Pessoa> pessoasPorBI = new ListaOrdenada<>(
                ComparacaoPessoasPorBIAsc.CRITERIO);
        ListaOrdenada<Pessoa> pessoasPorNome = new ListaOrdenada<>(
                ComparacaoPessoasPorNomeAsc.CRITERIO);

        p = new Pessoa(3, "B");
        pessoasPorBI.inserir(p);
        pessoasPorNome.inserir(p);
        p = new Pessoa(7, "C");
        pessoasPorBI.inserir(p);
        pessoasPorNome.inserir(p);
        p = new Pessoa(5, "G");
        pessoasPorBI.inserir(p);
        pessoasPorNome.inserir(p);
        p = new Pessoa(1, "C");
        pessoasPorBI.inserir(p);
        pessoasPorNome.inserir(p);

        System.out.println("Pessoas por BI\n" + pessoasPorBI);
        System.out.println("Pessoas por Nome\n" + pessoasPorNome);

        System.out.println("Pessoas de nome < C");
        for (Pessoa pessoa : pessoasPorBI) {
            if (pessoa.getNome().compareTo("C") < 0) {
                System.out.println(pessoa);
            }
        }

        System.out.println("\nPessoas de nome C");
        IteradorIteravelDuplo<Pessoa> iterador = pessoasPorNome.consultar(new Pessoa(0, "C"));
        while (iterador.podeAvancar()) {
            iterador.avancar();
            System.out.println(iterador.corrente());
        }

        pessoasPorBI.remover(p);

        System.out.println("\nPessoas de nome entre A e E inclusive");
        for (Pessoa pessoa : pessoasPorNome.consultar(new Pessoa(0, "A"), new Pessoa(0, "E"))) {
            System.out.println(pessoa);
        }

        System.out.println("\nPessoas de BI entre 2 e 6 inclusive por ordem inversa");
        iterador = pessoasPorBI.consultar(new Pessoa(2, ""), new Pessoa(6, ""));
        while (iterador.podeRecuar()) {
            System.out.println(iterador.recuar());
        }

        pessoasPorNome.removerPorIndice(1);

        System.out.println("\nPessoas por BI\n" + pessoasPorBI);
        System.out.println("Pessoas por nome\n" + pessoasPorNome);

        System.out.println(pessoasPorBI.consultarPorIndice(1));
    }
}
