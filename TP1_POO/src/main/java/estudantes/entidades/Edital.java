package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/**
 * Representa um edital, que é um tipo de norma. O edital é um ato
 * administrativo que torna pública uma decisão, convocação, ou procedimento
 * para conhecimento geral.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Edital extends Norma {

    private String[] responsaveis;

    /**
     * Construtor da classe Edital.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param numero O número da norma.
     * @param valido Indica se a norma está válida ou não.
     * @param texto O conteúdo textual da norma.
     * @param responsaveis Um array com os nomes dos responsáveis pelo edital.
     */
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    /**
     * Retorna a lista de responsáveis pelo edital.
     *
     * @return um array de strings com os nomes dos responsáveis.
     */
    public String[] getResponsaveis() {
        return responsaveis;
    }

    /**
     * Compara este objeto Edital com outro objeto para verificar se são iguais.
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

        Edital edital = (Edital) o;
        if (Arrays.equals(this.responsaveis, edital.responsaveis)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Edital.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode());
        hash = hash * 31 + Arrays.hashCode(responsaveis);
        return hash;
    }
}
