package aed.colecoes.naoiteraveis.estruturas;

import aed.colecoes.naoiteraveis.ColecaoNaoIteravel;

import java.io.Serializable;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Pilha<T> implements ColecaoNaoIteravel<T> {
    private static final long serialVersionUID = 1L;

    protected No topo;

    public Pilha() {
        topo = null;
    }

    @Override
    public void inserir(T elem) {
        new No(elem);
    }

    @Override
    public T remover() {
        if (isVazia()) {
            return null;
        }

        T aux = topo.elemento;
        topo = topo.seguinte;
        return aux;
    }

    @Override
    public T consultar() {
        return isVazia() ? null : topo.elemento;
    }

    @Override
    public boolean isVazia() {
        return topo == null;
    }

    public void limpar() {
        topo = null;
    }

    /**
     * Lista todos os elementos da pilha desde o seu topo.
     */
    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder();
        lista.append("Pilha = {\n");
        No aux = topo;
        while (aux != null) {
            lista.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        lista.append("}\n");
        return lista.toString();
    }

    public class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;

        // Criação de nó com elem e inserção antes do nó topo
        protected No(T elem) {
            elemento = elem;
            seguinte = topo;
            topo = this;
        }
    }

}
