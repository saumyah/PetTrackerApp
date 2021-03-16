package com.example.pettrackerapp;

public class Pet {

    int id;
    String name;
    String type;

    public Pet(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Pet(String name, String type){
        this.name = name;
        this.type = type;
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
}
