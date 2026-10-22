package aed.colecoes.naoiteraveis;

import aed.colecoes.Colecao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoNaoIteravel<T> extends Colecao<T> {
    void inserir(T elem);

    T remover();

    T consultar();

    boolean isVazia();
}
