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
public class NumerosQuadradosPitagoras {
    public static long executar(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("q(" + n + ")= argumento inválido : deve ser >= 1");
        }
        return executarRecursivo(n);
    }

    private static long executarRecursivo(int n) {
        if (n == 1) {
            return 1;
        }
        return executarRecursivo(n - 1) + 2 * n - 1;
    }

    public static void apresentar(int n) {
        try {
            System.out.println("q(" + n + ") = " + executar(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
