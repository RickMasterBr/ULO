package aed.analisecomplexidade.algoritmos;


public class JogoTorresHanoi_v3 {

    //metodo publico - só recebe o numero de discos, nao precisa saber os nomes das torrer

    public static void executar(int numeroDiscos) {
        if (numeroDiscos < 1) {
            throw new IllegalArgumentException("Numero de discos menor que 1");
        }

        TorreV3 torreA = new TorreV3('A', numeroDiscos);
        TorreV3 torreB = new TorreV3('B', numeroDiscos);
        TorreV3 torreC = new TorreV3('C', numeroDiscos);

        torreA.preencher();

        // chama a versão recursiva, ja fixando os nomes das 3 torres: A, B, C;
        executarRecursivo(numeroDiscos, torreA, torreB, torreC);
    }

    // metodo privado - os parametros mudam de posição a cada chamada, é isso que faz o "giro" dos discos entre as torres funcionar
    private static void executarRecursivo(int numeroDiscos, TorreV3 origem, TorreV3 auxiliar, TorreV3 destino){

        // Caso Base: só sobrou 1 disco, move ele direto, sem mais recursão.
        if (numeroDiscos == 1) {
            moverDisco(origem, destino);
            return;
        }

        // Passo 1: move os (numeroDiscos - 1) discos de cima de 'origem' para 'auxiliar', usando 'destino' como apoio.
        executarRecursivo(numeroDiscos - 1, origem, destino, auxiliar);

        // Passo 2: move o disco que sobrou (o maior) direto de origem para destino
        moverDisco(origem, destino);

        // Passo 3: move os (numeroDiscos - 1) discos que ficaram em 'auxiliar' para 'destino', usando 'origem' como apoio.
        executarRecursivo(numeroDiscos - 1, auxiliar, origem, destino);
    }

    // metodo que só imprime o movimento, separa a logica recursiva da parte de mostrar o resultado
    private static void moverDisco (TorreV3 origem, TorreV3 destino){
        origem.moverDisco(destino);
        System.out.println(origem + " -> " + destino);
    }


    public static void apresentar(int n) {
        try {
            System.out.println("JTH(" + n + ")");
            executar(n);
        } catch (Exception e) {
            System.out.println("JHT(" + n + ")" + e.getMessage());
        }
    }
}
