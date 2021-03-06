package org.lakaz.hibernatetest.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.lakaz.hibernatetest.model.*;
import org.lakaz.hibernatetest.model.mapping.*;

import java.util.Date;
public class Main {
  private static final String PERSISTENCE_UNIT_NAME = "todos";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // Read the existing entries and write to console
    Query q = em.createQuery("select t from ToDo t");
    List<ToDo> todoList = q.getResultList();
    for (ToDo todo : todoList) {
      System.out.println(todo);
    }
    // you can also search with em.find(ToDo.class, <id>);
    System.out.println("Size: " + todoList.size());

    // Create new todo
    em.getTransaction().begin();
    ToDo todo = new ToDo();
    todo.setSummary("This is a test" + new Date());
    todo.setDescription("This is a test");

    // using enumerated types
    EnumeratedTypes enumTest = new EnumeratedTypes();
    enumTest.setPlayerType(Test.GOALKEEPER);

    // one to one mapping
    Employee employee = new Employee();
    Street street = new Street();

    employee.setStreet(street);
    street.setEmployee(employee);


    em.persist(todo);
    em.persist(enumTest);
    em.persist(employee);
    em.persist(street);

    em.getTransaction().commit();

    em.close();
  }
}