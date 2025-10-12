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

    public Historico(String criador, CodigoCurso codigoCurso, int paginas, long matricula, String estudante,  long autenticacao,
                     double coeficiente, String[] componentes) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
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

        if  (!super.equals(o))
            return false;

        Historico historico = (Historico) o;
        if (historico.coeficiente ==  this.coeficiente && Arrays.equals(this.componentes, historico.componentes))
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