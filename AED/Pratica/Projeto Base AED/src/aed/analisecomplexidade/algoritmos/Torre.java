package aed.analisecomplexidade.algoritmos; // declarando o pacote onde a classe vive

import java.util.Stack; // importando uma classe de um pacote java. Stack = Pilha

// Declarando a classe Torre como public

public class Torre {

    // declarando os atributos da classe

    private char nome; // Guardar a identificação de torre: 'A', 'B', 'C'.
    private Stack<Integer> discos; // atributo do tipo Pilha que vai guardar Inteiros, vai guardar os discos do maior ao menor.


    // Construtor, metodo que roda ao criar uma nova torre. Recebe um nome ao ser criada

    public Torre(char nome){

        this.nome = nome; // O atributo nome desse novo objeto recebe o valor do parâmetro nome ao ser criado.
        this.discos = new Stack<>(); // Instanciando uma nova pilha toda vez que uma nova torre for criada. (Pilha vazia)

    }

    // método para colocar um disco no topo da torre.

    public void colocarDisco(int disco) {

        // Regra: disco maior NÃO PODE ficar sobre o disco menor.
        // !discos.isEmpty() -> retorna TRUE se a pilha está vazia, porém com o '!', lê-se "a pilha NÃO está vazia"
        // && discos.peek() -> E + olha o elemento do topo SEM REMOVER ele.
        // < disco -> compara se o disco do topo é menor que o disco que estamos colocando.

        if (!discos.isEmpty() && discos.peek() < disco) {

            // Interrompe a execução e jogar um erro
            throw new IllegalArgumentException("Disco " + disco + " não cabe sobre o disco " + discos.peek() + " na torre " + nome);

        }

        // Metodo da classe Stack (pilha) que coloca um elemento no topo da pilha

        discos.push(disco);
    }

    // método pra remover um disco do topo da torre. ( Aqui será 'int' pois devolverá um valor no final: o número do disco removido).

    public int removerDisco() {

        // validação se a torre está vazia, sem discos não da para tirar

        if (discos.isEmpty()){
            throw new IllegalStateException("A Torre " + nome + " está vazia"); // diferença entre a exceção anterior: aqui o objeto está em um estado errado para a operação (Vazio).
        }

        return discos.pop(); // Metodo de Stack (Pilha), remove e devolve o elemento no topo da Pilha.

    }

    public  void apresentar(){

        System.out.println("Torre " + nome + ": " + discos);

    }


    public char getNome() {
        return nome;
    }
}
