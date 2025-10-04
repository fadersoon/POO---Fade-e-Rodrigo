package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Circular extends Deliberacao {
    private String[] destinatarios;

    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios) {
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;
    }

    public Circular() {
        super();
    }

    public String[] getDestinatarios() {
        return destinatarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        Circular circular = (Circular) o;
        if (!super.equals(circular))
            return false;

        if (Arrays.equals(circular.destinatarios, this.destinatarios))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode());
        hash = hash * 31 + Arrays.hashCode(destinatarios);
        return hash;
    }
}