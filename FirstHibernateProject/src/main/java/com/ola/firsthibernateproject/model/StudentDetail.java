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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 *
 * @author Olaa
 */
@Entity
@Table(name = "STUDENT_DETAIL")
public class StudentDetail {
    
    @Id
    @GeneratedValue(generator = "newGenerator") //name of primary key generator
    @GenericGenerator(name = "newGenerator", strategy = "foreign", parameters={ @Parameter(value = "student", name = "property")})
    @Column(name = "ID_STUDENT")
    private int id;
    
    @OneToOne(cascade = CascadeType.ALL)//for create, update and delete operation, REMOVE-only for removing object, PERSIST-only for inserting
    @JoinColumn(name = "ID_STUDENT")
    private Student student;
    
    @Column(name = "STUDENT_MOBILE_NUMBER")
    private String studentMobileNumber;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(String studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }
    
    
}
