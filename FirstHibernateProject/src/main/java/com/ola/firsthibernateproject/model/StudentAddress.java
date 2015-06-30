/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firsthibernateproject.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Olaa
 */
@Entity
@Table(name = "STUDENT_ADDRESS")
public class StudentAddress {
    
    @Id @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "ADDRESS_DETAIL")
    private String addressDetail;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="studentAddress") //bez mappedBy utworzyla by sie nowa tabela posredniczacaSTUDENT_ADDRESS_STUDENT(majaca STUDENT_ADDRESS_ID i students_ID-chodzi tu od id_student)
    //z mappedBy StudentAddress class is in general called as a non-owning side, Student - owning side 
    private Set<Student> students = new HashSet<Student>(0);

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
    
    
}
