package aed;

// Enum -> é um tipo de conjunto fixo de valores. Aqui só vai existir um valor, o CRITERIO.
// Promete cumprir a regra da interface Comparacao, com T valendo Integer (Todos os T viram Integer).

public enum ComparacaoInteiros implements Comparacao<Integer>{

    CRITERIO;

    // É aqui que a ComparacaoInteiros cumpre a promessa do implements Comparacao<Integer>:
    // escreve o método comparar que a interface exigia.

    public int comparar(Integer o1, Integer o2) {

        // Integer já traz pronto um método compareTo,
        //  que compara ele mesmo (o1) com outro (o2).
        // Ele devolve exatamente o que a interface pede: negativo se o1 é menor, positivo se é maior, 0 se são iguais.
        // chama CRITERIO.comparar (x,y)

        return o1.compareTo(o2);

    }


}
