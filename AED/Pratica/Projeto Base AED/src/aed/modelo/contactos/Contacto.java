package aed.modelo.contactos;

import java.io.Serializable;
import java.util.Objects;

public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String primeiroNome;
    private final String ultimoNome;
    private final long numeroTelefone;
    private final String morada;
    private final Data dataNascimento;

    public Contacto(String primeiroNome, String ultimoNome,
                    long numeroTelefone, String morada,
                    Data dataNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getMorada() {
        return morada;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contacto contacto = (Contacto) o;

        if (numeroTelefone != contacto.numeroTelefone) {
            return false;
        }
        if (!Objects.equals(primeiroNome, contacto.primeiroNome)) {
            return false;
        }
        if (!Objects.equals(ultimoNome, contacto.ultimoNome)) {
            return false;
        }
        if (!Objects.equals(morada, contacto.morada)) {
            return false;
        }
        return Objects.equals(dataNascimento, contacto.dataNascimento);
    }

    @Override
    public int hashCode() {
        int result = primeiroNome != null ? primeiroNome.hashCode() : 0;
        result = 31 * result + (ultimoNome != null ? ultimoNome.hashCode() : 0);
        result = 31 * result + (int) (numeroTelefone ^ (numeroTelefone >>> 32));
        result = 31 * result + (morada != null ? morada.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome +
                " - Nº: " + numeroTelefone +
                " - " + dataNascimento +
                " - " + morada + '\n';
    }

}
