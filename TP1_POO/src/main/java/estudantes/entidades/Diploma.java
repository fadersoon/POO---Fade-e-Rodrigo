package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um diploma, que é um tipo específico de certificado. O diploma
 * atesta a conclusão de um curso e confere uma habilitação ao estudante.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Diploma extends Certificado {

    private String habilitacao;

    /**
     * Construtor da classe Diploma.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param autenticacao O código de autenticação do registro.     
     * @param estudante O nome do estudante a quem o diploma se refere. 
     * @param matricula A matrícula do estudante.                     
     * @param descricao A descrição do diploma.                      
     * @param habilitacao A habilitação conferida pelo diploma (ex: Bacharel em
     * Engenharia de Software).
     */
    public Diploma(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao,
            String habilitacao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }

    /**
     * Retorna a habilitação conferida pelo diploma.
     *
     * @return a habilitação do diploma.
     */
    public String getHabilitacao() {
        return habilitacao;
    }

    /**
     * Compara este objeto Diploma com outro objeto para verificar se são
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

        if (this == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Diploma diploma = (Diploma) o;
        if (diploma.habilitacao.equals(this.habilitacao)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Diploma.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), habilitacao);
    }
}
