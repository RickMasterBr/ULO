package aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import aed.Comparacao;
import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;

public class ListaOrdenadaOrdemDistinta<T> extends ListaOrdenada<T> {
    private static final long serialVersionUID = 1L;

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp) {
        super(cp);
    }

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp, ColecaoIteravelLinearOrdenada<T> colecao) {
        super(cp, colecao);
    }

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp, ColecaoIteravel<T> colecao) {
        super(cp, colecao);
    }

    @Override
    public void inserir(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException();
        }
        No no = getNoPorOrdem(elem);
        if (no.compararElemento(elem) == 0) {
            throw new IllegalArgumentException("Elemento duplicado!");
        }

        new NoComElemento(elem, no);
        numeroElementos++;
    }

    public T consultarDistinto(T elem) {
        No no = getNoPorOrdem(elem);
        return no.compararElemento(elem) == 0 ? no.elemento : null;
    }
}
