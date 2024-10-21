package com.example;
import java.io.*;


public class Main {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person("Сергей", 18);
        Person person2 = new Person("Олег", 19);


        try(FileOutputStream fileOutputStream = new FileOutputStream("person.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(person1);
            System.out.println("Объект Person сериализован.");
            objectOutputStream.writeObject(person2);
            System.out.println("Объект Person сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("person.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            person1 = (Person)objectInputStream.readObject();
            System.out.println("Объект Person десериализован.");
            person2 = (Person)objectInputStream.readObject();
            System.out.println("Объект Person десериализован.");
        }

        System.out.println("Объект Person десериализован.");
        System.out.println("Имя: " + person1.getName());
        System.out.println("Возраст: " + person1.getAge());
        System.out.println("Имя: " + person2.getName());
        System.out.println("Возраст: " + person2.getAge());
 
 
    }
}