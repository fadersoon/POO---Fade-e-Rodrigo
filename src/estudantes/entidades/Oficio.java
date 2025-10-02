package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Oficio extends Deliberacao {
    private String destinatario;
    
    public Oficio(String destinatario, String texto, String criador, CodigoCurso codigoCurso, int paginas){
        super(texto, criador, codigoCurso, paginas);
        this.destinatario = destinatario;
    }

    public Oficio(){
        super();
    }
     
     public void getters(){
     }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }


}
