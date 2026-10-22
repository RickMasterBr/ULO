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
public class PesquisaLinearEmSequenciaNaoOrdenada<T> extends AlgoritmoPesquisa<T> {

    public PesquisaLinearEmSequenciaNaoOrdenada(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(T elemento, T... elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (criterio.comparar(elemento, elementos[i]) == 0) {
                return i;
            }
        }
        return NAO_ENCONTRADO;
    }
}
