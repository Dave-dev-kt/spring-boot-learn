package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //Define field for entityManager

    private EntityManager entityManager;

    //Inject entity manager using constructor injection

    @Autowired
    public  StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY firstName",Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);

        //set query parameters
        theQuery.setParameter("theData",theLastName);
        //return query result

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("delete from Student ").executeUpdate();

        return numRowsDeleted;
    }
}
