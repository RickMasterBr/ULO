package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.JogoTorresHanoi_v3;

public class MainPraticaJogoTorresHanoi_v3 {

    public static void main(String[] args) {

        // testa com diferente quantidades de discos
        int[] ns = {3};

        // percorre cada elemento do array discos uma vez, alterando a quantidade de discos.
        for (int n : ns) {
            System.out.println("Torres de Hanoi com " + n + " Discos:");
            JogoTorresHanoi_v3.apresentar(n);
            System.out.println();
        }
    }
}
