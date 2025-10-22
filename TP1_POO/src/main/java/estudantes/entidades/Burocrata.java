package estudantes.entidades;

import professor.entidades.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa o Burocrata, a entidade central da simulação, responsável por
 * gerenciar e despachar processos.
 * <br><br>
 * Esta classe contém toda a lógica para pegar documentos dos montes de cursos,
 * organizá-los em processos válidos na mesa, e enviá-los à secretaria, seguindo
 * todas as regras de negócio e tentando minimizar o estresse.
 *
 * @author Rodrigo Thoma da Silva
 * @author Fade Hassan Husein Kanaan
 */
public class Burocrata {

    /**
     * Armazena o nível de estresse atual do burocrata. O estresse aumenta
     * quando regras administrativas são violadas no despacho.
     */
    private int estresse = 0;

    /**
     * A mesa de trabalho do burocrata, que contém os 5 processos abertos onde
     * os documentos são organizados.
     */
    private Mesa mesa;

    /**
     * Referência à universidade, usada para acessar os montes de documentos dos
     * cursos e para interagir com a secretaria (despachar processos).
     */
    private Universidade universidade;

    /**
     * Define o índice que separa os processos de graduação e pós-graduação na
     * mesa. Processos com índice de 0 a (LimiteProcessoGrad - 1) são designados
     * para Graduação. Processos com índice a partir de LimiteProcessoGrad até o
     * fim são para Pós-Graduação.
     */
    private final int LimiteProcessoGrad = 3;

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
     * Este método é invocado ciclicamente (a cada 100ms) pelo simulador. Ele
     * varre todos os cursos, tenta alocar os documentos dos montes em processos
     * válidos na mesa (respeitando a separação Grad/Pós) e, ao final, despacha
     * os processos que considera prontos.
     * <br><br>
     * A estratégia de despacho prioriza processos "quase cheios" (mais de 200
     * páginas) ou processos que contenham documentos "substanciais" (Regra 4)
     * que devem ir sozinhos.
     * <br><br>
     * O burocrata <strong>não retém documentos</strong>; qualquer documento
     * pego de um monte deve ser alocado em um processo. Se não for alocado, ele
     * permanece no monte (a implementação não o remove se não encontrar um
     * local).
     *
     * @see professor.entidades.Universidade#despachar(Processo)
     * @see
     * professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(Documento,
     * professor.entidades.CodigoCurso)
     */
    public void trabalhar() {
        Processo[] processosDaMesa = mesa.getProcessos();
        int intervaloDoc;
        int fimIntervaloDoc;

        // 1. Fase de Alocação: Tenta alocar documentos dos montes nos processos
        for (CodigoCurso curso : CodigoCurso.values()) {
            boolean docGrad = cursoGraduacao(curso);

            for (Documento doc : universidade.pegarCopiaDoMonteDoCurso(curso)) {
                // Define o intervalo de processos (Grad ou Pós) baseado no curso do documento          
                if (docGrad) {
                    intervaloDoc = 0;
                    fimIntervaloDoc = 3;
                } else {
                    intervaloDoc = 3;
                    fimIntervaloDoc = 5;
                }

                // Tenta alocar o 'doc' em um processo válido dentro do intervalo
                for (int i = intervaloDoc; i < fimIntervaloDoc; i++) {
                    Processo proc = processosDaMesa[i];

                    // Se o processo existe e o documento passa na verificação das regras
                    if (proc != null && verificacaoSecretariaDoc(doc, proc)) {
                        if (universidade.removerDocumentoDoMonteDoCurso(doc, curso)) {
                            proc.adicionarDocumento(doc);
                            break; // Documento alocado, vai para o proximo documento
                        }
                    }
                }
            }
        }

        // 2. Fase de Despacho: Verifica processos na mesa para despacho
        for (Processo proc : mesa.getProcessos()) {
            if ((proc != null) && (proc.pegarCopiaDoProcesso().length > 0)) {
                boolean processoQuaseCheio = contarPaginasProcesso(proc) > 245;

                // Verifica Regra 4 (Portaria/Edital substancial)
                boolean portariaOuEdital = false;
                Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();

                if (documentosNoProcesso.length == 1 && documentosNoProcesso[0] instanceof Norma) {
                    Norma norma = (Norma) documentosNoProcesso[0];
                    if (norma.getPaginas() >= 100 && norma.getValido()) {
                        portariaOuEdital = true;
                    }
                }

                // Despacha se estiver quase cheio ou se for um doc substancial sozinho
                if (processoQuaseCheio || portariaOuEdital) {
                    if (processoValidoParaDespacho(proc)) {
                        universidade.despachar(proc);
                    }
                }
            }
        }
    }

