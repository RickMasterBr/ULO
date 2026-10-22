package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;


public enum ComparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDes implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        //todo Ficha Prática 3 - 2.a)

        int cp = o1.getUltimoNome().compareTo(o2.getUltimoNome());
        if (cp != 0) {
            return cp;
        }

        return -o1.getDataNascimento().compareTo(o2.getDataNascimento());


    }
}
