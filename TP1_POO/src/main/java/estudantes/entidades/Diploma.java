package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Diploma extends Certificado {
    private String habilitacao;

    public Diploma(String descricao, String estudante, long matricula, long autenticacao,
                   String criador, CodigoCurso codigoCurso, int paginas, String habilitacao) {
        super(descricao, estudante, matricula, autenticacao, criador, codigoCurso, paginas);
        this.habilitacao = habilitacao;
    }

    public Diploma() {
        super();
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }

}
