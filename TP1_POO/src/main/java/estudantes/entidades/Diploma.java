package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Diploma extends Certificado {
    private String habilitacao;

    public Diploma(String criador, CodigoCurso codigoCurso, int paginas,  long matricula, String descricao, long autenticacao, String estudante,
                   String habilitacao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }


    public String getHabilitacao() {
        return habilitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (this == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Diploma diploma = (Diploma) o;
        if (diploma.habilitacao.equals(this.habilitacao))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), habilitacao);
    }
}