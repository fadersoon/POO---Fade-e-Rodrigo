package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Circular extends Deliberacao {
    private String[] destinatarios;

    public Circular(String texto, String criador, CodigoCurso codigoCurso, int paginas, String[] destinatarios) {
        super(texto, criador, codigoCurso, paginas);
        this.destinatarios = destinatarios;
    }

    public Circular() {
        super();
    }

    public String[] getDestinatarios() {
        return destinatarios;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
    }

}
