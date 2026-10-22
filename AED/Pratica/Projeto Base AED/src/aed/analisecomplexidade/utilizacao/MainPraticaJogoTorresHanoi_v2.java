package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.*;

public class MainPraticaJogoTorresHanoi_v2 {

    public static void main(String[] args) {

        // Instanciando as 3 torres

        Torre torreA = new Torre('A');
        Torre torreB = new Torre('B');
        Torre torreC = new Torre('C');

        // Definindo quantos discos serão

        int numeroDiscos = 3;

        // Empilhando os discos na Torre A de tras pra frente

        for(int i = numeroDiscos; i >= 1; i--){
            torreA.colocarDisco(i);
        }

        JogoTorresHanoi_v2.apresentar(numeroDiscos, torreA, torreB, torreC);

    }

}
