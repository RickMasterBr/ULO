package aed.recursividade.algoritmos;

public class Fibonacci {

    // método publico - metodo que será chamado por quem usa a classe
    public static long executar(int n) {

        // validação: fibonacci não existe pra numeros negativos
        if (n < 0) {
            throw new IllegalArgumentException("n não pode ser negativo");
        }

        // Delega o trabalho pro método recursivo
        return executarRecursivo(n);
    }

    // método privado - só existe para fazer a recursão
    // fica separado do 'executar' pra nao repetir a validação de n < 0 toda vez que a função chamar a si mesma.
    private static long executarRecursivo(int n){

        // Caso base: fibonacci(0) = 0 e fibonacci(1) = 1.
        // quando n =0 ou 1 nao tem mais nada pra quebrar - retornar direto.
        if (n < 2){
            return n;
        }

        // caso recursivo: fibonacci(n) = fibonacci(n-2) + fibonacci(n-1)
        // a função chama a si mesma duas vezes, com numeros MENORES, até que chegue ao caso base.
        return executarRecursivo(n-2) + executarRecursivo(n-1);
    }

    public static void apresentar(int n) {
        try {
            System.out.println("Fibonacci(" + n + ") = " + executar(n));
        } catch (Exception e) {
            // se for negativo, cai aqui ao invés de quebrar o programa
            System.out.println("Fibonacci( " + n + ") = " + e.getMessage());
        }
    }
}
