package ru.skypro;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private final static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов Иван Иванович", 150_000, 3);
        Employee voronov = new Employee("Воронов Виктор Павлович", 160_000, 2);
        Employee karpov = new Employee("Карпов Евгений Васильевич", 185_000, 1);
        Employee ytkina = new Employee("Уткина Ксения Николаевна", 120_000, 2);
        Employee guseva = new Employee("Гусева Любовь Олеговна", 98_000, 3);
        Employee kozlov = new Employee("Козлов Алексей Александрович", 100_000, 4);
        Employee petyxov = new Employee("Петухов Эдуард Эдуардович", 89_000, 5);
        Employee ribkina = new Employee("Рыбкина Кристина Анатольевна", 140_000, 3);
        Employee bobrov = new Employee("Бобров Евгений Викторович", 95_000, 5);
        Employee mishkin = new Employee("Мишкин Михаил Михайлович",220_000,1);

        ivanov.setSalary(150_000);
        ivanov.setDepartment(1);
        voronov.setSalary(160_000);
        voronov.setDepartment(2);
        karpov.setSalary(120_000);
        karpov.setDepartment(2);
        ytkina.setSalary(120_000);
        ytkina.setDepartment(2);
        guseva.setSalary(98_000);
        guseva.setDepartment(3);
        kozlov.setSalary(100_000);
        kozlov.setDepartment(4);
        petyxov.setSalary(89_000);
        petyxov.setDepartment(5);
        ribkina.setSalary(140_000);
        ribkina.setDepartment(3);
        bobrov.setSalary(95_000);
        bobrov.setDepartment(5);
        mishkin.setSalary(220_000);
        mishkin.setDepartment(1);

        employees[0] = ivanov;
        employees[1] = voronov;
        employees[2] = karpov;
        employees[3] = ytkina;
        employees[4] = guseva;
        employees[5] = kozlov;
        employees[6] = petyxov;
        employees[7] = ribkina;
        employees[8] = bobrov;
        employees[9] = mishkin;


        workList();

        payrollCosts(employees);
        System.out.println("Сумма затрат на зарплаты в месяц = " + payrollCosts(employees));

        minimalPay(employees);
        System.out.println("Минимальная заработная плата сотрудника = " + minimalPay(employees));

        maximumPay(employees);
        System.out.println("Максимальная заработная плата сотрудника = " + maximumPay(employees));

        mean(employees);
        System.out.println("Среднее значение зарплат = " + mean(employees));

        fullNameStaff(employees);
    }

    public static void workList() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int payrollCosts (Employee[] employees){
        int totalExpenses = 0;
        for(Employee i : employees) {
            totalExpenses += i.getSalary();
        }
        return totalExpenses;
    }

    public static Employee minimalPay(Employee[] employees) {
        Employee employeeMinPay = employees[0];
        int min = employeeMinPay.getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                employeeMinPay = employees[i];
            }
        }
        return employeeMinPay;
    }

    public static Employee maximumPay(Employee[] employees) {
        Employee employeeMaxPay = employees[0];
        int max = employeeMaxPay.getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                employeeMaxPay = employees[i];
            }
        }
        return employeeMaxPay;
    }

    public static int mean (Employee[] employees) {
        int averageExpenses = payrollCosts(employees) / employees.length;
        return averageExpenses;
    }

    public static void fullNameStaff (Employee[] employees) {
       String fullNameStaff;
       for(Employee i : employees) {
           fullNameStaff = i.getFullName();
           System.out.println("Ф.И.О = " + fullNameStaff);
       }
    }



}
