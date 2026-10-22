package aed.colecoes.iteraveis.lineares;

import aed.colecoes.iteraveis.ColecaoIteravel;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoIteravelLinear<T> extends ColecaoIteravel<T> {
    void inserir(T elem);

    T remover(T elem);

    T removerPorReferencia(T elem);

    T removerPorIndice(int indice);

    T consultarPorIndice(int indice);

    boolean contem(T elem);

    boolean contemReferencia(T elem);
}
