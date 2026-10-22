package aed.ordenacao.algoritmos;

public class RichardSort {

    public static void main() {

        // Implementar insertion Sort -> dividir a sequencia em Parte Esquerda (J) e direita (I),
        // ordenada e desordenada, respectivamente

        int[] vetor = {3,1,2,5,4}; // desordenado
        int aux;

        System.out.println("\n\nVetor desordenado: ");

        for (int i = 0; i < vetor.length; i ++){
            System.out.println(vetor[i]);
        }

        for (int i = 1; i < vetor.length; i++){ // seleciona um elemento da parte a ordenar

            aux = vetor[i];
            int j = i - 1; // ultimo elemento da parte ordenada

            while (j >= 0 && vetor[j] > aux){ // continua enquanto houver elementos à esquerda e J for superior ao selecionado.

                vetor[j+1] = vetor[j];
                j--;
            }

            vetor[j + 1] = aux;
        }

        // apresentar

        System.out.println("\n\nVetor ordenado: ");

        for (int i = 0; i < vetor.length; i ++){
            System.out.println(vetor[i]);
        }
    }
}

