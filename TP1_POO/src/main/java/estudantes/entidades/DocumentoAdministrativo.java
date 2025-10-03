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
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
