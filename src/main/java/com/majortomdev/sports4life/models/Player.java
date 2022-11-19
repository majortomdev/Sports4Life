package com.majortomdev.sports4life.models;

import java.util.Date;

public class Player {
    private int playerId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int age;
    private int height;
    private int weight;
    private String image;
    Country countryPlaysIn;

    public Player(int playerId, String firstName, String lastName, Date birthday,
                  int age, int height, int weight, String img, Country playsIn) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.image = img;
        this.countryPlaysIn = playsIn;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Country getCountryPlaysIn() {
        return countryPlaysIn;
    }

    public void setCountryPlaysIn(Country countryPlaysIn) {
        this.countryPlaysIn = countryPlaysIn;
    }
}

