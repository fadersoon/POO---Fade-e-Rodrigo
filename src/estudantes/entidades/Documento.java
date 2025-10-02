package estudantes.entidades;

import professor.entidades.CodigoCurso;

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

    public Documento(){
    }
    
    public void getters(){
    }
    
   public boolean equals(Object o){
   }
   
   public int hashCode(){
   }
}
