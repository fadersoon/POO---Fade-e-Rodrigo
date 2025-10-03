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
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }
    
}
