/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarearest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author 50232
 */
public class Main {
    public  static void main(String[] args){
        EntityManager entityManager=Persistence.createEntityManagerFactory("HAIL").createEntityManager();
        System.out.println("se conecto");
        try{
        entityManager.getTransaction().begin();
        Cliente cliente=new Cliente();
        cliente.setContacto("aniver putin");
        cliente.setDireccion("inteligencia secreta");
        
        entityManager.persist(cliente);
        
        Motocicleta motocicleta=new Motocicleta();
        motocicleta.setCliente(cliente);
        motocicleta.setColor("negroazul");
        motocicleta.setModelo("2025");

        entityManager.persist(motocicleta);        
        entityManager.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("Main").log(Level.SEVERE,"error",ex);
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }
    
}
