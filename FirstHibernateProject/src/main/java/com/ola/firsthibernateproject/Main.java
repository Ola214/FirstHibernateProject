/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firsthibernateproject;

import com.ola.firsthibernateproject.model.Student;
import com.ola.firsthibernateproject.model.StudentAddress;
import com.ola.firsthibernateproject.model.StudentCertification;
import com.ola.firsthibernateproject.model.StudentDetail;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Olaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*StudentCertification studentCertification1 = new StudentCertification();
        studentCertification1.setCertifiactionName("Core JAVA Certification Exam");
        
        StudentCertification studentCertification2 = new StudentCertification();
        studentCertification2.setCertifiactionName("Oracle DB Certification Exam");
        
        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setAddressDetail("Bialystok, Polska");
        
        Student student = new Student();
        student.setName("Ola5");
        student.setStudentAddress(studentAddress);
        student.getStudentCertification().add(studentCertification1);
        //student.setBirthDate(new Date());
        
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentMobileNumber("123456789");
        studentDetail.setStudent(student); //to musi byc
        
        student.setStudentDetail(studentDetail); //to niekoniecznie(jezeli robimy save(studentDetail)), jezeli nie robimy save(studentDetail) to nie bedzie w bazie wstawionych wierszy STUDENT_DETAIL 
        
        Student student2 = new Student();
        student2.setName("Kasia");
        student2.setStudentAddress(studentAddress);
        student2.getStudentCertification().add(studentCertification1);
        student2.getStudentCertification().add(studentCertification2);
        //student.setBirthDate(new Date());
        
        StudentDetail studentDetail2 = new StudentDetail();
        studentDetail2.setStudentMobileNumber("123456780");
        studentDetail2.setStudent(student2); //to musi byc
        
        student2.setStudentDetail(studentDetail2);
        
        (studentAddress.getStudents()).add(student); //jezeli robimy save(studentAddress) to od razu wszystko nam sie wstawia, jezeli robilibysmy save(student) save(student2) to byloby to niepotrzebne
        (studentAddress.getStudents()).add(student2);
        
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        //session.save(student);
        //session.save(student2);
        session.save(studentAddress);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();*/
        
        Student student = new Student();
        student.setName("Ala");
        
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        student.setName("Ala modified before save function");
        session.save(student);
        student = (Student)session.get(Student.class, 1); //pobieramy Studenta o id=1
        System.out.println("Student Object having student name as: " + student.getName());
        
        student.setName("Modifying student name id as 2");
        //student.setName("AlaUpdate"); //o dziwo jezeli zrobilismy session.save(student) i potem to, to w bazie memy AlaUpdate, update sam sie robi, bez pisania (do zamkniecia sesji) :O, save dziala w trybie persistent(?), nie transient
        //session.update(student);
        //session.delete(student);
        //session.delete(student);//change persistent state to transient
        
        session.getTransaction().commit();
        session.close();
        
        student.setName("modifying student name in the detached state");
        
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        
        session2.update(student); //zmienia stan z detached na persistent :)
        student.setName("modifying student after detached state ufter update");
        
        session2.getTransaction().commit();
        session2.close();
        
        sessionFactory.close();
    }
    
}
