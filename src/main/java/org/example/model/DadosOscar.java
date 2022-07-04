package org.example.model;

public class DadosOscar {
    private int index;
    private int year;
    private int age;
    private String name;
    private String movie;

    public DadosOscar(int index, int year, int age, String name, String movie) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
