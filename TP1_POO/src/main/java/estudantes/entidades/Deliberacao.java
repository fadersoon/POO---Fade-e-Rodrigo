package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Deliberacao extends DocumentoAdministrativo {
    private String texto;

    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto) {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }

    public Deliberacao() {
        super();
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null)
                return false;

            if (this.getClass() != o.getClass())
                return false;

            Deliberacao deliberacao = (Deliberacao) o;
            if (!super.equals(deliberacao))
                return false;

            if (deliberacao.texto.equals(this.texto))
                return true;
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), texto);
    }
}
