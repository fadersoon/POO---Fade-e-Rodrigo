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

    public Diploma() {
        super();
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
        Diploma diploma = (Diploma) o;
        if (diploma.habilitacao.equals(this.habilitacao) && diploma.getEstudante().equals(this.getEstudante()) && diploma.getMatricula() == this.getMatricula()
            && diploma.getAutenticacao() == this.getAutenticacao() && diploma.getCriador().equals(this.getCriador()) && diploma.getCodigoCurso().equals(this.getCodigoCurso())
                && diploma.getPaginas() == this.getPaginas() && diploma.getDescricao().equals(this.getDescricao()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), habilitacao);
    }
}