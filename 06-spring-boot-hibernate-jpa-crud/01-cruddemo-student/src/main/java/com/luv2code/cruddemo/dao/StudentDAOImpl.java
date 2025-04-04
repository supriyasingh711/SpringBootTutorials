package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public  Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student " ,Student.class);///java class field name is used not the db one

        //return query results


        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("from Student where lastName=:theData",Student.class);
        //set query parameter
        theQuery.setParameter("theData",theLastName);
        //return the query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theNewStudent) {
       entityManager.merge(theNewStudent);


    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {

        Student s=entityManager.find(Student.class,id);
        entityManager.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
