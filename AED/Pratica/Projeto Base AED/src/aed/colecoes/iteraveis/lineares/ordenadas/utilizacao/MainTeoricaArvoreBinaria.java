package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ArvoreBinaria;
import aed.modelo.pessoas.Pessoa;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorNomeAsc;

public class MainTeoricaArvoreBinaria {

    public static void main(String[] args) {
        ArvoreBinaria<Pessoa> pessoasPorNome = new ArvoreBinaria<>(ComparacaoPessoasPorNomeAsc.CRITERIO);

        Pessoa[] pessoas = {
                new Pessoa(3, "P"),
                new Pessoa(8, "F"),
                new Pessoa(2, "M"),
                new Pessoa(1, "T"),
                new Pessoa(7, "A"),
                new Pessoa(4, "R"),
                new Pessoa(10, "Q"),
                new Pessoa(5, "I"),
                new Pessoa(13, "X"),
                new Pessoa(11, "Z")
        };

        // Remoção de pessoa que não existe
        pessoasPorNome.remover(new Pessoa(6, "D"));

        for (Pessoa pessoa : pessoas) {
            pessoasPorNome.inserir(pessoa);
        }

        System.out.println("\nTodas as pessoas em pré-ordem:");
        for (Pessoa pessoa : pessoasPorNome.iteradorPreOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em ordem:");
        for (Pessoa pessoa : pessoasPorNome.iteradorEmOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em ordem com nome entre B e R:");
        for (Pessoa pessoa : pessoasPorNome.consultar(new Pessoa(0, "B"), new Pessoa(0, "R"))) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em pós-ordem:");
        for (Pessoa pessoa : pessoasPorNome.iteradorPosOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas por níveis:");
        for (Pessoa pessoa : pessoasPorNome.iteradorPorNiveis()) {
            System.out.println(pessoa);
        }


        System.out.println("\nPessoa na 4ª posição: " + pessoasPorNome.consultarPorIndice(3));

        pessoasPorNome.remover(new Pessoa(7, "A")); // Caso sem filhos
        pessoasPorNome.remover(new Pessoa(2, "M")); // Caso apenas com filho à esquerda
        pessoasPorNome.remover(new Pessoa(8, "F")); // Caso apenas com filho à direita
        pessoasPorNome.remover(new Pessoa(3, "P")); // Caso com dois filhos em que paiMenorElemento != filho
        pessoasPorNome.removerPorReferencia(pessoas[3]);     // Caso com dois filhos em que paiMenorElemento == filho

        System.out.println("\nTodas as pessoas em ordem:");
        for (Pessoa pessoa : pessoasPorNome.iteradorEmOrdem()) {
            System.out.println(pessoa);
        }
    }
}
