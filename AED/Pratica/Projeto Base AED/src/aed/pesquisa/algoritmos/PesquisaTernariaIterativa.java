package aed.pesquisa.algoritmos;

import aed.Comparacao;

/* dividir uma sequência em 3 partes: esquerda, central, direita.
 * Classes ja prontas: Comparacao<T>, ComparacaoInteiros, AlgoritmoPesquisa<T>.
 */

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {

        // esq e dir são as mesmas variáveis da versão recursiva, mas vivem dentro do método e são alteradas.

        int esq = 0;
        int dir = elementos.length - 1;

        /* aqui substitui a recursão
         * enquanto a faixa tiver pelo menos um elemento, continua a procurar.
         * quando esq > dir, a faixa ficou vazia e o WHILE termina e devolve NAO_ENCONTRADO
         */

        while (esq <= dir) { // professro usou do while (?)

            int terco = (dir - esq) / 3;
            int m1 = esq + terco;
            int m2 = dir - terco;

            int cp1 = criterio.comparar(elemento, elementos[m1]);

            if (cp1 < 0) {
                dir = m1 - 1;
            } else if (cp1 == 0) {
                return m1;
            }

            int cp2 = criterio.comparar(elemento, elementos[m2]);

            if (cp2 < 0) { // Começa a pesquisa na fiaxa central
                esq = m1 + 1;
                dir = m2 - 1;
            } else if (cp2 == 0) { // m2 é o proprio elemento
                return m2;
            } else {  // o elemento é maior que ambos, então a faixa vira a parte direita.
                esq = m2 + 1;
            }


        }
        return NAO_ENCONTRADO;
    }
}
