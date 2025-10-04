package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Registro extends DocumentoAcademico {
    private String estudante;
    private long matricula;

    public Registro(long autenticacao, String criador, CodigoCurso codigoCurso, int paginas, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    public Registro() {
        super();
    }

    public String getEstudante() {
        return estudante;
    }

    public long getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Registro registro = (Registro) o;
        if (registro.estudante.equals(this.estudante) && registro.matricula == this.matricula && registro.getAutenticacao() == this.getAutenticacao()
        && registro.getCriador().equals(this.getCriador()) && registro.getCodigoCurso().equals(this.getCodigoCurso()) && registro.getPaginas() == this.getPaginas())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), estudante, matricula);
    }
}