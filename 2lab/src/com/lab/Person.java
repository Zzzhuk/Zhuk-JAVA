package com.lab;

import com.google.gson.Gson;

public class Person {
    public String fName;
    public String lName;
    public int age;
    public String gender;
    public static Gson gson = new Gson();

    public Person(String fName, String lName, int age, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public final int hashCode() {
        int result = 7;
        result += result * age;
        try {
            result += result * fName.hashCode();
            result += result * lName.hashCode();
            result += result * gender.hashCode();
        } catch (Exception e) {
            result += 10;
        }
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Person) || obj == null) {
            return false;
        }
        Person person = (Person) obj;
        return this.fName != null && person.fName != null && this.fName.equals(person.fName) &&
                this.lName != null && person.lName != null && this.lName.equals(person.lName) &&
                this.gender != null && person.gender != null && this.gender.equals(person.gender) &&
                this.age == person.age;
    }

    public String toJSON() {
        return Person.gson.toJson(this);
    }

    public static Person fromJSON(String json) {
        return Person.gson.fromJson(json, com.lab.Person.class);
    }
}