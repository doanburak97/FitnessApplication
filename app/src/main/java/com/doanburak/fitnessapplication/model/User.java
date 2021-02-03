package com.doanburak.fitnessapplication.model;

public class User {

    private String email;
    private String name;
    private String surname;
    private String age;
    private String weight;

    public User(){

    }

    public User(String email, String name, String surname, String age, String weight){
        this.setEmail(email);
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setWeight(weight);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
