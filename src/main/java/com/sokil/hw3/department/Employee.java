package com.sokil.hw3.department;

public class Employee extends Person {
    private String position;
    private int salary;

    public Employee(String firstName, String lastName, Integer age, String position, int salary) {
        super(firstName, lastName, age);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
