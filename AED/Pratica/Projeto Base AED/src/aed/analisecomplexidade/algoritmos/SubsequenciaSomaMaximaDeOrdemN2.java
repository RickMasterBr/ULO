package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class SubsequenciaSomaMaximaDeOrdemN2 extends SubsequenciaSomaMaxima {

    @Override
    public long executar(Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        long somaMaxima = 0, somaAtual;
        int inicio = 0, fim = 0;
        int positivoFinal = getPositivoFinal(elementos);
        for (int i = 0; i <= positivoFinal; i++) {
            if (elementos[i] <= 0) {
                continue;
            }
            somaAtual = 0;
            for (int j = i; j <= positivoFinal; j++) {
                somaAtual += elementos[j];
                if (somaAtual > somaMaxima) {
                    inicio = i;
                    fim = j;
                    somaMaxima = somaAtual;
                }
            }
        }
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        return somaMaxima;
    }
}
