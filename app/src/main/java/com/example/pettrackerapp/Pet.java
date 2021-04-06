package com.example.pettrackerapp;

public class Pet {

    int id;
    String name;
    String type;
    int age;
    String sex;
    int weight;

    public Pet(int id, String name, String type, int age, String sex, int weight){
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public Pet(String name, String type, int age, String sex, int weight){
        this.name = name;
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public Pet(){
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(String type){
        this.age = age;
    }

    public String getSex(){
        return this.sex;
    }

    public void setSex(String type){
        this.sex = sex;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(String type){
        this.weight = weight;
    }
}
