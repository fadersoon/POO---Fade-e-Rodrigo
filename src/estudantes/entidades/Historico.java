package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;
    
    public Historico(double coeficiente, String[] componentes, String estudante,
                     long matricula, long autenticacao, String criador, CodigoCurso codigoCurso, int paginas) {
        super(estudante, matricula, autenticacao, criador, codigoCurso, paginas);
        this.coeficiente = coeficiente;
    }

    public Historico(){
        super();
    }
    
    public void getters(){
    }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }

}
