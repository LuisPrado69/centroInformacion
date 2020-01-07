/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author LUCHO
 */
@Entity
@Table(name = "password")
public class Password implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "passwordid")
    private int passwordId;

    @Column(name = "passvalue")
    private String passValue;

    @Temporal(TemporalType.DATE)
    private Date passDate;

    @Column(name = "passstatus")
    private int passStatus;

    @Column(name = "user_userid")
    private int userUserId;

    public Password() {
    }

    public Password(int passwordId, String passValue, Date passDate, int passStatus, int userUserId) {
        this.passwordId = passwordId;
        this.passValue = passValue;
        this.passDate = passDate;
        this.passStatus = passStatus;
        this.userUserId = userUserId;
    }

    public int getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(int passwordId) {
        this.passwordId = passwordId;
    }

    public String getPassValue() {
        return passValue;
    }

    public void setPassValue(String passValue) {
        this.passValue = passValue;
    }

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public int getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(int passStatus) {
        this.passStatus = passStatus;
    }

    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public String toString() {
        return "Password{" + "passwordId=" + passwordId + ", passValue=" + passValue + ", passDate=" + passDate + ", passStatus=" + passStatus + ", userUserId=" + userUserId + '}';
    }

}
