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
public class SubsequenciaSomaMaximaDeOrdemN extends SubsequenciaSomaMaxima {

    @Override
    public long executar(Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        long somaMaxima = 0, somaAtual = 0;
        int positivoInicial = getPositivoInicial(elementos);
        int inicio, fim, inicioAtual;
        inicio = fim = inicioAtual = positivoInicial;
        int positivoFinal = getPositivoFinal(elementos);
        for (int j = positivoInicial; j <= positivoFinal; j++) {
            somaAtual += elementos[j];
            if (somaAtual < 0) {
                inicioAtual = j + 1;
                somaAtual = 0;
            } else if (somaAtual > somaMaxima) {
                fim = j;
                inicio = inicioAtual;
                somaMaxima = somaAtual;
            }
        }
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        return somaMaxima;
    }

}
