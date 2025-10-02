package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Atestado extends Registro {
    private String descricao;
    private String categoria;
    
     public Atestado(String descricao, String categoria, String estudante,
                     long matricula, long autenticacao, String criador, CodigoCurso codigoCurso, int paginas){
         super(estudante, matricula, autenticacao, criador, codigoCurso, paginas);
         this.descricao = descricao;
         this.categoria = categoria;
    }
    public Atestado(){
         super();
    }
    
    public void getters(){
    }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
