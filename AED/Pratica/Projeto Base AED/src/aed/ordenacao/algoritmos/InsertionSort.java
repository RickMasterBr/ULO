package aed.ordenacao.algoritmos;

import aed.Comparacao;

// <T> : A classe funciona com qualquer Tipo (Integer, etc.)
// extends AlgoritmoOrdenação: Herda o atributo 'criterio', 'apresentar' e 'trocar', mas é obrigada a implementar 'ordenar'.

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {

    // o construtor recebe 'criterio' e repassa à classe mãe com 'super(criterio)'.

    public InsertionSort(Comparacao<T> criterio) {

        super(criterio); // Chama o construtor da classe pai
    }

    // É aqui que a filha cumpre a obrigação herdada: escrever o ordenar que na classe pai era abstrato.

    public void ordenar(T... elementos) {

        // esse for pega uma elemento da parte DESORNENADA
        // e vai comparar com a parte ordenada.

        for (int i = 1; i < elementos.length; i++){

            // Por que copiar: mais à frente vamos empurrar elementos maiores para a direita,
            // e um deles vai ser escrito por cima da posição i. Sem a cópia, a carta se perderia. É o mesmo papel do aux no trocar.
            // O selecionado tem de valer o mesmo durante todas as repetições do laço de dentro, porque é com ele que cada elemento é comparado.
            // Por isso fica no laço de fora, antes do de dentro.

            T selecionado = elementos[i];
            int j = i - 1;

            // Enquanto houver carta à esquerda e ela for maior que a selecionada, repete.

            while ( j>= 0 && criterio.comparar(elementos[j], selecionado) > 0){

                // Empurra o elemento maior uma casa para a direita.
                // Direita: lê o elemento da posição j, que acabou de ser considerado maior que o selecionado.
                // Esquerda: escreve esse valor na posição j + 1, a casa logo à direita.

                elementos[j+1] =  elementos[j];

                j--; // Sem essa linha, o j nunca mudaria e o while repetiria para sempre o mesmo elemento.
            }

            elementos[j+1] = selecionado; // coloca ali a carta que guardamos no início da volta.
        }
    }
}
