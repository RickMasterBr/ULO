package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.JogoTorresHanoi;

public class MainPraticaJogoTorresHanoi {

    public static void main(String[] args) {

        // testa com diferente quantidades de discos
        int[] ns = {3, 0, 4, 5};

        // percorre cada elemento do array discos uma vez, alterando a quantidade de discos.
        for (int n : ns) {
            System.out.println("Torres de Hanoi com " + n + " Discos:");
            JogoTorresHanoi.apresentar(n);
            System.out.println();
        }
    }
}
