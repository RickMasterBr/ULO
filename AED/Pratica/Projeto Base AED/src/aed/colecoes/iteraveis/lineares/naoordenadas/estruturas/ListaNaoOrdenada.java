package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class ListaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected NoBase base;
    protected int numeroElementos;

    public ListaNaoOrdenada() {
        new NoBase();
    }

    public ListaNaoOrdenada(ColecaoIteravel<T> colecao) {
        this();
        for (T elem : colecao) {
            new NoComElemento(elem, base);
        }
        numeroElementos = colecao.getNumeroElementos();
    }

    public void transferirParaInicio(ListaNaoOrdenada<T> outra) {
        // todo Ficha Prática 4 - 1
        if (outra == this || outra == null || outra.isVazia()) {
            return;
        }

        // Inicialização de variáveis auxiliares
        No baseDaOutra = outra.base;
        No fimOutra = baseDaOutra.anterior;
        No inicioDesta = base.seguinte;
        No inicioOutra = baseDaOutra.seguinte;

        // ligar o fim da outra ao início desta (this)
        fimOutra.seguinte = inicioDesta;
        inicioDesta.anterior = fimOutra;

        // colocar o início da outra como sendo o início desta
        base.seguinte = inicioOutra;
        inicioOutra.anterior = base;

        // atualizar base da outra
        baseDaOutra.anterior = baseDaOutra.seguinte = baseDaOutra;

        // atualizar número de elementos
        numeroElementos += outra.numeroElementos;
        outra.numeroElementos = 0;
    }

    public ListaNaoOrdenada<T> removerDoFim(int n) {
        // todo Ficha Prática 4 - 2
        ListaNaoOrdenada<T> resultado = new ListaNaoOrdenada<>();
        if (n <= 0 || numeroElementos == 0) {
            return resultado;
        }
        if (n > numeroElementos) {
            n = numeroElementos;
        }

        // Inicialização de variáveis auxiliares
        No fimDesta = numeroElementos == n ? base : getNoPorIndice(numeroElementos - n - 1);
        No inicioResultado = fimDesta.seguinte;
        No fimResultado = base.anterior;
        NoBase baseResultado = resultado.base;

        // atualizar esta
        fimDesta.seguinte = base;
        base.anterior = fimDesta;
        numeroElementos -= n;

        // atualizar resultado
        baseResultado.seguinte = inicioResultado;
        baseResultado.anterior = fimResultado;
        fimResultado.seguinte = inicioResultado.anterior = baseResultado;
        resultado.numeroElementos = n;

        return resultado;
    }


    protected No getNo(T elem) {
        No cor = base.seguinte;
        while (!cor.isElementoIgual(elem)) {
            cor = cor.seguinte;
        }
        return cor;
    }

    protected No getNoPorReferencia(T elem) {
        No cor = base.seguinte;
        while (!cor.isElementoIgualPorReferencia(elem)) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNoPorIndice(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numeroElementos / 2) {
            cor = base.seguinte;

            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = base.anterior;

            while (++indice < numeroElementos) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new NoComElemento(elem, base.seguinte);
    }

    @Override
    public void inserirNoFim(T elem) {
        new NoComElemento(elem, base);
    }

    @Override
    public void inserirPorIndice(int indice, T elem) {
        if (indice == numeroElementos) {
            new NoComElemento(elem, base);
        } else {
            new NoComElemento(elem, getNoPorIndice(indice));
        }
    }

    @Override
    public T removerDoInicio() {
        return base.seguinte.remover();
    }

    @Override
    public T removerDoFim() {
        return base.anterior.remover();
    }

    @Override
    public T remover(T elem) {
        return getNo(elem).remover();
    }

    @Override
    public T removerPorReferencia(T elem) {
        return getNoPorReferencia(elem).remover();
    }

    @Override
    public T removerPorIndice(int indice) {
        return getNoPorIndice(indice).remover();
    }

    @Override
    public T consultarPorIndice(int indice) {
        return getNoPorIndice(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != base;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Não Ordenada = {\n");
        No aux = base.seguinte;
        while (aux != base) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }

    public abstract class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        protected abstract T remover();

        protected abstract boolean isElementoIgual(T elem);

        protected abstract boolean isElementoIgualPorReferencia(T elem);

    }

    public class NoBase extends No {

        protected NoBase() {
            elemento = null;
            seguinte = anterior = base = this;
            numeroElementos = 0;
        }

        protected T remover() {
            return null;
        }

        protected boolean isElementoIgual(T elem) {
            return true;
        }

        protected boolean isElementoIgualPorReferencia(T elem) {
            return true;
        }
    }

    public class NoComElemento extends No {

        protected NoComElemento(T elem, No seg) {
            if (elem == null) {
                throw new IllegalArgumentException();
            }
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            anterior.seguinte = seguinte.anterior = this;
            numeroElementos++;
        }

        protected T remover() {
            seguinte.anterior = anterior;
            anterior.seguinte = seguinte;
            numeroElementos--;
            return elemento;
        }

        protected boolean isElementoIgual(T elem) {
            return elemento.equals(elem);
        }

        protected boolean isElementoIgualPorReferencia(T elem) {
            return elemento == elem;
        }
    }


    public class Iterador implements IteradorIteravelDuplo<T> {
        protected No corrente;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != base;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }
            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente.anterior != base;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }
            corrente = corrente.anterior;
            return corrente.elemento;
        }
    }
}
