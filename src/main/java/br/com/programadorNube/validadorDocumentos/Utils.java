package br.com.programadorNube.validadorDocumentos;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public boolean allCharactersSame(String s) {
        if (!containsOnlyDigits(s)) {
            int n = s.length();
            for (int i = 1; i < n; i++)
                if (s.charAt(i) != s.charAt(0))
                    return false;

            return true;
        } else {
            throw new RuntimeException("recebi letras");
        }
    }
    public boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public String removePontuacao(String documento) {
        return documento.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
    }

    public List<Integer> converteStringToListInteger(String s) {
        List<Integer> retorno = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            retorno.add(Integer.parseInt(String.valueOf(s.charAt(i))));

        }
        return retorno;
    }
}
