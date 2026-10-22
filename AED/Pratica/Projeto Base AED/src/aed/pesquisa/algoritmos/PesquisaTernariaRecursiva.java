package aed.pesquisa.algoritmos;

import aed.Comparacao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        // todo Ficha Prática 3 - 3.a)
        return NAO_ENCONTRADO;
    }
}
