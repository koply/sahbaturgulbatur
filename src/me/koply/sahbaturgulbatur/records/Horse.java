package me.koply.sahbaturgulbatur.records;

public class Horse {
    private String name, jokey, weight;
    private int age;

    public void printInformation() {
        System.out.println(name + " [" + jokey + "] -> Yaş: " + age + " - Kütle: " + weight);
    }

    public String getName() {
        return name;
    }

    public Horse setName(String name) {
        this.name = name;
        return this;
    }

    public String getJokey() {
        return jokey;
    }

    public Horse setJokey(String jokey) {
        this.jokey = jokey;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Horse setAge(int age) {
        this.age = age;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public Horse setWeight(String weight) {
        this.weight = weight;
        return this;
    }
}