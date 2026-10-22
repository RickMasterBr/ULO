package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;


public enum ComparacaoContactosPorNumeroTelefoneDes implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto c1, Contacto c2) {
        //todo Ficha Prática 3 - 2.a)

        return -Long.compare(c2.getNumeroTelefone(),c1.getNumeroTelefone());

    }
}
