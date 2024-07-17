/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teste.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author igork
 */
public class ConnectionFactory {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    public static void conectar(){
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste-jpa");
            entityManager = entityManagerFactory.createEntityManager();
            System.out.println("Conexão realizada");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            conectar();
        }
        return entityManager;
    }

    public static void closeEntityManagerFactory() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
        System.out.println("Conexão fechada");
    }
    
}
