package com;

import com.example.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonService {

    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Person add(Person person1){
        em.getTransaction().begin();
        Person personFromDB = em.merge(person1);
        em.getTransaction().commit();
        return personFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Person get(long id){
        return em.find(Person.class, id);
    }

    public void update(Person person1){
        em.getTransaction().begin();
        em.merge(person1);
        em.getTransaction().commit();
    }

    public List<Person> getAll(){
        TypedQuery<Person> namedQuery = em.createNamedQuery("Person.getAll", Person.class);
        return namedQuery.getResultList();
    }

}