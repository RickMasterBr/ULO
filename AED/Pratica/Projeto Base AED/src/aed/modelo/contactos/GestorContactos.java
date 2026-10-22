package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public enum GestorContactos {
    INSTANCIA;

    GestorContactos() {
    }

    public void inserir(Contacto contacto) {
    }

    public Contacto remover(Contacto contacto) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public Contacto consultar(long numeroTelefone) {
        // todo Apenas na Ficha Prática 6
        return null;
    }


    public Contacto remover(long numeroTelefone) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento, String morada) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public IteradorIteravel<String> consultarMoradas(Data dataNascimento) {
        // todo Apenas na Ficha Prática 6
        return null;
    }
}
