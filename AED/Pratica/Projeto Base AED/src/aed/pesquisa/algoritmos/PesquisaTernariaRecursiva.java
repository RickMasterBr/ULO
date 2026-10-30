package aed.pesquisa.algoritmos;

import aed.Comparacao;

// dividir uma sequência em 3 partes: esquerda, central, direita.

// Classes ja prontas: Comparacao<T>, ComparacaoInteiros, AlgoritmoPesquisa<T>.

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }


    // Override avisa que estamos cumprindo um metodo abstrato da classe mãe.
    @Override
    public int pesquisar(T elemento, T... elementos) {

        // Aqui o professor colocou diversas validações sobre o elemento, ou array de elementos e etc...

        return pesquisarRecursivo(elemento, 0, elementos.length - 1, elementos);

        /* Explicação dos parâmetros de pesquisarRecursivo:
        * elemento: é o numero que você quer encontrar
        * 0: é o primeiro índice da zona que ainda vale procurar.
        * elementos.length - 1: é o ultimo indice da mesma zona, num vetor de 6 elementos, vale 5, pois os indices vao de 0 a 5
        * elementos: é o vetor ordenado, pesquisa ternaria só há em vetores ordenados.
        * esq e dir: não são os limites da parte esquerda ou direita, são os limites da faixa inteira que ainda está sendo pesquisada.
        * esq é o indice mais à esquerda e dir o índice mais à direita dessa faixa.
        * esq = 0 e dir = elementos.length - 1 significa: "Procura em todo vetor, do primeiro indice ao ultimo" */

    }

    private int pesquisarRecursivo(T elemento, int esq, int dir, T... elementos){

        // caso de paragem: quando esq for maior de dir, significa que a faixa ficou vazia, onde não há mais onde procurar.
        if (esq > dir){
            return NAO_ENCONTRADO;
        }

        int terco = (dir - esq) / 3;  // calcula quantos índices há num terço da faixa (tamanho da faixa atual).
        int m1 = esq + terco;  // é o primeiro ponto intermédio, mais perto do início.
        int m2 = dir - terco;  // pe o segundo ponto intermédio, mais perto do fim.

        // com os pontos intermédios calculados, vem a primeira comparação:

        int cp1 = criterio.comparar(elemento, elementos[m1]); // guarda o resultado de comparar o elemento procurado com o valor que está no índice m1.

        if (cp1 < 0) {  // o elemento só pode estar na parte esquerda, então chamamos recursivamente com a faixa esq até m1 - 1. (o m1 fica de fora pois ja sabemo que nao é ele)
            return pesquisarRecursivo(elemento, esq, m1 - 1, elementos);
        }
        if (cp1 == 0){  // encontramos o numero procurado, é o proprio m1, então devolvemos ele.
            return m1;
        }

        // se não for nenhum dos casos acima, vamos à segunda comparação:

        int cp2 = criterio.comparar(elemento, elementos[m2]); // compara o elemento procurado com o valor no segundo ponto intermédio, elementos[m2]

        if (cp2 < 0) {  // o elemento é menor que elementos[m2], mas maior que elementos[m1], logo só pode estar na parte central.
            return pesquisarRecursivo(elemento, m1 + 1, m2 -1, elementos);
        }

        if (cp2 == 0) { // encontramos o numero procurado, é o proprio m2.
            return m2;
        }

        // ultimo caso é cp2 > 0, o elementos é maior que ambos os pontos intermedios,
        // então vai para a parte direita: indices m2 + 1 até dir.
        return pesquisarRecursivo(elemento, m2 + 1, dir, elementos);

    }


}
