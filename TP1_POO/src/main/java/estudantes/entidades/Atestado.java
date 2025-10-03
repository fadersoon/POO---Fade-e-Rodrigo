package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Atestado extends Registro {
    private String descricao;
    private String categoria;

    public Atestado(String estudante, long matricula, long autenticacao, String criador,
                    CodigoCurso codigoCurso, int paginas, String descricao, String categoria) {
        super(estudante, matricula, autenticacao, criador, codigoCurso, paginas);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Atestado() {
        super();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
    }

}
