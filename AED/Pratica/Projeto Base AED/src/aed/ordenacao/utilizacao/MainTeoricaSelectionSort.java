package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.SelectionSort;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaSelectionSort {

    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort = new SelectionSort<>(ComparacaoInteiros.CRITERIO);
        selectionSort.apresentar(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}
