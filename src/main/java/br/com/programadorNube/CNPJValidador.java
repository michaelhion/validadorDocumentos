package br.com.programadorNube;

import br.com.programadorNube.validadorDocumentos.Utils;

import java.util.List;

public class CNPJValidador {

    private Integer somaDigitosMultiplicadoPorPeso = 0;
    private Integer moduloSomaPorOnze = 0;

    private final Utils utils = new Utils();

    public boolean isValidCnpj(String cnpj) {
        List<Integer> digitos = utils.converteStringToListInteger(cnpj);
        Integer ultimoDigito = digitos.get(13);
        Integer penultimoDigito = digitos.get(12);
        Integer digito13Validado;
        Integer digito14Validado;
        calculaSomaDasParcelas(11,digitos);
        calculaModulo();
        digito13Validado = defineDigitoVerificador();
        calculaSomaDasParcelas(12,digitos);
        calculaModulo();
        digito14Validado = defineDigitoVerificador();
        return (ultimoDigito.equals(digito14Validado) && penultimoDigito.equals(digito13Validado));
    }

    private void calculaModulo() {
        moduloSomaPorOnze = somaDigitosMultiplicadoPorPeso %11;
    }

    private Integer defineDigitoVerificador() {
        Integer digito = 0;
        if(!(moduloSomaPorOnze.equals(0) || moduloSomaPorOnze.equals(1))){
            digito = 11 - moduloSomaPorOnze;
        }
        return digito;
    }

    private void calculaSomaDasParcelas(Integer quantidadeDeDigitos,List<Integer> digitos) {
        Integer peso = 2;
        moduloSomaPorOnze = 0;
        somaDigitosMultiplicadoPorPeso = 0;
        for (int i = quantidadeDeDigitos; i >= 0; i--) {
            Integer digito = digitos.get(i);
            somaDigitosMultiplicadoPorPeso += digito * peso;
           peso++;
           peso = peso > 9  ? 2 : peso;
        }
    }
}
