package ru.skypro;

import java.util.Objects;

public class Employee {
    private static int count = 0;
    private final String fullName;
    private int salary;
    private int department;
    public int id;

    public Employee (String fullName, int salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        count++;
        id = count;
    }

    public static int getCount() {

        return count;
    }


    public String getFullName() {

        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {

        return department;
    }

    public int getId() {

        return id;
    }

    public void setDepartment(int department) {

        this.department = department;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department);
    }

    public String toString(){
        return "Ф.И.О " + fullName+ "Зарплата " + salary + " Отдел " + department;
    }

}
