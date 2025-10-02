
package estudantes.entidades;

import professor.entidades.CodigoCurso;

/*
* @author Rodrigo Thoma da Silva
* @author Fade Hassan Husein Kanaan
 */
public class Ata extends Documento {
    private int numero;
    private String texto;
    private String[] presentes;
    
    public Ata(int numero, String texto, String[] presentes, String criador, CodigoCurso codigoCurso, int paginas) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }
    public Ata() {
    }
    
    public void getters(){
    }
    
    public boolean equals(Object o){
    }
    
    public int hashCode(){
    }
    

}
