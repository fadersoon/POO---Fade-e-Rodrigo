package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;

    public Historico(String estudante, long matricula, long autenticacao, String criador,
                     CodigoCurso codigoCurso, int paginas, double coeficiente, String[] componentes) {
        super(estudante, matricula, autenticacao, criador, codigoCurso, paginas);
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

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }

}
