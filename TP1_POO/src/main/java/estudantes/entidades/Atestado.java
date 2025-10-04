package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Atestado extends Registro {
    private String descricao;
    private String categoria;

    public Atestado(String criador, CodigoCurso codigoCurso, int paginas, long matricula, String estudante, long autenticacao,
                    String descricao, String categoria) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
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
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Atestado atestado = (Atestado) o;
        if (atestado.descricao.equals(this.descricao) && atestado.categoria.equals(this.categoria))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, categoria);
    }
}