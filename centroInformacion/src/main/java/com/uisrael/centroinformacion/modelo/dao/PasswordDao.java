/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.modelo.dao;

import com.uisrael.centroinformacion.modelo.entidades.Password;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author crifa
 */
public class PasswordDao {

    public void insertar(Password nuevoPassword) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroInformacionPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nuevoPassword);
            em.getTransaction().commit();
            System.out.println("Registro exitoso: " + nuevoPassword);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

}
