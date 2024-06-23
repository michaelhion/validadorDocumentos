package br.com.programadorNube.validadorDocumentos;

import br.com.programadorNube.CNPJValidador;

public class Validador {
    private final Integer TAMANHO_CPF = 11;
    private final Integer TAMANHO_CNPJ = 14;
    private final Utils utils = new Utils();
    private final CNPJValidador cnpjValidador;
    private final CPFValidador cpfValidador;

    public Validador(CNPJValidador cnpjValidador, CPFValidador cpfValidador) {
        this.cnpjValidador = cnpjValidador;
        this.cpfValidador = cpfValidador;
    }

    public String validaTipoDocumeto(String documento) {
        String docSemPontuacao = utils.removePontuacao(documento);

        if (utils.containsOnlyDigits(docSemPontuacao)) {
            return "documente deve ter somente numeros";
        } else if (utils.allCharactersSame(docSemPontuacao)) {
            return "todo os caracteres são iguais";

        } else {
            if (docSemPontuacao.length() == TAMANHO_CPF) {

                if(!cpfValidador.isValidCpf(docSemPontuacao)){
                    return "cnpj invalido";
                }
                return String.format("O documento %s é um cpf", docSemPontuacao);
            } else if (docSemPontuacao.length() == TAMANHO_CNPJ) {
                cnpjValidador.isValidCnpj(docSemPontuacao);
                return String.format("O documento %s é um cnpj", docSemPontuacao);
            }
        }

        return null;
    }
}
