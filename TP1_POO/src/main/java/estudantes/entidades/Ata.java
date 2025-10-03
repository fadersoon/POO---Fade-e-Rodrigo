
package estudantes.entidades;

import java.util.Arrays;
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
    
    public int getNumero(){
        return numero;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public String[] getPresentes(){
        return presentes;
    }
    
    @Override
       public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        if(!super.equals(o)){
            return false;
        }
        Ata ata = (Ata) o;
        if (this.numero==ata.numero && this.texto.equals(ata.texto) && Arrays.equals(this.presentes,ata.presentes) ) {
            return true;
        }
        return false;
    }
    
    public int hashCode(){
    }
    

}
