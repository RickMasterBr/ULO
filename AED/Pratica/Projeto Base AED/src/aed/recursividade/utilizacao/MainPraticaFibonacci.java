package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fibonacci;


public class MainPraticaFibonacci {

    // metodo main é onde o programa roda
    public static void main(String[] args) {

        // Um array com alguns valores de teste, incluindo um negativo
        int[] ns = {5, 0, -10, 40, 45};

        // "for each" - percorre cada posição do array "ns" de cada vez guardando o valor atual na variavel n.
        for (int n : ns) {

            //chama o metodo apresentar que calcula e imprime o resultado
            Fibonacci.apresentar(n);
        }

        // um segundo teste, com um For tradicional, que começa em i = 5,
        // repete enquanto i for menor que 31, e aumenta 5 a cada volta. (Testa 5, 10, 15...)
        for (int i = 5; i < 31; i += 5) {
            Fibonacci.apresentar(i);
        }
    }
}
