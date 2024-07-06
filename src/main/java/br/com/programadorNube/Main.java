package br.com.programadorNube;

import br.com.programadorNube.validadorDocumentos.CPFValidador;

public class Main {
    public static void main(String[] args) {
        String cpf = "74434928040";
        String cpfComPontuacoa = "164.858.400-44";
        CPFValidador cpfValidador = new CPFValidador();
        System.out.println("mandei um cpf valido "+cpfValidador.isValidCpf(cpf));


    }
}