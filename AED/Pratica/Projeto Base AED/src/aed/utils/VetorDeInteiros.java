package aed.utils;

import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class VetorDeInteiros {
    public static Integer[] criarAleatorioInteger(int tamanho, int minimo, int maximo, boolean seedAleatoria) {
        Integer[] resultado = new Integer[tamanho];
        Random rnd = seedAleatoria ? new Random() : new Random(1);
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = rnd.nextInt(maximo - minimo + 1) + minimo;
        }
        return resultado;
    }

    public static int[] criarAleatorioInt(int tamanho, int minimo, int maximo, boolean seedAleatoria) {
        int[] resultado = new int[tamanho];
        Random rnd = seedAleatoria ? new Random() : new Random(1);
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = rnd.nextInt(maximo - minimo + 1) + minimo;
        }
        return resultado;
    }

    public static int[] criarAleatorioInt(int tamanho, boolean seedAleatoria) {
        int[] resultado = new int[tamanho];
        Random rnd = seedAleatoria ? new Random() : new Random(1);
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = rnd.nextInt();
        }
        return resultado;
    }

    public static long maximo(long... valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Pelo menos um valor");
        }
        long maximo = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (maximo < valores[i]) {
                maximo = valores[i];
            }
        }
        return maximo;
    }

    public static void apresentar(int limite, int... elementos) {
        int tamanho = elementos.length < limite ? elementos.length : limite;

        System.out.print("[");
        for (int i = 0; i < tamanho - 1; i++) {
            System.out.print(elementos[i] + ", ");
        }
        System.out.print(elementos[tamanho - 1]);
        if (limite < elementos.length) {
            System.out.println("...");
        } else {
            System.out.println("]");
        }
    }


}
