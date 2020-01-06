/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.modelo.dao;

import com.uisrael.centroinformacion.modelo.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author LUCHO
 */
@PersistenceUnit(unitName = "centroInformacionPU")
public class UsuarioDao {

    public Usuario findByEmail(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroInformacionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = emf.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root).where(builder.equal(root.get("userEmail"), email));
        TypedQuery<Usuario> q = em.createQuery(query);
        Usuario usuarioResultado = q.getSingleResult();
        return usuarioResultado;
    }

}
