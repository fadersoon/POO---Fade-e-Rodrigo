    package estudantes.entidades;

    import professor.entidades.*;

    import java.sql.Array;
    import java.util.ArrayList;
    import java.util.Arrays;
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
        private final int LimiteProcessoGrad = 3; // Processos 0,1 e 2 para documentos de graduacao. Processos 3 e 4 para doc de pós.

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
            Processo[] processosDaMesa = mesa.getProcessos();
            int intervaloDoc;
            int fimIntervaloDoc;

            for (CodigoCurso curso : CodigoCurso.values()) {
                boolean docGrad = cursoGraduacao(curso);

                for (Documento doc : universidade.pegarCopiaDoMonteDoCurso(curso)) {
                    // Define o intervalo dos processos de graduacao e pós
                    if (docGrad){
                        intervaloDoc = 0;
                        fimIntervaloDoc = 3;
                    } else {
                        intervaloDoc = 3;
                        fimIntervaloDoc = 5;
                    }

                    for (int i = intervaloDoc; i < fimIntervaloDoc; i++) {
                        Processo proc = processosDaMesa[i];

                        if (proc != null && verificacaoSecretariaDoc(doc, proc)) {
                            if (universidade.removerDocumentoDoMonteDoCurso(doc, curso)) {
                                proc.adicionarDocumento(doc);
                                break; // Documento alocado, vai para o proximo da lista
                            }
                        }
                    }
                }
            }

            // Despachar processos validos, com preferencia nos com mais de 200 paginas ou que cumpra a regra de portaria ou edital
            for (Processo proc : mesa.getProcessos()){
                if ((proc != null) && (proc.pegarCopiaDoProcesso().length > 0)) {
                    boolean processoQuaseCheio = contarPaginasProcesso(proc) > 200;

                    boolean portariaOuEdital = false;
                    Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();

                    if (documentosNoProcesso.length == 1 && documentosNoProcesso[0] instanceof Norma) {
                        Norma norma = (Norma) documentosNoProcesso[0];
                        if (norma.getPaginas() >= 100 && norma.getValido()) {
                            portariaOuEdital = true;
                        }
                    }

                    if (processoQuaseCheio || portariaOuEdital) {
                        if(processoValidoParaDespacho(proc))
                            universidade.despachar(proc);
                    }
                }
            }
        }

        public boolean verificacaoSecretariaDoc (Documento doc, Processo proc) {

            // Limite de 250 páginas
            if ((contarPaginasProcesso(proc) + doc.getPaginas()) > 250)
                return false;

            // Processo vazio
            Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();
            if (documentosNoProcesso.length == 0)
                return true;

            // Verificações da secretária
            // Processo de graduação  !=  pós - regra 1
            boolean documentoGraduacao = cursoGraduacao(doc.getCodigoCurso());
            boolean processoGraduacao = cursoGraduacao(documentosNoProcesso[0].getCodigoCurso());
            if (documentoGraduacao != processoGraduacao)
                return false;

            if (!(doc instanceof Ata)) {
                boolean documentoAdmin = doc instanceof DocumentoAdministrativo;
                boolean documentoAcad = doc instanceof DocumentoAcademico;

                for (Documento documento : documentosNoProcesso) {
                    if (!(documento instanceof Ata)) {
                        if ((documentoAdmin && documento instanceof DocumentoAcademico) || (documentoAcad && documento instanceof DocumentoAdministrativo))
                            return false;
                    }
                }
            }

            // Verificação do diploma - regra 6
            boolean processoTemDiploma = false;
            for (Documento documento : documentosNoProcesso) {
                if (documento instanceof Diploma) {
                    processoTemDiploma = true;
                    break;
                }
            }

            if (processoTemDiploma) {
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
            if (doc instanceof Atestado) {
                for (Documento documento : documentosNoProcesso) {
                    if (documento instanceof Atestado) {
                        Atestado docAtual = (Atestado) doc;
                        Atestado atestado = (Atestado) documento;

                        if (!(docAtual.getCategoria().equals(atestado.getCategoria())))
                            return false;
                    }
                }
            }

            // Verificacao de destinatario em comum entre oficios ou circulares - regra 5
            boolean docOficioOuCircular = doc instanceof Oficio || doc instanceof Circular;
            boolean processoTemOficioOuCircular = false;

            for (Documento documento : documentosNoProcesso) {
                if (documento instanceof Circular || documento instanceof Oficio) {
                    processoTemOficioOuCircular = true;
                    break;
                }
            }

            if (docOficioOuCircular && processoTemOficioOuCircular) {
                List<String> destinatarios = new ArrayList<>();
                if (doc instanceof Oficio){
                Oficio docAtual = (Oficio) doc;
                destinatarios.add(docAtual.getDestinatario());
                } else {
                Circular docAtual = (Circular) doc;
                destinatarios.addAll(Arrays.asList(docAtual.getDestinatarios()));
            }

                /* começo do código gerado por IA */
                for (Documento d : documentosNoProcesso) {
                    if (d instanceof Oficio) {
                        Oficio oficioNoProcesso = (Oficio) d;
                        destinatarios.retainAll(List.of(oficioNoProcesso.getDestinatario()));
                    } else if (d instanceof Circular) {
                        Circular circularNoProcesso = (Circular) d;
                        destinatarios.retainAll(Arrays.asList(circularNoProcesso.getDestinatarios()));
                    }
                }
                /* fim do código gerado por IA */

                if (destinatarios.isEmpty()) {
                    return false;
                }
            }


            // Verificacao de se for portaria ou edital com mais de 100 páginas e valido, deve ser despachado sozinho - regra 4
            if (doc instanceof Norma){
                Norma norma =  (Norma) doc;
                if (norma.getPaginas() >= 100 && norma.getValido()){
                    if (documentosNoProcesso.length > 0){
                        return false;
                    }
                }
            }

            // Se já tiver uma portaria ou edital com mais de 100 páginas e valido no processo, não tem o que ser feito
            for (Documento documento : documentosNoProcesso) {
                if (documento instanceof Norma) {
                    Norma norma = (Norma) documento;
                    if (norma.getPaginas() >= 100 && norma.getValido()) {
                        return false;
                    }
                }
            }

            return true;
        }

        public boolean processoValidoParaDespacho (Processo proc){
            Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();

            // Não pode ser despachado vazio
            if (documentosNoProcesso.length == 0)
                return false;

            // Não pode ser despachado só com atas - regra 3
            boolean apenasAtas = true;
            for (Documento documento : documentosNoProcesso){
                if (!(documento instanceof Ata)){
                    apenasAtas = false;
                    break;
                }
            }
            if (apenasAtas){
                return false;
            }

            return true;
        }


        // Metodo igual da classe Processo
        public int contarPaginasProcesso(Processo proc) {
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

        public void estressar() {
            estresse++;
        }

        public int getEstresse() {
            return estresse;
        }

        public void estressarMuito() {
            estresse += 10;
        }
    }