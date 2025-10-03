package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Oficio extends Deliberacao {
    private String destinatario;

    public Oficio(String texto, String criador, CodigoCurso codigoCurso, int paginas, String destinatario) {
        super(texto, criador, codigoCurso, paginas);
        this.destinatario = destinatario;
    }

    public Oficio() {
        super();
    }

    public String getDestinatario() {
        return destinatario;
    }

    public boolean equals(Object o) {
    }

    public int hashCode() {
    }


}
