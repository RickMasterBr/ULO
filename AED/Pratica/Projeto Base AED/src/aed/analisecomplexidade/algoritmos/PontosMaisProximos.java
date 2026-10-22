package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;


public class PontosMaisProximos {
// Par = Classe pre existente pra guardar 2 valores juntos
// Point2D = Classe pre existente pra definir coordenadas X e Y
// Dentro do <> vão os (2) tipos, nesse caso aqui Ponto X e Ponto Y
// Par<> = Retorno / (Point2D... pontos) = Entrada
// Point2D... = Array do tipo Point2D, chamado pontos, que permite infinitas entradas
// pontos = Nome generico da variável de entrada

    public static Par<Point2D, Point2D> executar(Point2D... pontos) {

        double menorDistancia = Double.MAX_VALUE; // Declarando a variavel com o maior valor possivel (Constante)

        Point2D pontoA = null; // Declarando uma variavel com um tipo vindo de uma Classe, sem intanciar, usando null. (Valor temporário apenas para reservar).

        Point2D pontoB = null; // Mesmo fundamento da variavel acima.

        // Contador padrão: Declarar contador de posição (i), enquanto for menor que a quantidade de variáveis dentro do array Pontos, roda de novo e aumenta o contador em 1.
        for (int i = 0; i < pontos.length; i++) {

            // For aninhando para comparar um ponto (i) com todos os pontos seguintes (i+1), sem repetição e comparação a si mesmo, exemplo: (0,1),(0,2)...(1,2)...(2,3)
            for (int j = i + 1; j < pontos.length; j++) {

                // Recebe o resultado da distância entre um par de pontos, repete para todas as combinações. (Atual ponto (i) + atual ponto (j)
                double distancia = calcularDistancia(pontos[i], pontos[j]);

                // verifica se a distancia entre o par de pontos é menor e troca com a distancia anterior.
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;

                    // recebe o primeiro elemento do menor par descoberto mais recente.
                    pontoA = pontos[i];

                    // recebe o segundo elemento do menor par descoberto mais recente.
                    pontoB = pontos[j];
                }

            }
        }

        // retorna uma nova instancia (objeto) da classe Par, com pontoA e pontoB dentro dele
        // o <> pode ficar vazio pois foi declarado como tipo no inicio da função executar.
        return new Par<>(pontoA, pontoB);

    }

// função do tipo Double que recebe um ponto 1 (p1) e 2 (p2) do tipo Point2D (Classe)

    private static double calcularDistancia(Point2D p1, Point2D p2) {

        // declarando variavel dx tipo Double, onde um ponto (p1 e p2) chama o metodo da classe Point2D que devolve a coordenada X desse ponto.
        // Estamos calculando o Delta, ou seja, variação de X entre os pontos.

        double dx = p1.getX() - p2.getX();

        // Estamos calculando o Delta, ou seja, variação de Y entre os pontos.

        double dy = p1.getY() - p2.getY();

        // Fazendo o calculo matematico e retornando o resultado
        return Math.sqrt(dx * dx + dy * dy);

    }

    public static void apresentar(Point2D... pontos) {

        // declarando uma variavel do tipo Par<Point2D, Point2D>
        // atribuindo a ela o resutaldado da função executar (new Par<> com os pontos A e B)

        Par<Point2D, Point2D> resultado = executar(pontos);

        System.out.println("Par mais proximo: " + resultado);
    }

}