package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Plano extends DocumentoAcademico {
    private String responsavel;
    private String[] planejamento;
    
     public Plano(String responsavel, String[] planejamento, long autenticacao, String criador, CodigoCurso codigoCurso, int paginas){
         super(autenticacao,criador,codigoCurso,paginas);
         this.responsavel=responsavel;
         this.planejamento=planejamento;
    }

    public Plano(){
         super();
    }
    
    public void getters(){
    }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
