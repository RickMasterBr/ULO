package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fatorial;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaFatorial {

    public static void main(String[] args) {
        int[] ns = {5, 0, -5, 21};
        for (int n : ns) {
            Fatorial.apresentar(n);
        }

        for (int i = 1; i < 21; i++) {
            Fatorial.apresentar(i);
        }
    }
}
