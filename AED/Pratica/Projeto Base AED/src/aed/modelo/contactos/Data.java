package aed.modelo.contactos;

import java.io.Serializable;
import java.util.Objects;


public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int dia;
    private final int mes;
    private final int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return dia == data.dia &&
                mes == data.mes &&
                ano == data.ano;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dia, mes, ano);
    }

    public int compareTo(Data dataNascimento) {

        int cp = Integer.compare(ano, dataNascimento.ano);
        if (cp != 0) {
            return cp;
        }

        cp = Integer.compare(mes, dataNascimento.mes);
        if (cp != 0) {
            return cp;
        }

        return Integer.compare(dia, dataNascimento.dia);

    }
}
