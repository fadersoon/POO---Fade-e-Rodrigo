package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um documento genérico dentro do sistema da universidade. Esta é
 * uma classe abstrata que serve como base para todos os outros tipos de
 * documentos.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public abstract class Documento {

    private String criador;
    private CodigoCurso codigoCurso;
    private int paginas;

    /**
     * Construtor da classe abstrata Documento.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso ao qual o documento pertence.
     * @param paginas O número de páginas do documento.
     */
    public Documento(String criador, CodigoCurso codigoCurso, int paginas) {
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }

    /**
     * Retorna o nome do criador do documento.
     *
     * @return o nome do criador.
     */
    public String getCriador() {
        return criador;
    }

    /**
     * Retorna o código do curso associado ao documento.
     *
     * @return o código do curso.
     */
    public CodigoCurso getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * Retorna o número de páginas do documento.
     *
     * @return o número de páginas.
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * Compara este objeto Documento com outro objeto para verificar se são
     * iguais. A comparação é baseada no criador, código do curso e número de
     * páginas.
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

        Documento documento = (Documento) o;
        if (documento.criador.equals(this.criador) && documento.codigoCurso.equals(this.codigoCurso) && this.paginas == documento.paginas) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Documento.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(criador, codigoCurso, paginas);
    }
}
