package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Arrays;
import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;

    public Historico(String estudante, long matricula, long autenticacao, String criador,
                     CodigoCurso codigoCurso, int paginas, double coeficiente, String[] componentes) {
        super(autenticacao, criador, codigoCurso, paginas, estudante, matricula);
        this.coeficiente = coeficiente;
    }

    public Historico() {
        super();
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public String[] getComponentes() {
        return componentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Historico historico = (Historico) o;
        if (historico.coeficiente == this.coeficiente && Arrays.equals(historico.componentes, this.componentes) && historico.getAutenticacao() == this.getAutenticacao()
            && historico.getCriador().equals(this.getCriador()) && historico.getCodigoCurso().equals(this.getCodigoCurso()) && historico.getPaginas() == this.getPaginas()
            && historico.getEstudante().equals(this.getEstudante()) && historico.getMatricula() == this.getMatricula())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode(), coeficiente);
        hash = hash * 31 + Arrays.hashCode(componentes);
        return hash;
    }
}