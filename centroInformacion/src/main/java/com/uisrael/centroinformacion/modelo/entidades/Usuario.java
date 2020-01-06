/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author LUCHO
 */
@Entity
@Table(name = "users")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "userid")
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "useremail")
    public String userEmail;
    @Column(name = "token")
    private String token;

    public Usuario() {
    }

    public Usuario(int userId, String userName, String userEmail, String token) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", token=" + token + '}';
    }
    
}
