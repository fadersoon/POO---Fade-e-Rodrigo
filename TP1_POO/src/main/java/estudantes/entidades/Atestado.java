package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um atestado, que é um tipo de registro acadêmico.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Atestado extends Registro {

    private String descricao;
    private String categoria;

    /**
     * Construtor da classe Atestado.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param matricula A matrícula do estudante.
     * @param estudante O nome do estudante.
     * @param autenticacao O código de autenticação do registro.
     * @param descricao A descrição do atestado.
     * @param categoria A categoria do atestado.
     */
    public Atestado(String criador, CodigoCurso codigoCurso, int paginas, long matricula, String estudante, long autenticacao,
            String descricao, String categoria) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    /**
     * Retorna a descrição do atestado.
     *
     * @return a descrição do atestado.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna a categoria do atestado.
     *
     * @return a categoria do atestado.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Compara este objeto Atestado com outro objeto para verificar se são
     * iguais.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Atestado atestado = (Atestado) o;
        if (atestado.descricao.equals(this.descricao) && atestado.categoria.equals(this.categoria)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Atestado.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, categoria);
    }
}
