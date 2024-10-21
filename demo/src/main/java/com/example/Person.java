package com.example;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "people")
@NamedQuery(name = "Person.getAll", query = "SELECT c from Car c")

public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 32)
    private String name;     

    @Column(name = "cost")
    private int age;      
    
   public Person(String name, int age) {
    this.name = name;
    this.age = age;
   }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=' " + age + '\'' +
                '}';

}
}