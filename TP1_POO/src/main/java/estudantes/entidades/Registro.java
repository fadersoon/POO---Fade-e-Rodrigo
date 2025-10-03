package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Registro extends DocumentoAcademico {
    private String estudante;
    private long matricula;

    public Registro(long autenticacao, String criador, CodigoCurso codigoCurso, int paginas, String estudante, long matricula) {
        super(autenticacao, criador, codigoCurso, paginas);
        this.estudante = estudante;
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

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }

}
