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
public class VetorDeStrings {
    public static String[] adicionar(String novaString, String... vetor) {
        String[] novoVetor = new String[vetor.length + 1];
        System.arraycopy(vetor, 0, novoVetor, 0, vetor.length);
        novoVetor[vetor.length] = novaString;
        return novoVetor;
    }
}
