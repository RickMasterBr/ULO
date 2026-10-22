package aed;

// uma interface declara o que deve existir (nomes de metodos) sem escrever o código deles,
// é uma lista de exigências.
// <T> é um tipo coringa, troca os tipos das variaveis dentro da interface

public interface Comparacao<T>{

    // declaração de metodo que retorna int e recebe 2 parâmetros. (Sem o corpo {})
    // esse método vai respoder qual dos dois elementos é maior.

    int comparar(T o1, T o2);
}
