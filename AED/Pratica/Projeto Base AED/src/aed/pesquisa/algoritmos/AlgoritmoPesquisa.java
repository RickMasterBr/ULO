package aed.pesquisa.algoritmos;

import aed.Comparacao;
import aed.utils.Vetor;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public abstract class AlgoritmoPesquisa<T> {

    public static final int NAO_ENCONTRADO = -1;

    protected final Comparacao<T> criterio;

    public AlgoritmoPesquisa(Comparacao<T> criterio) {
        this.criterio = criterio;
    }

    public abstract int pesquisar(T elemento, T... elementos);

    public void apresentar(int numeroElementosApresentar, T elemento, T... elementos) {
        int indice = pesquisar(elemento, elementos);
        System.out.print(elemento + " pesquisado por " + getClass().getSimpleName()
                + (indice != NAO_ENCONTRADO ? (" encontrado no índice " + indice) : " não encontrado") + " : ");
        Vetor.apresentar(numeroElementosApresentar, elementos);
    }
}
