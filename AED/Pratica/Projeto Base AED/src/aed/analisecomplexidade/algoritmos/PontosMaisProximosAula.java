package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;
import java.awt.geom.Point2D;
import java.util.Arrays;

// versao do professor em aula

public class PontosMaisProximosAula {

    public static Par<Point2D, Point2D> executar(Point2D... pontos) {

        int length = pontos.length;
        if (length < 2) {
            throw new IllegalArgumentException("Deve ter pelo menos dois pontos");
        }

        if (length==2) {
            return new Par<>(pontos[0],pontos[1] );
        }

        double distanciaMinima = Double.MAX_VALUE;

        int im = 0;
        int jm = 0;
        for (int i = 0; i < pontos.length - 1; i++) {
            for (int j = i + 1; j < pontos.length; j++) {

                double distancia = pontos[i].distanceSq(pontos[j]);
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;

                    im = i;
                    jm = j;
                }
            }
        }
        return new Par<>(pontos[im], pontos[jm]);
    }

    public static void apresentar(Point2D... pontos){
        System.out.println(executar(pontos));
    }

}
