package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import aed.utils.VetorDePoint2D;

 public class MainPraticaPontosMaisProximos {

    public static void main(String[] args) {
        int[] ns = {5, 10, 15};
        for (int n : ns) {
            PontosMaisProximos.apresentar(VetorDePoint2D.criarAleatorio(n));
        }
    }
}