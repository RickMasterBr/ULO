package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;
import aed.utils.VetorDeInteiros;

import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public abstract class SubsequenciaSomaMaxima {

    public abstract long executar(Par<Integer, Integer> indicesInicialEFinal, int... elementos);

    public void apresentar(int numeroElementosApresentar, int... elementos) {
        Par<Integer, Integer> indicesInicialEFinal = new Par<>(0, 0);
        System.out.println("Subsequência da soma máxima calculada com " + getClass().getSimpleName() + "da sequência: ");
        VetorDeInteiros.apresentar(numeroElementosApresentar, elementos);
        long resultado = executar(indicesInicialEFinal, elementos);
        System.out.println("Indice inicial = " + indicesInicialEFinal.getPrimeiro() +
                " Indice final = " + indicesInicialEFinal.getSegundo() +
                " Soma = " + resultado);
        VetorDeInteiros.apresentar(numeroElementosApresentar,
                Arrays.copyOfRange(elementos, indicesInicialEFinal.getPrimeiro(), indicesInicialEFinal.getSegundo() + 1));
    }

    protected int getPositivoInicial(int[] elementos) {
        int positivoInicial = -1;
        while (++positivoInicial < elementos.length && elementos[positivoInicial] <= 0) ;
        return positivoInicial;
    }

    protected int getPositivoFinal(int[] elementos) {
        int positivoFinal = elementos.length;
        while (--positivoFinal >= 0 && elementos[positivoFinal] <= 0) ;
        return positivoFinal;
    }
}
