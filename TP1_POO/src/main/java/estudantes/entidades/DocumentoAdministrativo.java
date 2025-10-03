package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class DocumentoAdministrativo extends Documento {
    
    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas){
        super(criador, codigoCurso, paginas);
    }

    public DocumentoAdministrativo(){
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
        if(!super.equals(o)){
            return false;
        }
        DocumentoAcademico documentoAcademico = (DocumentoAcademico) o;
        return false;
    }
    
    public int hashCode(){
    }

}
