package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Certificado extends Registro {
    private String descricao;

    public Certificado(String estudante, long matricula, long autenticacao,
                       String criador, CodigoCurso codigoCurso, int paginas, String descricao) {
        super(estudante, matricula, autenticacao, criador, codigoCurso, paginas);
        this.descricao = descricao;
    }

    public Certificado() {
        super();
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }

}
