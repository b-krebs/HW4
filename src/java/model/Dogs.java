/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author baileykrebs
 */
public class Dogs {
    
    private int dogID;
    private String dogName;
    private String breed;
    private String gender;
    private int age;
    
    public Dogs() {
        this.dogID = 0;
        this.dogName = "";
        this.breed = "";
        this.gender = "";
        this.age = 0;
    }

    public Dogs(int dogID, String dogName, String breed, String gender, int age) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
    }

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dogs{" + "dogID=" + dogID + ", dogName=" + dogName + ", breed=" + breed + ", gender=" + gender + ", age=" + age + '}';
    }
    
    
    
    
    
}
