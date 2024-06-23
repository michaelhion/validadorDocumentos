package br.com.programadorNube.validadorDocumentos;

import java.util.List;

public class CPFValidador {
    private Integer somaDigitosMultiplicadoPorPeso = 0;
    private Integer moduloSomaPorOnze = 0;
    private final Utils utils = new Utils();

    public boolean isValidCpf(String cpf) {
        List<Integer> digitos = utils.converteStringToListInteger(cpf);
        Integer ultimoDigito = digitos.get(10);
        Integer penultimoDigito = digitos.get(9);
        Integer digito11Validado;
        Integer digito10Validado;
        calculaSomaDasParcelas(9,digitos);
        calculaModulo();
        digito10Validado = defineDigitoVerificador();
        calculaSomaDasParcelas(10,digitos);
        calculaModulo();
        digito11Validado = defineDigitoVerificador();

        return (digito10Validado.equals(penultimoDigito) && digito11Validado.equals(ultimoDigito));
    }

    private void calculaModulo() {
        moduloSomaPorOnze = somaDigitosMultiplicadoPorPeso %11;
    }

    private Integer defineDigitoVerificador() {
        Integer digito = 0;
        if (!(moduloSomaPorOnze.equals(10) || moduloSomaPorOnze.equals(11))){
            return digito = moduloSomaPorOnze;
        }
        return digito = 0;
    }

    private void calculaSomaDasParcelas(Integer quantidadeDeDigitos, List<Integer> digitos) {
        Integer peso =quantidadeDeDigitos +1;
        moduloSomaPorOnze = 0;
        somaDigitosMultiplicadoPorPeso = 0;
//        System.out.println("-------------------------");
        for (int i=0; i< quantidadeDeDigitos; i++) {
            Integer digito = digitos.get(i);
            somaDigitosMultiplicadoPorPeso += digito * peso;
            peso--;
//            System.out.println(somaDigitosMultiplicadoPorPeso);
        }
    }
}