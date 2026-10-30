package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.QuickSort;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import aed.utils.VetorDeInteiros;

import java.util.Random;

public class MainPraticaPesquisaTernaria {

    public static void main(String[] args) {
        Random random = new Random();

        AlgoritmoPesquisa<Integer> pesquisaTernariaRecursiva = new PesquisaTernariaRecursiva<>(ComparacaoInteiros.CRITERIO);
        AlgoritmoPesquisa<Integer> pesquisaTernariaIterativa = new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO);

        pesquisaTernariaRecursiva.apresentar(20, -5, -12, -8, -5, 0, 3, 6);

        Integer[] elementos = VetorDeInteiros.criarAleatorioInteger(10, -10, 10, false);
        new QuickSort<>(ComparacaoInteiros.CRITERIO).apresentar(20, elementos);

        int elemento = random.nextInt(21) - 10;
        pesquisaTernariaRecursiva.apresentar(20, elemento, elementos);
        pesquisaTernariaIterativa.apresentar(20, elemento, elementos);
    }
}
