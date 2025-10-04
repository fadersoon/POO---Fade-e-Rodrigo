package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Portaria extends Norma {
    private int anoInicio;

    public Portaria(int numero, boolean valido, String texto, String criador, CodigoCurso codigoCurso, int paginas, int anoInicio) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    public Portaria() {
        super();
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Portaria portaria = (Portaria) o;
        if (portaria.anoInicio == this.anoInicio && portaria.getCriador().equals(this.getCriador()) && portaria.getCodigoCurso().equals(this.getCodigoCurso())
                && portaria.getPaginas() == this.getPaginas() && portaria.getNumero() == this.getNumero() &&  portaria.getValido() == this.getValido()
                && portaria.getTexto().equals(this.getTexto()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
