package aed.colecoes.iteraveis.lineares.ordenadas;

import aed.Comparacao;
import aed.colecoes.iteraveis.IteradorIteravel;
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
public interface ColecaoIteravelLinearOrdenada<T> extends ColecaoIteravelLinear<T> {

    Comparacao<T> getComparador();

    // Devolve um iterador de todos os elementos que tenham a mesma ordem que elem
    default IteradorIteravel<T> consultar(T elem) {
        return consultar(elem, elem);
    }

    // Devolve um iterador dos elementos de ordem
    // superior ou igual à ordem de elemInicial e
    // menor ou igual à ordem de elemFinal
    IteradorIteravel<T> consultar(T elemInicial, T elemFinal);

    boolean contemOrdem(T elem);
}
