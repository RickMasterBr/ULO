/* package aed.ordenacao.algoritmos;

import aed.Comparacao;

public class InsertionSortAula<T> extends AlgoritmoOrdenacao<T> {

    public InsertionSortAula(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(T... elementos) {

        for (int i = 1; i < elementos.length; i++) {

            T aux = elementos[i];
            int j = i -1;

            while ( j >= 0 && criterio.comparar(aux, elementos[j]) < 0) {

                    elementos[j + 1] = elementos[j];
                    j--;
            }

            elementos[j+1] = aux;
        }

        }

    }
}
*/