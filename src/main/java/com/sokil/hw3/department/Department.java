package com.sokil.hw3.department;

public class Department<T extends Person> {
    private String name;
    private T[] employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T[] getEmployees() {
        return employees;
    }

    public void setEmployees(T[] employees) {
        this.employees = employees;
    }

    public double averageAge(){
        int count=0;
        double sum = 0;
        for (T element: employees){
            sum += element.getAge();
            count++;
        }
        return sum/count;
    }

    public boolean hasSameAverageAge(Department department1, double epsilon){
        double delta = this.averageAge() - department1.averageAge();
        if (Math.abs(delta) <= epsilon && Math.abs(delta) >= 0){
            return true;
        }
        return false;
    }
}
