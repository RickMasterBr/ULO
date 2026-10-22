package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaOrdenada;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaPesquisaLinearEmSequenciaOrdenada {

    public static void main(String[] args) {
        PesquisaLinearEmSequenciaOrdenada<Integer> pesquisaLinear =
                new PesquisaLinearEmSequenciaOrdenada<>(ComparacaoInteiros.CRITERIO);
        pesquisaLinear.apresentar(20, 7, 1, 2, 4, 5, 6, 7, 8, 9);
        pesquisaLinear.apresentar(20, 12, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
