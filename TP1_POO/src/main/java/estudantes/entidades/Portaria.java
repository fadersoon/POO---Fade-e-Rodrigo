package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Portaria extends Norma {
    private int anoInicio;
    
     public Portaria(int anoInicio, int numero, boolean valido, String texto, String criador, CodigoCurso codigoCurso, int paginas){
         super(numero, valido, texto, criador, codigoCurso, paginas);
         this.anoInicio = anoInicio;
    }

    public Portaria(){
         super();
    }
     
     public int getAnoInicio(){
         return anoInicio;
     }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }


}
