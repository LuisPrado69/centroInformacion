/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.modelo.dao;

import com.uisrael.centroinformacion.modelo.entidades.Usuario;
import com.uisrael.centroinformacion.modelo.entidades.Usuario_;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author LUCHO
 */
public class UsuarioDao {

    public Usuario findByToken(String token) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroInformacionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = emf.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root).where(builder.equal(root.get("token"), token));
        TypedQuery<Usuario> q = em.createQuery(query);
        Usuario usuarioResultado = q.getSingleResult();
        return usuarioResultado;
    }

    public void generarToken(String email, String token) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroInformacionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Usuario> criteriaUpdate = cb.createCriteriaUpdate(Usuario.class);
        Root<Usuario> employeeRoot = criteriaUpdate.from(Usuario.class);
        criteriaUpdate.set(employeeRoot.get(Usuario_.token), token).where(cb.equal(employeeRoot.get(Usuario_.userEmail), email));
        em.getTransaction().begin();
        int i = em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();
    }

    public boolean exists(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroInformacionPU");
        EntityManager em = emf.createEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> from = cq.from(Usuario.class);
        cq.select(cb.count(from));
        cq.where(cb.equal(from.get(Usuario_.userEmail), email));
        final TypedQuery<Long> tq = em.createQuery(cq);
        return tq.getSingleResult() > 0;
    }

}
