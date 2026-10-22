package aed.ordenacao.algoritmos;

import aed.Comparacao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class BubbleSort<T> extends AlgoritmoOrdenacao<T> {

    public BubbleSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(T... elementos) {
        int indiceUltimaTroca = elementos.length;

        do {
            int indiceTroca = 0;
            for (int i = 1; i < indiceUltimaTroca; i++) {
                if (criterio.comparar(elementos[i], elementos[i - 1]) < 0) {
                    trocar(elementos, i, i - 1);
                    indiceTroca = i;
                }
            }
            indiceUltimaTroca = indiceTroca;
        } while (indiceUltimaTroca > 1);
    }

}
