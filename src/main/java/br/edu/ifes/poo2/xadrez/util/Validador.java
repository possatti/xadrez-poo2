package br.edu.ifes.poo2.xadrez.util;

/**
 * Contém utilidades para a validação de dados.
 *
 * @author possatti
 */
public class Validador {

    public static final String REGEX_EMAIL = "^[\\w\\.]+@\\w+\\.[\\w\\.]+$";
    public static final String REGEX_NOME = "^(\\w\\w+| )+$";
    public static final String REGEX_APELIDO = "^[\\w@#%+\\$\\.\\-]+$";

    private Validador() {

    }
}
