package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/**
 * Representa o histórico escolar de um estudante, que é um tipo de registro.
 * Contém o coeficiente de rendimento e a lista de componentes curriculares
 * cursados.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Historico extends Registro {

    private double coeficiente;
    private String[] componentes;

    /**
     * Construtor da classe Historico.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param matricula A matrícula do estudante.
     * @param estudante O nome do estudante.
     * @param autenticacao O código de autenticação do registro.
     * @param coeficiente O coeficiente de rendimento do estudante.
     * @param componentes Um array com os nomes dos componentes curriculares
     * cursados.
     */
    public Historico(String criador, CodigoCurso codigoCurso, int paginas, long matricula, String estudante, long autenticacao,
            double coeficiente, String[] componentes) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    /**
     * Retorna o coeficiente de rendimento do estudante.
     *
     * @return o coeficiente de rendimento.
     */
    public double getCoeficiente() {
        return coeficiente;
    }

    /**
     * Retorna a lista de componentes curriculares cursados.
     *
     * @return um array de strings com os nomes dos componentes.
     */
    public String[] getComponentes() {
        return componentes;
    }

    /**
     * Compara este objeto Historico com outro objeto para verificar se são
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

        Historico historico = (Historico) o;
        if (historico.coeficiente == this.coeficiente && Arrays.equals(this.componentes, historico.componentes)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Historico.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode(), coeficiente);
        hash = hash * 31 + Arrays.hashCode(componentes);
        return hash;
    }
}
