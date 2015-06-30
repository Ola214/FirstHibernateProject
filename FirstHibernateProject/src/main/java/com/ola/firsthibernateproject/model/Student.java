/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firsthibernateproject.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Olaa
 */
@Entity
@Table(name = "STUDENT") //jezeli nie ma takiej tabeli w bazie to ja tworzy :)
public class Student {
    
    @Id
    //@GeneratedValue //jezelu w mainie bedziesz ustawiac id i zapisujesz obiekt to nie wyskakuje zaden blad :) ale i tak generycznie sie tworzy, domyslnie auto
    //@GeneratedValue(strategy = GenerationType.AUTO)//w oraclu sequence, w mysql identity
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "STUDENT_NAME", nullable=false)
    private String name;
    
    @Transient//hibernate zignoruje ta kolumne, nie jest ona potrzebna w bazie
    @Temporal(TemporalType.DATE) //TIME-czas, DATE-data, TIMESTAMP-czas - data(jak nie ma temporal to domyslnie to bedzie) 
    private Date birthDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private StudentDetail studentDetail; //jezeli chcemy z poziomu rodzica wykonywac operacje na dziecku(Bidirectional Mapping)
    
    @JoinColumn(name = "ID_STUDENT_ADDRESS")
    @ManyToOne(cascade = CascadeType.ALL)
    private StudentAddress studentAddress;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(/*name = "STUDENT_STUDENT_CERTIFICATION",*/ joinColumns ={@JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name="ID_STUDENT_CERTIFICATION", referencedColumnName = "ID")})
    private Set<StudentCertification> studentCertification = new HashSet<>(0);

    public Set<StudentCertification> getStudentCertification() {
        return studentCertification;
    }

    public void setStudentCertification(Set<StudentCertification> studentCertification) {
        this.studentCertification = studentCertification;
    }
    
    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }
    
    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }
    

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
