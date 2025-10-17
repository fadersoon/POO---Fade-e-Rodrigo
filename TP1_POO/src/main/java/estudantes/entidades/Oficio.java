package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um ofício, que é um tipo de deliberação. Um ofício é uma
 * comunicação escrita, formal, entre autoridades ou funcionários.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Oficio extends Deliberacao {

    private String destinatario;

    /**
     * Construtor da classe Oficio.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param texto O conteúdo textual da deliberação.
     * @param destinatario O nome do destinatário do ofício.
     */
    public Oficio(String criador, CodigoCurso codigoCurso, int paginas, String texto, String destinatario) {
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }

    /**
     * Retorna o destinatário do ofício.
     *
     * @return o nome do destinatário.
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Compara este objeto Oficio com outro objeto para verificar se são iguais.
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

        Oficio oficio = (Oficio) o;
        if (oficio.destinatario.equals(this.destinatario)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Oficio.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), destinatario);
    }
}
