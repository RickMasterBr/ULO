package aed.colecoes.iteraveis.lineares.naoordenadas;


import aed.colecoes.iteraveis.lineares.ColecaoIteravelLinear;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoIteravelLinearNaoOrdenada<T> extends ColecaoIteravelLinear<T> {
    void inserirNoInicio(T elem);

    void inserirNoFim(T elem);

    void inserirPorIndice(int indice, T elem);

    @Override
    default void inserir(T elem) {
        inserirNoFim(elem);
    }

    T removerDoInicio();

    T removerDoFim();
}
