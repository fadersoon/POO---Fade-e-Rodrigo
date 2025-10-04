package estudantes.entidades;
import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Plano extends DocumentoAcademico {
    private String responsavel;
    private String[] planejamento;

    public Plano(String criador, CodigoCurso codigoCurso,  int paginas, long autenticacao, String responsavel, String[] planejamento) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }

    public Plano() {
        super();
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String[] getPlanejamento() {
        return planejamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Plano plano = (Plano) o;
        if (plano.responsavel.equals(this.responsavel) && Arrays.equals(plano.planejamento, this.planejamento) && plano.getCriador().equals(this.getCriador())
        && plano.getCodigoCurso().equals(this.getCodigoCurso()) && plano.getPaginas() == this.getPaginas() && plano.getAutenticacao() == this.getAutenticacao())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode(), responsavel);
        hash = 31 * hash + Arrays.hashCode(planejamento);
        return hash;
    }
}