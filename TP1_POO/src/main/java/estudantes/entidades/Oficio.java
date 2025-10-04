package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Oficio extends Deliberacao {
    private String destinatario;

    public Oficio(String criador,CodigoCurso codigoCurso, int paginas, String destinatario, String texto) {
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }

    public Oficio() {
        super();
    }

    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (this == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        Oficio oficio = (Oficio) o;
        if (oficio.destinatario.equals(this.destinatario) && oficio.getCriador().equals(this.getCriador()) && oficio.getCodigoCurso().equals(this.getCodigoCurso())
        && oficio.getPaginas() == this.getPaginas() && oficio.getTexto().equals(this.getTexto()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), destinatario);
    }
}