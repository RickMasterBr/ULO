package aed.ordenacao.algoritmos;

// importando nossa interface.

import aed.Comparacao;
import aed.utils.Vetor;

// Abstratc: A clase NÂO pode ser implementada, é só uma classe pra ser herdada por todos os algoritmos de Ordenação.

public abstract class AlgoritmoOrdenacao<T>{

    // Protected: Só essa classe e as filhas podem ver esse atributo
    // final: depois de receber um valor, nao pode mais ser trocado.
    // Comparacao<T> é o tipo do atributo;

    protected final Comparacao<T> criterio;

    // construtor: dar valor inicial aos atributos quando um objeto é criado
    // Vai rodar com alguem criar um classe filha (extends AlgoritmoOrdenacao)

    public AlgoritmoOrdenacao(Comparacao<T> criteiro){
        this.criterio = criteiro;

    }

    // Metodo abstrato (sem corpo {}), quem herdar é obrigado a escrevê-lo.
    // T... elementos -> recebe qualquer quantidade de elementos do Tipo T. (A classe troca o tipo ao ser herdada e instanciada)
    // T... elementos recebe tanto valores soltos quanto vetores.

    public abstract void ordenar(T... elementos);


    // Não é abstract, já vai vir pronta.
    // numeroElementosApresentar -> o limite de elementos a mostrar, é o primeiro numero na hora de chamar e não faz parte da sequência).
    // T... elementos -> a sequencia a ordenar. (Mesmo da classe abstrata acima)

    public void apresentar(int numeroElementosApresentar, T... elementos){

        ordenar(elementos); // chama o método ordenar dessa mesma classe, passando o vetor elementos que chegou no 'apresentar'.

        // getClass().getSimpleName(): pergunta ao objeto "de que classe você é?" e devolve só o nome

        System.out.println("Sequencia ordenada por " + getClass().getSimpleName() + ": ");

        // Passa a lista ordenada pra outra classe pra imprimir os numeros na tela.

        Vetor.apresentar(numeroElementosApresentar, elementos);

    }

    // Metodo pra trocar dois elementos de lugar na lista.
    // Os algoritmos vao usar para não ter que repetir o codigo da troca.
    // Aqui é 'T[]', vetor onde acontece a troca, não pode ser 'T...' pois não é o ultimo parâmetro
    // os indices são as posições a trocar.

    protected void trocar(T[] elementos, int indice1, int indice2) {

        T aux = elementos[indice1]; // Criando uma var temporaria do mesmo tipo dos elementos (T)
        elementos[indice1] = elementos[indice2]; // escreve esse valor na posição indice1, por cima do que estava lá.
        elementos[indice2] = aux; // Escreve na posição indice2 o valor que o aux guardou (o antigo elementos[indice1]).
    }


}