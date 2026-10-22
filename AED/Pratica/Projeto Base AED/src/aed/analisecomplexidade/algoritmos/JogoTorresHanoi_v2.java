package aed.analisecomplexidade.algoritmos;


// declarando a classe

public class JogoTorresHanoi_v2 {

    // Vamos precisar instanciar 3 torres, então o metodo passa a receber 3 torres como parâmetro.
    // Recebe também o numero de discos do jogo

    public static void executar(int numeroDiscos, Torre origem, Torre auxiliar, Torre destino){

        // validação: não pode ter menos de 1 disco.
        if (numeroDiscos<1) {
            throw new IllegalArgumentException("Número de discos menor que 1");
        }

        // chama o metodo recursivo, passando o numero de discos e as torres.
        // a ordem dos paramtros importa: destino vira auxiliar e auxiliar vira destino,
        // ,pois na primeira chamada o C serve de apoio e B vira destino temporariamente.
        executarRecursivo(numeroDiscos, origem, destino, auxiliar);

    }

    private static void executarRecursivo(int numeroDiscos, Torre origem, Torre auxiliar, Torre destino){

        // Caso base de recursão, pra evitar repetição infinita

        if (numeroDiscos==1) {
            moverDisco(origem, destino);
            return;
        }

        // Passo 1: move os discos de cima da 'origem' para 'auxiliar1, usando destino como apoio e deixando o maior disco em origem.
        executarRecursivo(numeroDiscos - 1, origem, destino, auxiliar);

        // Passo 2: Move o maior disco (que deixamos na torre de origem) para o destino final
        moverDisco(origem, destino);

        // Passo 3: move os discos que ficaram em "auxiliar" para "destino" usando origem como apoio.
        executarRecursivo(numeroDiscos - 1, auxiliar, origem, destino);
    }

    // Esse método só precisa de duas torres: De onde tirar e onde colocar.
    private static void moverDisco(Torre origem, Torre destino){

        int disco = origem.removerDisco(); // chama o metodo de remover o disco do topo, vindo da classe torre

        destino.colocarDisco(disco); // colocando disco na torre de destino

        System.out.println(origem.getNome() + " -> " + destino.getNome());

    }

    public static void apresentar(int n, Torre origem, Torre auxiliar, Torre destino){

        // tudo dentro do 'try' é monitorado pra caso algum throw aconteça.
        // captura qualquer exceção que tenha acontecido

        try {
            System.out.println("JTH(" + n + ")");
            executar(n, origem, auxiliar, destino);
        } catch (Exception e) {
            System.out.println("JHT(" + n + ")" + e.getMessage());
        }

    }





}
