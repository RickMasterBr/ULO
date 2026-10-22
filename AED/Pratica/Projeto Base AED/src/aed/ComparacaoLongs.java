package aed;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public enum ComparacaoLongs implements Comparacao<Long> {
    CRITERIO;

    @Override
    public int comparar(Long o1, Long o2) {
        return o1.compareTo(o2);
    }

}