package aed.ordenacao.utilizacao;

import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.Data;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDes;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDes;
import aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import aed.ordenacao.algoritmos.InsertionSort;

import java.util.Arrays;

public class MainPraticaOrdenacaoContactos {

    public static void main(String[] args) {

        Contacto[] contactosOriginais = new Contacto[]{
                new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845))
        };

        AlgoritmoOrdenacao<Contacto> algoritmo1 =
                new InsertionSort<>(ComparacaoContactosPorNumeroTelefoneDes.CRITERIO);
        AlgoritmoOrdenacao<Contacto> algoritmo2 =
                new InsertionSort<>(ComparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDes.CRITERIO);

        Contacto[] copia1 = Arrays.copyOf(contactosOriginais, contactosOriginais.length);
        Contacto[] copia2 = Arrays.copyOf(contactosOriginais, contactosOriginais.length);

        algoritmo1.apresentar(20, copia1);
        algoritmo2.apresentar(20, copia2);
    }
}
