package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class DocumentoAcademico extends Documento {
    private long autenticacao;
    
    public DocumentoAcademico(long autenticacao, String criador, CodigoCurso codigoCurso, int paginas){
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }

    public DocumentoAcademico(){
        super();
    }
    
    public long getAutenticacao(){
        return autenticacao;
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
        if (this.autenticacao==documentoAcademico.autenticacao ) {
            return true;
        }
        return false;
    }
    
    public int hashCode(){
    }
    
}
