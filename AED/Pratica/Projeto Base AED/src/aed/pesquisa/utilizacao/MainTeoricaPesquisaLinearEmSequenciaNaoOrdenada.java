package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaNaoOrdenada;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada {

    public static void main(String[] args) {
        PesquisaLinearEmSequenciaNaoOrdenada<Integer> pesquisaLinear = new PesquisaLinearEmSequenciaNaoOrdenada<>(ComparacaoInteiros.CRITERIO);
        pesquisaLinear.apresentar(20, 1, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.apresentar(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.apresentar(20, 3, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
