package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/**
 * Representa uma circular, que é um tipo de deliberação. Uma circular é um
 * documento destinado a múltiplos destinatários para comunicar uma decisão ou
 * informação.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Circular extends Deliberacao {

    private String[] destinatarios;

    /**
     * Construtor da classe Circular.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param texto O conteúdo textual da deliberação.
     * @param destinatarios Um array com os nomes dos destinatários da circular.
     */
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios) {
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;
    }

    /**
     * Retorna a lista de destinatários da circular.
     *
     * @return um array de strings com os nomes dos destinatários.
     */
    public String[] getDestinatarios() {
        return destinatarios;
    }

    /**
     * Compara este objeto Circular com outro objeto para verificar se são
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

        Circular circular = (Circular) o;
        if (Arrays.equals(circular.destinatarios, this.destinatarios)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Circular.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode());
        hash = hash * 31 + Arrays.hashCode(destinatarios);
        return hash;
    }
}
