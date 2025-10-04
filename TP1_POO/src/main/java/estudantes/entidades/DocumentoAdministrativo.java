package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class DocumentoAdministrativo extends Documento {

    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas) {
        super(criador, codigoCurso, paginas);
    }

    public DocumentoAdministrativo() {
        super();
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
        DocumentoAcademico documentoAcademico = (DocumentoAcademico) o;
        if (!super.equals(documentoAcademico)) {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}