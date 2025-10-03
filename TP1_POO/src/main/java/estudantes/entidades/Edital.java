package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Edital extends Norma {
    private String[] responsaveis;

    public Edital(int numero, boolean valido, String texto, String criador, CodigoCurso codigoCurso, int paginas, String[] responsaveis) {
        super(numero, valido, texto, criador, codigoCurso, paginas);
        this.responsaveis = responsaveis;
    }

    public Edital() {
        super();
    }

    public String[] getResponsaveis() {
        return responsaveis;
    }

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }

}
