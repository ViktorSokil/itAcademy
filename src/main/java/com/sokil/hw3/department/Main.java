package com.sokil.hw3.department;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Vi", "Th", 26, "programmer", 2000);
        Employee employee2 = new Employee("N", "B", 30, "teamLead", 2000);
        Employee employee3 = new Employee("Mr", "Db", 45, "QA", 2000);
        Employee[] employees = {employee1, employee2, employee3};
        Department<Employee> department = new Department<>();
        department.setName("hkjh");
        department.setEmployees(employees);

        Employee employee4 = new Employee("Vi", "Th", 26, "programmer", 2000);
        Employee employee5 = new Employee("N", "B", 35, "teamLead", 2000);
        Employee employee6 = new Employee("Mr", "Db", 45, "QA", 2000);
        Employee[] employees2 = {employee4, employee5, employee6};

        Department<Employee> department2 = new Department<>();
        department2.setName("bbbb");
        department2.setEmployees(employees2);
        System.out.println(department.hasSameAverageAge(department2, 0.5));
    }
}
