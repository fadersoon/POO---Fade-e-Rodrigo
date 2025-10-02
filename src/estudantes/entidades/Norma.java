package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Norma extends DocumentoAdministrativo {
    private int numero;
    private boolean valido;
    private String texto;
    
     public Norma(int numero, boolean valido, String texto, String criador, CodigoCurso codigoCurso, int paginas) {
         super(criador, codigoCurso, paginas);
         this.numero = numero;
         this.valido = valido;
         this.texto = texto;
    }

    public Norma(){
         super();
    }
     
     public void getters(){
     }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
