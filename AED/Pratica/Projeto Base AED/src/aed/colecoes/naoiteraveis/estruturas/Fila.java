package aed.colecoes.naoiteraveis.estruturas;

import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;
import aed.colecoes.naoiteraveis.ColecaoNaoIteravel;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Fila<T> implements ColecaoNaoIteravel<T> {
    private static final long serialVersionUID = 1L;

    protected ListaNaoOrdenada<T> elementos;

    public Fila() {
        elementos = new ListaNaoOrdenada<>();
    }

    @Override
    public void inserir(T elem) {
        elementos.inserirNoFim(elem);
    }

    @Override
    public T remover() {
        return elementos.removerDoInicio();
    }

    @Override
    public T consultar() {
        try {
            return elementos.consultarPorIndice(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public boolean isVazia() {
        return elementos.isVazia();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Fila = {\n");
        for (T elemento : elementos) {
            s.append(elemento).append("\n");
        }
        s.append("}\n");
        return s.toString();
    }
}
