package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Edital extends Norma {
    private String[] responsaveis;

    public Edital(int numero, boolean valido, String texto, String criador, CodigoCurso codigoCurso, int paginas, String[] responsaveis) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    public Edital() {
        super();
    }

    public String[] getResponsaveis() {
        return responsaveis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Edital edital = (Edital) o;
        if (Arrays.equals(edital.responsaveis, this.responsaveis) && edital.getCriador().equals(this.getCriador()) && edital.getCodigoCurso().equals(this.getCodigoCurso())
            && edital.getPaginas() == this.getPaginas() && edital.getNumero() == this.getNumero() && edital.getValido() == this.getValido() && edital.getTexto().equals(this.getTexto()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode());
        hash = hash * 31 + Arrays.hashCode(responsaveis);
        return hash;
    }
}