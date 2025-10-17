package estudantes.entidades;

import professor.entidades.CodigoCurso;

import java.util.Objects;

/**
 * Representa um documento administrativo, uma especialização da classe
 * Documento. Esta classe serve como base para documentos que não possuem um
 * caráter acadêmico e não necessitam de um código de autenticação.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class DocumentoAdministrativo extends Documento {

    /**
     * Construtor da classe DocumentoAdministrativo.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     */
    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas) {
        super(criador, codigoCurso, paginas);
    }

    /**
     * Compara este objeto DocumentoAdministrativo com outro objeto para
     * verificar se são iguais. A comparação é feita com base nos atributos
     * herdados da classe Documento.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
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
        if (!super.equals(o)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna o código de hash para este objeto DocumentoAdministrativo.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
