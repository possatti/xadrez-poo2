/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.cgd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Gerencia as sessões do hibernate. O gerenciador usa uma instância estática de
 * 'SessionFactory' para abrir as sessões necessárias. É importante notar que
 * 'SessionFactory' deve ser instânciado uma única vez por aplicação.
 *
 * @author Lucas Possatti
 */
public class SessionManager {

    /**
     * Fábrica usada para criar as sessões do hibernate.
     */
    public static final SessionFactory sessionFactory
            = new Configuration()
            .configure()
            .buildSessionFactory();

    /**
     * Abre uma nova sessão.
     *
     * @return Sessão que foi aberta.
     */
    public static Session openSession() {
        return sessionFactory.openSession();
    }

}
