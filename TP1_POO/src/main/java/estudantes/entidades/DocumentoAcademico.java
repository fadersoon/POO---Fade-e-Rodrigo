package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um documento acadêmico, que é uma especialização de um Documento.
 * Caracteriza-se por possuir um código de autenticação para validar sua
 * veracidade.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class DocumentoAcademico extends Documento {

    private long autenticacao;

    /**
     * Construtor da classe DocumentoAcademico.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param autenticacao O código numérico de autenticação do documento.
     */
    public DocumentoAcademico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }

    /**
     * Retorna o código de autenticação do documento.
     *
     * @return o código de autenticação.
     */
    public long getAutenticacao() {
        return autenticacao;
    }

    /**
     * Compara este objeto DocumentoAcademico com outro objeto para verificar se
     * são iguais.
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

        DocumentoAcademico documentoAcademico = (DocumentoAcademico) o;
        if (this.autenticacao == documentoAcademico.autenticacao) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto DocumentoAcademico.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.autenticacao);
    }
}
