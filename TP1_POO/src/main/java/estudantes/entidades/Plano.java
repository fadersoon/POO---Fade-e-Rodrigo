package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Representa um plano, que é um tipo de documento acadêmico. Descreve o
 * planejamento de atividades, como um plano de ensino ou de trabalho.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Plano extends DocumentoAcademico {

    private String responsavel;
    private String[] planejamento;

    /**
     * Construtor da classe Plano.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param autenticacao O código de autenticação do documento.
     * @param responsavel O nome do responsável pelo plano.
     * @param planejamento Um array de strings descrevendo as etapas do
     * planejamento.
     */
    public Plano(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }

    /**
     * Retorna o nome do responsável pelo plano.
     *
     * @return o nome do responsável.
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * Retorna as etapas do planejamento.
     *
     * @return um array de strings com o planejamento.
     */
    public String[] getPlanejamento() {
        return planejamento;
    }

    /**
     * Compara este objeto Plano com outro objeto para verificar se são iguais.
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

        Plano plano = (Plano) o;
        if (plano.responsavel.equals(this.responsavel) && Arrays.equals(this.planejamento, plano.planejamento)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Plano.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode(), responsavel);
        hash = 31 * hash + Arrays.hashCode(planejamento);
        return hash;
    }
}
