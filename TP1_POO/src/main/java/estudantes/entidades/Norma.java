package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa uma norma, que é um tipo de documento administrativo. Uma norma
 * estabelece regras e procedimentos a serem seguidos.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Norma extends DocumentoAdministrativo {

    private int numero;
    private boolean valido;
    private String texto;

    /**
     * Construtor da classe Norma.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param numero O número da norma.
     * @param valido Indica se a norma está em vigor (true) ou não (false).
     * @param texto O conteúdo textual da norma.
     */
    public Norma(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }

    /**
     * Retorna o número da norma.
     *
     * @return o número da norma.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Verifica se a norma é válida.
     *
     * @return true se a norma estiver válida, false caso contrário.
     */
    public boolean getValido() {
        return valido;
    }

    /**
     * Retorna o texto da norma.
     *
     * @return o conteúdo da norma.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Compara este objeto Norma com outro objeto para verificar se são iguais.
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

        Norma norma = (Norma) o;
        if (norma.numero == this.numero && norma.valido == this.valido && norma.texto.equals(this.texto)) {
            return true;
        }
        return false;

    }

    /**
     * Retorna o código de hash para este objeto Norma.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numero, valido, texto);
    }
}