    /**
     * Verifica se um documento pode ser legalmente adicionado a um processo.
     * <br>
     * Este método simula as regras da {@link Secretaria} para evitar que o
     * burocrata se estresse ao despachar.
     *
     * Regras validadas:
     * <ul>
     * <li><b>Limite de 250 páginas</b>: Não adiciona se estourar o limite.
     * <li><b>Regra 1 (Grad/Pós)</b>: Não mistura documentos de graduação com
     * pós-graduação.
     * <li><b>Regra 2 (Admin/Acad)</b>: Não mistura Documentos Administrativos
     * com Acadêmicos (exceto Atas).
     * <li><b>Regra 6 (Diploma)</b>: Se o processo tem Diplomas, só aceita
     * outros Diplomas, Certificados ou Atas. Se o documento é um Diploma, só
     * entra se o processo SÓ tiver Diplomas, Certificados ou Atas.
     * <li><b>Regra 7 (Atestado)</b>: Não mistura Atestados de categorias
     * diferentes.
     * <li><b>Regra 5 (Ofício/Circular)</b>: Se ambos (documento e processo)
     * contêm Ofícios/Circulares, valida se há um destinatário em comum.
     * <li><b>Regra 4 (Doc. Substancial)</b>: Não adiciona se o documento for
     * uma Norma/Edital válido e com 100+ páginas (pois ele deve ir sozinho).
     * Também não adiciona nada a um processo que já contenha tal documento.
     * </ul>
     *
     * @param doc O documento a ser adicionado.
     * @param proc O processo de destino.
     * @return true se o documento pode ser adicionado, false caso contrário.
     */
    private boolean verificacaoSecretariaDoc(Documento doc, Processo proc) {

        // Limite de 250 páginas
        if ((contarPaginasProcesso(proc) + doc.getPaginas()) > 250) {
            return false;
        }

        Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();

        // Se o processo está vazio, o documento pode entrar (Regra 4 é tratada abaixo)
        if (documentosNoProcesso.length == 0) // Se o doc for Norma/Edital > 100p, ele entra (e vai ficar sozinho).
        // Se não for, ele entra e outros poderão entrar depois.
        {
            return true;
        }

        // Regra 1: Processo de graduação  !=  pós
        boolean documentoGraduacao = cursoGraduacao(doc.getCodigoCurso());
        boolean processoGraduacao = cursoGraduacao(documentosNoProcesso[0].getCodigoCurso());
        if (documentoGraduacao != processoGraduacao) {
            return false;
        }

        // Regra 2: Admin x Acadêmico (Ata é exceção)   
        if (!(doc instanceof Ata)) {
            boolean documentoAdmin = doc instanceof DocumentoAdministrativo;
            boolean documentoAcad = doc instanceof DocumentoAcademico;

            for (Documento documento : documentosNoProcesso) {
                if (!(documento instanceof Ata)) {
                    if ((documentoAdmin && documento instanceof DocumentoAcademico) || (documentoAcad && documento instanceof DocumentoAdministrativo)) {
                        return false;
                    }
                }
            }
        }

        // Regra 6: Verificação do Diploma      
        boolean processoTemDiploma = false;
        for (Documento documento : documentosNoProcesso) {
            if (documento instanceof Diploma) {
                processoTemDiploma = true;
                break;
            }
        }

        if (processoTemDiploma) {
            // Se o processo já tem diploma, o novo doc só pode ser Diploma, Ata ou Certificado.
            if (!(doc instanceof Diploma || doc instanceof Ata || doc instanceof Certificado)) {
                return false;
            }
        }

        if (doc instanceof Diploma) {
            // Se o novo doc é um Diploma, o processo SÓ pode ter Diploma, Ata ou Certificado.
            for (Documento documento : documentosNoProcesso) {
                if (!(documento instanceof Diploma || documento instanceof Certificado || documento instanceof Ata)) {
                    return false;
                }
            }
        }

        // Regra 7: Verificação da categoria do Atestado
        if (doc instanceof Atestado) {
            for (Documento documento : documentosNoProcesso) {
                if (documento instanceof Atestado) {
                    Atestado docAtual = (Atestado) doc;
                    Atestado atestado = (Atestado) documento;

                    if (!(docAtual.getCategoria().equals(atestado.getCategoria()))) {
                        return false;
                    }
                }
            }
        }

        // Regra 5: Verificacao de destinatario em comum entre Oficios ou Circulares
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
            if (doc instanceof Oficio) {
                Oficio docAtual = (Oficio) doc;
                destinatarios.add(docAtual.getDestinatario());
            } else {
                Circular docAtual = (Circular) doc;
                destinatarios.addAll(Arrays.asList(docAtual.getDestinatarios()));
            }

            /* começo do código gerado por IA */
            // Filtra a lista de destinatários comuns
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

            // Se a lista de interseção está vazia, não há destinatário comum
            if (destinatarios.isEmpty()) {
                return false;
            }
        }

