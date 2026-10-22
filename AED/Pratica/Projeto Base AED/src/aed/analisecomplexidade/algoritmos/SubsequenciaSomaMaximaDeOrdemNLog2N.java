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
public class SubsequenciaSomaMaximaDeOrdemNLog2N extends SubsequenciaSomaMaxima {

    @Override
    public long executar(Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        return executarRecursivo(indicesInicialEFinal, elementos, getPositivoInicial(elementos), getPositivoFinal(elementos));
    }

    private long executarRecursivo(Par<Integer, Integer> indicesInicialEFinal, int[] elementos, int esq, int dir) {
        long somaMaxima = 0;
        int inicio, fim;
        if (esq == dir) {
            indicesInicialEFinal.setPrimeiro(esq);
            indicesInicialEFinal.setSegundo(dir);
            inicio = fim = esq;
            somaMaxima = elementos[esq] > 0 ? elementos[esq] : 0;
            return somaMaxima = 0;
        }

        int meio = (esq + dir) / 2;
        Par<Integer, Integer> indicesInicialEFinalEsq = new Par<>(0, 0);
        Par<Integer, Integer> indicesInicialEFinalDir = new Par<>(0, 0);
        long somaMaximaEsq = executarRecursivo(indicesInicialEFinalEsq, elementos, esq, meio);
        long somaMaximaDir = executarRecursivo(indicesInicialEFinalDir, elementos, meio + 1, dir);
        int inicioEsq = indicesInicialEFinalEsq.getPrimeiro();
        int fimEsq = indicesInicialEFinalEsq.getSegundo();
        int inicioDir = indicesInicialEFinalDir.getPrimeiro();
        int fimDir = indicesInicialEFinalDir.getSegundo();
        long somaMaximaMeioEsq = 0, somaAtualMeioEsq = 0;
        int inicioEsqDir = meio + 1;
        for (int i = meio; i >= esq; i--) {
            somaAtualMeioEsq += elementos[i];
            if (somaAtualMeioEsq > somaMaximaMeioEsq) {
                inicioEsqDir = i;
                somaMaximaMeioEsq = somaAtualMeioEsq;
            }
        }

        long somaMaximaMeioDir = 0, somaAtualMeioDir = 0;
        int fimEsqDir = meio;
        for (int i = meio + 1; i <= dir; i++) {
            somaAtualMeioDir += elementos[i];
            if (somaAtualMeioDir > somaMaximaMeioDir) {
                fimEsqDir = i;
                somaMaximaMeioDir = somaAtualMeioDir;
            }
        }

        long somaMaximaEsqDir = somaMaximaMeioEsq + somaMaximaMeioDir;
        if (somaMaximaEsq >= somaMaximaDir && somaMaximaEsq >= somaMaximaEsqDir) {
            inicio = inicioEsq;
            fim = fimEsq;
            indicesInicialEFinal.setPrimeiro(inicio);
            indicesInicialEFinal.setSegundo(fim);
            somaMaxima = somaMaximaEsq;
            return somaMaxima;
        }
        if (somaMaximaDir >= somaMaximaEsqDir) {
            inicio = inicioDir;
            fim = fimDir;
            indicesInicialEFinal.setPrimeiro(inicio);
            indicesInicialEFinal.setSegundo(fim);
            somaMaxima = somaMaximaDir;
            return somaMaxima;
        }
        inicio = inicioEsqDir;
        fim = fimEsqDir;
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        somaMaxima = somaMaximaEsqDir;
        return somaMaxima;
    }

}
