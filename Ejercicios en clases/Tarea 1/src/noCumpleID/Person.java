/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noCumpleID;

/**
 *
 * @author jharif
 */
public class Person {
    private int Id;
    private String Name;
    private int age;
    private String Email;

    public Person(int Id, String Name, int age, String Email) {
        this.Id = Id;
        this.Name = Name;
        this.age = age;
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Person{" + "Id=" + Id + ", Name=" + Name + ", age=" + age + ", Email=" + Email + '}';
    }

    
}