        // Regra 4: Portaria ou edital com mais de 100 páginas e valido
        if (doc instanceof Norma) {
            Norma norma = (Norma) doc;
            // Se o doc novo é substancial, ele não pode entrar (pois o processo não está vazio)
            if (norma.getPaginas() >= 100 && norma.getValido()) {
                if (documentosNoProcesso.length > 0) {
                    return false;
                }
            }
        }

        // Se o processo já tiver um doc substancial, ninguém mais entra
        for (Documento documento : documentosNoProcesso) {
            if (documento instanceof Norma) {
                Norma norma = (Norma) documento;
                if (norma.getPaginas() >= 100 && norma.getValido()) {
                    return false;
                }
            }
        }

        // Se passou por todas as regras, o documento é válido para este processo
        return true;
    }

    /**
     * Verifica se um processo está apto para ser despachado.
     * <br>
     * Um processo não pode ser despachado se estiver vazio ou se contiver
     * <strong>apenas</strong> Atas (Regra 3).
     *
     * @param proc O processo a ser verificado.
     * @return true se o processo pode ser despachado, false caso contrário.
     */
    private boolean processoValidoParaDespacho(Processo proc) {
        Documento[] documentosNoProcesso = proc.pegarCopiaDoProcesso();

        // Não pode ser despachado vazio
        if (documentosNoProcesso.length == 0) {
            return false;
        }

        // Regra 3: Não pode ser despachado só com atas
        boolean apenasAtas = true;
        for (Documento documento : documentosNoProcesso) {
            if (!(documento instanceof Ata)) {
                apenasAtas = false;
                break;
            }
        }
        if (apenasAtas) {
            return false;
        }

        return true;
    }

    /**
     * Calcula o número total de páginas em um processo.
     * <br>
     * Método auxiliar para verificar o limite de 250 páginas.
     *
     * @param proc O processo a ser medido.
     * @return O somatório de páginas de todos os documentos no processo.
     */
    private int contarPaginasProcesso(Processo proc) {
        int paginas = 0;
        for (Documento documento : proc.pegarCopiaDoProcesso()) {
            paginas += documento.getPaginas();
        }
        return paginas;
    }

    /**
     * Verifica se um curso é de graduação.
     * <br>
     * A verificação é feita pelo prefixo do nome da enumeração
     * {@link CodigoCurso}.
     *
     * @param curso O código do curso a ser verificado.
     * @return true se for um curso de graduação, false caso contrário.
     */
    private boolean cursoGraduacao(CodigoCurso curso) {
        return curso.name().startsWith("GRADUACAO");
    }

    /**
     * Aumenta o estresse do burocrata em 1 ponto.
     * <br>
     * Invocado pela {@link Secretaria} quando um processo despachado viola uma
     * regra administrativa (Regras 1-7).
     */
    public void estressar() {
        estresse++;
    }

    /**
     * Retorna o nível de estresse atual do burocrata.
     *
     * @return O valor inteiro do estresse.
     */
    public int getEstresse() {
        return estresse;
    }

    /**
     * Aumenta o estresse do burocrata em 10 pontos.
     * <br>
     * Invocado pela {@link Secretaria} quando um processo despachado ultrapassa
     * o limite de 250 páginas, causando a perda dos documentos.
     */
    public void estressarMuito() {
        estresse += 10;
    }
}
