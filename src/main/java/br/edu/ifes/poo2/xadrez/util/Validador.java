/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo2.xadrez.util;

/**
 * Contém utilidades para a validação de dados.
 *
 * @author possatti
 */
public class Validador {
    public static final String REGEX_EMAIL= "^[\\w\\.]+@\\w+\\.[\\w\\.]+$";
    public static final String REGEX_NOME = "^(\\w\\w+| )+$";
    public static final String REGEX_APELIDO= "^[\\w@#%+\\$\\.\\-]+$";
}
