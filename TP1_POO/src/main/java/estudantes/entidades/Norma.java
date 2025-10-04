package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Norma extends DocumentoAdministrativo {
    private int numero;
    private boolean valido;
    private String texto;

    public Norma(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }

    public Norma() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public boolean getValido() {
        return valido;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Norma norma = (Norma) o;
        if (norma.numero == this.numero && norma.valido == this.valido && norma.texto.equals(this.texto) && norma.getCriador().equals(this.getCriador())
            && norma.getCodigoCurso().equals(this.getCodigoCurso()) && norma.getPaginas() == this.getPaginas())
            return true;
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numero, valido, texto);
    }
}