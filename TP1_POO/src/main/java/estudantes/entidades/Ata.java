package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

/**
 * Representa a ata de uma reunião ou evento.
 * Uma ata é um tipo de documento que registra ocorrências e decisões.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Ata extends Documento {

    private int numero;
    private String texto;
    private String[] presentes;

    /**
     * Construtor da classe Ata.
     *
     * @param criador O nome do criador do documento.
     * @param codigoCurso O código do curso associado ao documento.
     * @param paginas O número de páginas do documento.
     * @param numero O número da ata.
     * @param texto O conteúdo textual da ata.
     * @param presentes Um array com os nomes dos presentes na reunião/evento.
     */
    public Ata(String criador, CodigoCurso codigoCurso, int paginas, int numero, String texto, String[] presentes) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }
    
    /**
     * Retorna o número da ata.
     *
     * @return o número da ata.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o texto da ata.
     *
     * @return o conteúdo da ata.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Retorna a lista de presentes.
     *
     * @return um array de strings com os nomes dos presentes.
     */
    public String[] getPresentes() {
        return presentes;
    }
    
    /**
     * Compara este objeto Ata com outro objeto para verificar se são iguais.
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
        Ata ata = (Ata) o;
        if (this.numero == ata.numero && this.texto.equals(ata.texto) && Arrays.equals(this.presentes, ata.presentes)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o código de hash para este objeto Ata.
     *
     * @return o código de hash.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(super.hashCode(), numero, texto);
        hash = 31 * hash + Arrays.hashCode(presentes);
        return hash;
    }
}
