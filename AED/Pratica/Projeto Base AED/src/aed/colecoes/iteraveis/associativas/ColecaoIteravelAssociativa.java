package aed.colecoes.iteraveis.associativas;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.associativas.estruturas.Associacao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoIteravelAssociativa<C, V> extends ColecaoIteravel<Associacao<C, V>> {

    /**
     * Insere uma associação (chave, valor) sem duplicação
     */
    void inserir(C chave, V valor);

    /**
     * Remove a associação correspondente à chave e devolve o valor correspondente
     */
    V remover(C chave);

    /**
     * Devolve o valor correspondente à chave ou null
     */
    V consultar(C chave);

    /**
     * Verifica se chave pertence à tabela
     */
    boolean contem(C chave);

    /**
     * Devolve um iterador das chaves da tabela
     */
    IteradorIteravel<C> iteradorChaves();

    /**
     * Devolve um iterador dos valores da tabela
     */
    IteradorIteravel<V> iteradorValores();

}
