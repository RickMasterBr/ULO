package aed.colecoes.iteraveis;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface IteradorIteravelDuplo<T> extends IteradorIteravel<T> {
    /**
     * Verifica se pode recuar para o elemento anterior.
     *
     * @return true caso ainda existam elementos a percorrer;
     * false caso contrário
     */
    boolean podeRecuar();

    /**
     * Devolve o elemento anterior.
     * Caso não exista lança uma exceção NoSuchElementException
     *
     * @return o elemento anterior
     */
    T recuar();
}
