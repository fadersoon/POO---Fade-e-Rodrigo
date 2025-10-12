package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * Classe que representa um documento genérico.
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public abstract class Documento {

    private String criador;
    private CodigoCurso codigoCurso;
    private int paginas;

    public Documento(String criador, CodigoCurso codigoCurso, int paginas) {
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }


    public String getCriador() {
        return criador;
    }

    public CodigoCurso getCodigoCurso() {
        return codigoCurso;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Documento documento = (Documento) o;
        if (documento.criador.equals(this.criador) && documento.codigoCurso.equals(this.codigoCurso) && this.paginas == documento.paginas) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(criador, codigoCurso, paginas);
    }
}