package aed.recursividade.algoritmos;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Fatorial {
    public static long executar(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("fatorial(" + n + ")= argumento inválido : deve ser >= 0");
        }
        return executarRecursivo(n);
    }

    private static long executarRecursivo(int n) {
        if (n < 2) {
            return 1;
        }
        return n * executarRecursivo(n - 1);
    }

    public static void apresentar(int n) {
        try {
            System.out.println("fatorial(" + n + ") = " + executar(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
