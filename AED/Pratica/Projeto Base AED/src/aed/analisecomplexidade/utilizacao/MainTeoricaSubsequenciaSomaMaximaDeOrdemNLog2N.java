package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaxima;
import aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaximaDeOrdemNLog2N;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaSubsequenciaSomaMaximaDeOrdemNLog2N {

    public static void main(String[] args) {
        SubsequenciaSomaMaxima subsequenciaSomaMaxima = new SubsequenciaSomaMaximaDeOrdemNLog2N();
        subsequenciaSomaMaxima.apresentar(10, -2, 11, -4, 5, 7, -3, 13, 7, -5, 3);
        subsequenciaSomaMaxima.apresentar(10, -1, 4, -10, 3, 5, -9, 6);
    }
}
