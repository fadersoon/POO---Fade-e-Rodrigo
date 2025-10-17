package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa uma portaria, que é um tipo de norma. A portaria é um ato
 * administrativo de caráter individual ou grupal, que visa disciplinar o
 * funcionamento da administração e a conduta de seus agentes.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Portaria extends Norma {

    private int anoInicio;

    /**
     * Construtor da classe Portaria.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param numero O número da norma.
     * @param valido Indica se a norma está em vigor.
     * @param texto O conteúdo textual da norma.
     * @param anoInicio O ano de início da vigência da portaria.
     */
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    /**
     * Retorna o ano de início da vigência da portaria.
     *
     * @return o ano de início.
     */
    public int getAnoInicio() {
        return anoInicio;
    }

    /**
     * Compara este objeto Portaria com outro objeto para verificar se são
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

        Portaria portaria = (Portaria) o;
        if (portaria.anoInicio == this.anoInicio) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Portaria.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
