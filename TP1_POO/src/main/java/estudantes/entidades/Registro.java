package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um registro acadêmico associado a um estudante específico.
 * Esta classe é uma especialização de DocumentoAcademico e serve como base
 * para documentos como históricos, certificados e atestados.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Registro extends DocumentoAcademico {
    private String estudante;
    private long matricula;

    /**
     * Construtor da classe Registro.
     *
     * @param criador       O nome do criador do documento.
     * @param codigoCurso   O código do curso associado ao documento.
     * @param paginas       O número de páginas do documento.
     * @param autenticacao  O código de autenticação do documento.
     * @param estudante     O nome do estudante a quem o registro pertence.
     * @param matricula     O número de matrícula do estudante.
     */
    public Registro(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    /**
     * Retorna o nome do estudante.
     *
     * @return o nome do estudante.
     */
    public String getEstudante() {
        return estudante;
    }

    /**
     * Retorna o número de matrícula do estudante.
     *
     * @return a matrícula do estudante.
     */
    public long getMatricula() {
        return matricula;
    }

    /**
     * Compara este objeto Registro com outro objeto para verificar se são iguais.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (this == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Registro registro = (Registro) o;
        if (registro.estudante.equals(this.estudante) && registro.matricula == this.matricula)
            return true;
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Registro.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), estudante, matricula);
    }
}