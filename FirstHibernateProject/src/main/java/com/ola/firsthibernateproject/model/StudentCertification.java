/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firsthibernateproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Olaa
 */
@Entity
@Table(name = "STUDENT_CERTIFICATION")
public class StudentCertification {
    
    @Id @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "CERTIFICATION_NAME")
    private String certifiactionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertifiactionName() {
        return certifiactionName;
    }

    public void setCertifiactionName(String certifiactionName) {
        this.certifiactionName = certifiactionName;
    }
    
    
}
