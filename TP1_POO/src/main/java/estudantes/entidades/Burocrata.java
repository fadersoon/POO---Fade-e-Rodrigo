    package estudantes.entidades;

    import professor.entidades.*;

    import java.sql.Array;
    import java.util.ArrayList;
    import java.util.List;

    /**
     * Classe que traz a lógica do algoritmo de organização e despacho de processos.
     * <br><br>
     * Você pode incluir novos atributos e métodos nessa classe para criar lógicas
     * mais complexas para o gerenciamento da organização e despacho de processos,
     * mas esses <strong>atributos e métodos devem ser todos privados</strong> e
     * eles não serão invocados diretamente pelo simulador.
     * <br><br>
     * Os únicos métodos públicos devem ser: getEstresse, trabalhar, estressar e
     * estressarMuito.
     *
     * @author Rodrigo Thoma da Silva
     * @author Fade Hassan Husein Kanaan
     */
    public class Burocrata {

        private int estresse = 0;
        private Mesa mesa;
        private Universidade universidade;

        /**
         * Construtor de Burocrata.
         *
         * @param m mesa com os processos
         * @param u universidade com os montes dos cursos e a secretaria
         */
        public Burocrata(Mesa m, Universidade u) {
            this.mesa = m;
            this.universidade = u;
        }

        /**
         * Executa a lógica de criação e despacho dos processos.
         * <br><br>
         * Esse método é o único método de controle invocado durante a simulação da
         * universidade.
         * <br><br>
         * Aqui podem ser feitas todas as verificações sobre os documentos nos
         * montes dos cursos e dos processos abertos na mesa do Burocrata. A partir
         * dessas informações, você pode colocar documentos nos processos abertos e
         * despachar os processos para a secretaria acadêmica.
         * <br><br>
         * Cuidado com a complexidade do seu algoritmo, porque se ele demorar muito
         * serão criados menos documentos na sua execução e sua produtividade geral
         * vai cair.
         * <br><br>
         * Esse método será chamado a cada 100 milissegundos pelo simulador da
         * universidade.
         * <br><br>
         * <strong>O burocrata não pode manter documentos com ele</strong> depois
         * que o método trabalhar terminar de executar, ou seja, você deve devolver
         * para os montes dos cursos todos os documentos que você removeu dos montes
         * dos cursos.
         *
         * @see professor.entidades.Universidade#despachar(Processo)
         * @see
         * professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(Documento,
         * professor.entidades.CodigoCurso)
         * @see
         * professor.entidades.Universidade#devolverDocumentoParaMonteDoCurso(Documento,
         * professor.entidades.CodigoCurso)
         */
        public void trabalhar() {
            List<Documento> todosDocumentos = new ArrayList<Documento>();

            for (CodigoCurso cursos : CodigoCurso.values()) {
                for (Documento documento : universidade.pegarCopiaDoMonteDoCurso(cursos)) {
                    if (universidade.removerDocumentoDoMonteDoCurso(documento, cursos)) {
                        todosDocumentos.add(documento);
                    }
                }
            }

                List<Documento> documentosLivres = new ArrayList<>();

            Documento[] docCC = universidade.pegarCopiaDoMonteDoCurso(CodigoCurso.GRADUACAO_CIENCIA_DA_COMPUTACAO);

                universidade.devolverDocumentoParaMonteDoCurso(todosDocumentos.getFirst(), CodigoCurso.GRADUACAO_CIENCIA_DA_COMPUTACAO);
        }

        public boolean verificacaoSecretariaDoc (Documento doc, Processo proc){

            // Limite de 250 páginas
            if ((contarPaginasProcesso(proc) + doc.getPaginas()) > 250)
                return false;

            // Processo vazio
            Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();
            if (documentosNoProcesso.length == 0)
                return true;

            // Verificações da secretária

            // Processo de graduação  !=  Pós - regra 1
            boolean documentoGraduacao = cursoGraduacao(doc.getCodigoCurso());
            boolean processoGraduacao = cursoGraduacao(documentosNoProcesso[0].getCodigoCurso());
            if (documentoGraduacao != processoGraduacao)
                return false;

            if (!(doc instanceof Ata)){
                boolean documentoAdmin = doc instanceof DocumentoAdministrativo;
                boolean documentoAcad = doc instanceof DocumentoAcademico;

                for (Documento documento : documentosNoProcesso) {
                    if (!(documento instanceof Ata)){
                        if ((documentoAdmin && documento instanceof DocumentoAcademico) || (documentoAcad && documento instanceof DocumentoAdministrativo))
                            return false;
                    }
                }
            }

            // Verificação do diploma - regra 6
            boolean processoTemDiploma = false;
            for (Documento documento : documentosNoProcesso) {
                if (documento instanceof Diploma){
                    processoTemDiploma = true;
                    break;
                }
            }

            if (processoTemDiploma){
                if (!(doc instanceof Diploma || doc instanceof Ata || doc instanceof Certificado))
                    return false;
            }

            if (doc instanceof Diploma) {
                for (Documento documento : documentosNoProcesso) {
                    if (!(documento instanceof Diploma || documento instanceof Certificado || documento instanceof Ata))
                        return false;
                }
            }

            // Verificação da categoria do atestado - regra 7
            if (doc instanceof Atestado){
                for (Documento documento : documentosNoProcesso) {
                    if (documento instanceof Atestado){
                        Atestado docAtual = (Atestado) doc;
                        Atestado atestado = (Atestado) documento;

                        if (!(docAtual.getCategoria().equals(atestado.getCategoria())))
                            return false;
                    }
                }
            }


            return true;
        }


        // Metodo igual da classe Processo
        private int contarPaginasProcesso(Processo proc) {
            int paginas = 0;
            for (Documento documento : proc.pegarCopiaDoProcesso()) {
                paginas += documento.getPaginas();
            }
            return paginas;
        }

        // Metodo pra verificar o prefixo do curso, pra saber se ele é de graduação ou não
        public boolean cursoGraduacao (CodigoCurso curso){
            return curso.name().startsWith("GRADUACAO");
        }

        public int estressar() {
            return estresse++;
        }

        public int getEstresse() {
            return estresse;
        }

        public int estressarMuito() {
            return estresse += 10;
        }
    }