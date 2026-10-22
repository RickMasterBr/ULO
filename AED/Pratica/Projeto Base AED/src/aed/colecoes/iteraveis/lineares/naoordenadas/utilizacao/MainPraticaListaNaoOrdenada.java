package aed.colecoes.iteraveis.lineares.naoordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;

public class MainPraticaListaNaoOrdenada {
    public static void main(String[] args) {
        ListaNaoOrdenada<Integer> lista, outra;

        System.out.println("***************** TRANSFERIR PARA O INÍCIO *****************");
        System.out.println("=======================================");
        System.out.println("AMBAS AS LISTAS COM ELEMENTOS");
        lista = new ListaNaoOrdenada<>();
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        outra = new ListaNaoOrdenada<>();
        outra.inserir(4);
        outra.inserir(2);
        transferirEApresentar(lista, outra);

        System.out.println("=======================================");
        System.out.println("LISTA COM ELEMENTOS E OUTRA VAZIA");
        lista = new ListaNaoOrdenada<>();
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        outra = new ListaNaoOrdenada<>();
        transferirEApresentar(lista, outra);

        System.out.println("=======================================");
        System.out.println("LISTA VAZIA E OUTRA COM ELEMENTOS");
        lista = new ListaNaoOrdenada<>();
        outra = new ListaNaoOrdenada<>();
        outra.inserir(3);
        outra.inserir(1);
        outra.inserir(5);
        transferirEApresentar(lista, outra);

        System.out.println();
        System.out.println("***************** REMOVER N ÚLTIMOS *****************");
        System.out.println("=======================================");
        System.out.println("n <= numeroElementos");
        lista = new ListaNaoOrdenada<>();
        lista.inserir(4);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        removerEApresentar(lista, 2);
        System.out.println("=======================================");
        System.out.println("n > numeroElementos");
        lista = new ListaNaoOrdenada<>();
        lista.inserir(4);
        lista.inserir(2);
        removerEApresentar(lista, 5);
        System.out.println("=======================================");
        System.out.println("n == 0");
        lista = new ListaNaoOrdenada<>();
        lista.inserir(4);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        removerEApresentar(lista, 0);
        System.out.println("=======================================");
        System.out.println("numeroElementos = 0");
        lista = new ListaNaoOrdenada<>();
        removerEApresentar(lista, 1);

    }

    private static void transferirEApresentar(ListaNaoOrdenada<Integer> lista, ListaNaoOrdenada<Integer> outra) {
        System.out.println("Listas antes de transferir");
        System.out.println("LISTA => " + lista);
        System.out.println("OUTRA => " + outra);

        lista.transferirParaInicio(outra);
        System.out.println("Listas depois de transferir");
        System.out.println("LISTA => " + lista);
        System.out.println("OUTRA => " + outra);

        System.out.println("Listagem dos elementos da LISTA por ordem inversa");
        IteradorIteravelDuplo<Integer> iterador = lista.iterador();
        while (iterador.podeRecuar()) {
            System.out.println(iterador.recuar());
        }
    }

    private static void removerEApresentar(ListaNaoOrdenada<Integer> lista, int n) {
        System.out.println("Lista antes de remover " + n + " elementos");
        System.out.println("LISTA => " + lista);

        ListaNaoOrdenada<Integer> resultado = lista.removerDoFim(n);
        System.out.println("Listas depois de remover " + n + " elementos");
        System.out.println("LISTA => " + lista);
        System.out.println("RESULTADO => " + resultado);

        System.out.println("Listagem dos elementos da LISTA por ordem inversa");
        IteradorIteravelDuplo<Integer> iterador = lista.iterador();
        while (iterador.podeRecuar()) {
            System.out.println(iterador.recuar());
        }
    }
}
