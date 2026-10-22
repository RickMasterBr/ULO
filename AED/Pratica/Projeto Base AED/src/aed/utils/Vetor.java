package aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Vetor {
    public static <T> void apresentar(int limite, T... elementos) {
        String simbolosTerminais;
        int tamanho;

        if (elementos.length == 0) {
            System.out.println("[]");
            return;
        }

        if (elementos.length <= limite) {
            tamanho = elementos.length;
            simbolosTerminais = "]";
        } else {
            tamanho = limite;
            simbolosTerminais = "...";
        }

        System.out.print("[");
        for (int i = 0; i < tamanho - 1; i++) {
            System.out.print(elementos[i] + ", ");
        }
        System.out.println(elementos[tamanho - 1] + simbolosTerminais);
    }
}