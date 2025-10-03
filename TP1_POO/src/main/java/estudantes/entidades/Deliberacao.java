package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Deliberacao extends DocumentoAdministrativo {
    private String texto;
    
     public Deliberacao(String texto, String criador, CodigoCurso codigoCurso, int paginas){
         super(criador, codigoCurso, paginas);
         this.texto = texto;
    }

    public Deliberacao(){
         super();
    }
     
     public String getTexto(){
         return texto;
     }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
