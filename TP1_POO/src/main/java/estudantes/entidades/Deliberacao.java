package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa uma deliberação, que é um tipo de documento administrativo. Uma
 * deliberação formaliza uma decisão ou resolução de um órgão colegiado.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Deliberacao extends DocumentoAdministrativo {

    private String texto;

    /**
     * Construtor da classe Deliberacao.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param texto O conteúdo textual da deliberação.
     */
    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto) {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }

    /**
     * Retorna o texto da deliberação.
     *
     * @return o conteúdo da deliberação.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Compara este objeto Deliberacao com outro objeto para verificar se são
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

        Deliberacao deliberacao = (Deliberacao) o;
        if (deliberacao.texto.equals(this.texto)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Deliberacao.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), texto);
    }
}
