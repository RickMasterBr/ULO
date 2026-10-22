package aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import aed.Comparacao;
import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;
import aed.colecoes.naoiteraveis.estruturas.Fila;
import aed.colecoes.naoiteraveis.estruturas.Pilha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ArvoreBinaria<T> implements ColecaoIteravelLinearOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected NoBase base;
    protected Comparacao<T> criterio;
    protected int numeroElementos;

    public ArvoreBinaria(Comparacao<T> cp) {
        criterio = cp;
        new NoBase();
    }

    public ArvoreBinaria(Comparacao<T> cp, ColecaoIteravelLinearOrdenada<T> colecao) {
        this(cp);
        ArrayList<T> elementos = new ArrayList<>();
        for (T elemento : colecao) {
            elementos.add(elemento);
        }

        Collections.shuffle(elementos);

        for (T elemento : elementos) {
            inserir(elemento);
        }
    }

    public ArvoreBinaria(Comparacao<T> cp, ColecaoIteravel<T> colecao) {
        this(cp);

        for (T elemento : colecao) {
            inserir(elemento);
        }
    }

    @Override
    public void inserir(T elem) {
        new NoComElemento(elem);
    }


    @Override
    public T remover(T elem) {
        No pai = base;
        No filho = pai.esquerda; // Raiz
        int cp;

        while (filho != null) {
            cp = filho.compararElemento(elem);
            if (cp == 0) {
                if (elem.equals(filho.elemento)) { // O elemento a remover está no nó filho
                    return filho.remover(pai);
                }

                // Só pode estar à direita - elementos de igual critério
                pai = filho;
                filho = filho.direita;
            } else {
                pai = filho;
                filho = cp > 0 ? filho.esquerda : filho.direita;
            }
        }

        // Não encontrou o elemento
        return null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No pai = base;
        No filho = pai.esquerda; // Raíz
        int cp;

        while (filho != null) {
            cp = filho.compararElemento(elem);
            if (cp == 0) {
                if (elem == filho.elemento) { // O elemento a remover está no nó filho
                    return filho.remover(pai);
                }

                // Só pode estar à direita - elementos de igual critério
                pai = filho;
                filho = filho.direita;
            } else {
                pai = filho;
                filho = cp > 0 ? filho.esquerda : filho.direita;
            }
        }

        // Não encontrou o elemento
        return null;
    }

    @Override
    public T removerPorIndice(int indice) {
        return removerPorReferencia(consultarPorIndice(indice));
    }

    @Override
    public T consultarPorIndice(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IllegalArgumentException();
        }

        IteradorEmOrdemCompleto iteradorEmOrdem = new IteradorEmOrdemCompleto();
        do {
            iteradorEmOrdem.avancar();
        } while (iteradorEmOrdem.podeAvancar() && indice-- > 0);

        return iteradorEmOrdem.corrente();
    }

    @Override
    public IteradorIteravel<T> consultar(T elemInicial, T elemFinal) {
        return new IteradorEmOrdemNumIntervalo(elemInicial, elemFinal);
    }

    @Override
    public boolean contemOrdem(T elem) {
        return consultar(elem).podeAvancar();
    }

    @Override
    public boolean contem(T elem) {
        IteradorIteravel<T> iterador = consultar(elem);

        while (iterador.podeAvancar()) {
            if (iterador.avancar().equals(elem)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contemReferencia(T elem) {
        IteradorIteravel<T> iterador = consultar(elem);

        while (iterador.podeAvancar()) {
            if (iterador.avancar() == elem) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravel<T> iterador() {
        return iteradorEmOrdem();
    }

    public IteradorIteravel<T> iteradorPreOrdem() {
        return new IteradorPreOrdem();
    }

    public IteradorIteravel<T> iteradorEmOrdem() {
        return new IteradorEmOrdemCompleto();
    }

    public IteradorIteravel<T> iteradorPosOrdem() {
        return new IteradorPosOrdem();
    }

    public IteradorIteravel<T> iteradorPorNiveis() {
        return new IteradorPorNiveis();
    }

    @Override
    public Comparacao<T> getComparador() {
        return criterio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Árvore Binária = {\n");
        for (T elem : this) {
            sb.append(elem).append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }


    protected abstract class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No esquerda;
        protected No direita;

        protected abstract T remover(No pai);

        protected abstract int compararElemento(T elem);
    }

    protected class NoBase extends No {
        protected NoBase() {
            elemento = null;
            esquerda = direita = null;
            base = this;
            numeroElementos = 0;
        }

        protected T remover(No pai) {
            return null;
        }

        protected int compararElemento(T elem) {
            return 1;
        }
    }

    protected class NoComElemento extends No {
        public NoComElemento(T elem) {
            if (elem == null) {
                throw new IllegalArgumentException();
            }

            elemento = elem;
            direita = esquerda = null;

            No pai = base;
            No filho = null;
            int cp;

            do {
                cp = pai.compararElemento(elem);
                if (cp > 0) {
                    filho = pai.esquerda;
                    if (filho == null) {
                        pai.esquerda = this;
                        break;
                    }
                } else {  // Elementos de critério maior ou *igual* são inseridos à direita
                    filho = pai.direita;
                    if (filho == null) {
                        pai.direita = this;
                        break;
                    }
                }
                pai = filho;
            } while (true);
            numeroElementos++;
        }

        protected T remover(No pai) {
            numeroElementos--;
            No novoFilho;
            if (direita != null) {
                if (esquerda != null) { // this tem nó esquerdo e nó direito
                    T elementoRemovido = elemento;
                    No paiMenorElemento = this;
                    No menorElemento = paiMenorElemento.direita;
                    if (menorElemento.esquerda == null) { // this à direita do paiMenorElemento
                        paiMenorElemento.direita = menorElemento.direita;
                    }
                    else {
                        do {
                            paiMenorElemento = menorElemento;
                            menorElemento = menorElemento.esquerda;
                        } while (menorElemento.esquerda != null);
                        paiMenorElemento.esquerda = menorElemento.direita; // this está à esquerda do paiMenorElemento
                    }
                    elemento = menorElemento.elemento;
                    return elementoRemovido;
                }
                novoFilho = direita; // this só tem nó direito
            } else {
                novoFilho = esquerda; // this só tem nó esquerdo ou nenhum
            }
            if (pai.compararElemento(elemento) > 0) {
                pai.esquerda = novoFilho;
            } else {
                pai.direita = novoFilho;
            }
            return elemento;
        }

        protected int compararElemento(T elem) {
            return criterio.comparar(elemento, elem);
        }
    }

    protected abstract class Iterador implements IteradorIteravel<T> {
        protected No corrente;

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
    }


    protected abstract class IteradorEmProfundidade extends Iterador {

        protected Pilha<No> pilha;

        @Override
        public void reiniciar() {
            super.reiniciar();
            pilha = new Pilha<>();
        }

        @Override
        public boolean podeAvancar() {
            return !pilha.isVazia();
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente = pilha.remover();

            atualizarPilha();

            return corrente.elemento;
        }

        protected abstract void atualizarPilha();

    }


    protected class IteradorPreOrdem extends IteradorEmProfundidade {

        public IteradorPreOrdem() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            super.reiniciar();

            if (base.esquerda != null) {
                pilha.inserir(base.esquerda);
            }
        }

        @Override
        protected void atualizarPilha() {
            if (corrente.direita != null) {
                pilha.inserir(corrente.direita);
            }

            if (corrente.esquerda != null) {
                pilha.inserir(corrente.esquerda);
            }
        }
    }


    protected abstract class IteradorEmOrdem extends IteradorEmProfundidade {
        @Override
        protected void atualizarPilha() {
            if (corrente.direita != null) {
                inserirEsquerda(corrente.direita);
            }
        }

        protected abstract void inserirEsquerda(No no);
    }


    protected class IteradorEmOrdemCompleto extends IteradorEmOrdem {

        public IteradorEmOrdemCompleto() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            super.reiniciar();

            if (base.esquerda != null) {
                inserirEsquerda(base.esquerda);
            }
        }

        protected void inserirEsquerda(No no) {
            do {
                pilha.inserir(no);
                no = no.esquerda;
            } while (no != null);
        }

    }

    protected class IteradorEmOrdemNumIntervalo extends IteradorEmOrdem {
        protected T elementoInicial;
        protected T elementoFinal;

        protected IteradorEmOrdemNumIntervalo(T elemInicial, T elemFinal) {
            this.elementoInicial = elemInicial;
            this.elementoFinal = elemFinal;
            reiniciar();
        }

        @Override
        public void reiniciar() {
            super.reiniciar();

            // desprezar os elementos inferiores ao elementoInicial
            No primeiro = base.esquerda;
            int cp;
            do {
                if (primeiro == null) {
                    return;
                }
                cp = primeiro.compararElemento(elementoInicial);
                if (cp >= 0) {
                    inserirEsquerda(primeiro);
                    return;
                }

                primeiro = primeiro.direita;
            } while (true);

        }

        protected void inserirEsquerda(No no) {
            do {
                if (no.compararElemento(elementoFinal) <= 0) {
                    if (no.compararElemento(elementoInicial) < 0) {
                        break;
                    }
                    pilha.inserir(no);
                }

                if (no.esquerda == null) {
                    break;
                }

                no = no.esquerda;
            } while (true);
        }

    }

    protected class IteradorPosOrdem extends IteradorEmProfundidade {

        protected IteradorPosOrdem() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            super.reiniciar();

            if (base.esquerda != null) {
                inserirEsquerdaDireita(base.esquerda);
            }
        }

        @Override
        protected void atualizarPilha() {
            if (!pilha.isVazia()) {
                No top = pilha.consultar();
                // Se acabei de tirar o nó da esquerda põe o da direita
                if (top.esquerda == corrente && top.direita != null) {
                    inserirEsquerdaDireita(top.direita);
                }
            }
        }

        private void inserirEsquerdaDireita(No no) {
            do {
                pilha.inserir(no);
                no = (no.esquerda != null) ? no.esquerda : no.direita;
            } while (no != null);
        }
    }

    protected class IteradorPorNiveis extends Iterador {

        protected Fila<No> fila;

        protected IteradorPorNiveis() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            super.reiniciar();
            fila = new Fila<>();
            if (base.esquerda != null) {
                fila.inserir(base.esquerda);
            }
        }

        @Override
        public boolean podeAvancar() {
            return !fila.isVazia();
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }
            corrente = fila.remover();

            if (corrente.esquerda != null) {
                fila.inserir(corrente.esquerda);
            }

            if (corrente.direita != null) {
                fila.inserir(corrente.direita);
            }

            return corrente.elemento;
        }
    }
}
