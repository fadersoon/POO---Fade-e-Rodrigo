package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/*
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Certificado extends Registro {
    private String descricao;

    public Certificado(String estudante, long matricula, long autenticacao,
                       String criador, CodigoCurso codigoCurso, int paginas, String descricao) {
        super(autenticacao, criador, codigoCurso, paginas, estudante, matricula);
        this.descricao = descricao;
    }

    public Certificado() {
        super();
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        Certificado certificado = (Certificado) o;
        if (!super.equals(certificado))
            return false;

        if (certificado.descricao.equals(this.descricao))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao);
    }
}