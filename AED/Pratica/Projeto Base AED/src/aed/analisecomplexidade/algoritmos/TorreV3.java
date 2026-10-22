package aed.analisecomplexidade.algoritmos;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TorreV3 {

    private char nome; // Torre A, B, C.
    private int[] baseDiscos; // [0] = 3x qtd discos
    private int numeroDiscos;


    // Construtor para inicializar dando nome
    public TorreV3 (char nome, int numeroMaximoDiscos){

        this.nome = nome;
        baseDiscos = new int[numeroMaximoDiscos + 1];
        baseDiscos[0] = numeroMaximoDiscos * 3;
        numeroDiscos = 0;

        // Caso geral: nmd - i + 1
    }

    // Colocar discos do maior ao menor com For e no índice 0 multiplicar por 3
    public void preencher(){

        int length = baseDiscos.length;

        for(int i = 1; i < length; i++){
            baseDiscos[i] = length - i;
        }

        numeroDiscos = length - 1;
    }

    // mover discos de uma origem pra um destino
    public void moverDisco(TorreV3 destino){

        if (this == destino) {
            throw new IllegalArgumentException("Não é possivel mover um disco para a mesma Torre");
        }

        if (numeroDiscos == 0) {
            throw new NoSuchElementException("Não há discos para mover");
        }

        if (destino.numeroDiscos == destino.baseDiscos.length - 1) {
            throw new ArrayIndexOutOfBoundsException("A torre de destino está cheia");
        }

        if (destino.baseDiscos[destino.numeroDiscos] <= baseDiscos[numeroDiscos]) {
            throw new IllegalArgumentException("O disco a mover é maior que o disco da Torre de Destino");
        }

        // Copia o disco do topo da origem (this) para a primeira posição livre do destino.
        // ++destino.numeroDiscos soma 1 ANTES de usar o valor, então o índice já é a posição livre.
        destino.baseDiscos[++destino.numeroDiscos] = baseDiscos[numeroDiscos];

        baseDiscos[numeroDiscos--] = 0; //zera o índice de onde o disco foi retirado



    }

    @Override
    public String toString() {
        return String.valueOf(nome);
    }
}


