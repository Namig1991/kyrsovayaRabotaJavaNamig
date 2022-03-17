package ru.skypro;

import org.w3c.dom.ls.LSOutput;

public class Main {


    private final static Employee[] employees = new Employee[10];


    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов Иван Иванович", 150_000, 1);
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
        karpov.setSalary(185_000);
        karpov.setDepartment(1);
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

        payrollCosts();
        System.out.println("Сумма затрат на зарплаты в месяц = " + payrollCosts());

        minimalPay();
        System.out.println("Минимальная заработная плата сотрудника = " + minimalPay());

        maximumPay();
        System.out.println("Максимальная заработная плата сотрудника = " + maximumPay());

        mean();
        System.out.println("Среднее значение зарплат = " + mean());

        fullNameStaff();

        indexPay(0);

        departmentMinSalaryWork(1);
        System.out.println("Минимальная заработная плата по отделу " + departmentMinSalaryWork(1));

        departmentMaxSalaryWork(2);
        System.out.println("Максимальная заработная плата по отделу " + departmentMaxSalaryWork(2));

        calculateTotalSalaryOfTeam(3);
        System.out.println("Сумма затрат на зарплаты по отделу " + calculateTotalSalaryOfTeam(3));

        //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        indexationOfSalariesByDepartment(1,0);

        calculateAverageSalaryOfTeam(1);
        System.out.println("Средняя зарплата по отделу " + calculateAverageSalaryOfTeam(1));

        //Напечатать всех сотрудников отдела (все данные, кроме отдела).
        departmentStuffNum(1);

        //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплату).
        salarySorting(100000);

        //Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплату)
        salarySortingMax(200000);

        System.out.println("=================================================================");

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.createEmployee("Иванов Иван Иванович", 150000, 1);
        employeeBook.createEmployee("Воронов Виктор Викторович",160000,2);
        employeeBook.createEmployee("Карпов Евгений Васильевич",120000,2);
        employeeBook.createEmployee("Уткина Ксения Николаевна",120000,2);
        employeeBook.createEmployee("Гусева Любовь Олеговна",98000,3);
        employeeBook.createEmployee("Козлов Алексей Александрович",100000,4);
        employeeBook.createEmployee("Петухов Эдуард Эдуардович", 89000,5);
        employeeBook.createEmployee("Рыбкина Кристиа Анатольевна", 140000, 3);
        employeeBook.createEmployee("Бобров Евгений Викторович", 95000,5);
        employeeBook.createEmployee("Мишкин Михаил Михайлович", 220000,1);

    }

    public static void workList() {
        for (Employee i : employees) {
            System.out.println(i);
        }
    }

    public static int payrollCosts (){
        int totalExpenses = 0;
        for(Employee i : employees) {
            totalExpenses += i.getSalary();
        }
        return totalExpenses;
    }

    public static Employee minimalPay() {
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

    public static Employee maximumPay() {
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

    public static int mean () {
        int averageSalary = payrollCosts() / employees.length;
        return averageSalary;
    }

    public static void fullNameStaff () {
       String fullNameStaff;
       for(Employee i : employees) {
           fullNameStaff = i.getFullName();
           System.out.println("Ф.И.О = " + fullNameStaff);
       }
    }

    public static void indexPay (int percent) {
        for (Employee employee : employees) {
            int indexPayStaff = employee.getSalary();
            employee.setSalary((int) (indexPayStaff /(percent / 100f + 1)));
        }
    }

    public static Employee departmentMinSalaryWork (int departmentStaff) {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for(Employee employee : employees) {
            if (employee.getDepartment() != departmentStaff) {
                continue;
            }

            if(employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee departmentMaxSalaryWork (int depatmentStaff) {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee i : employees) {
            if(i.getDepartment() != depatmentStaff) {
                continue;
            }

            if(i.getSalary() > maxSalary) {
                maxSalary = i.getSalary();
                result = i;
            }
        }
        return result;
    }

    public static int calculateTotalSalaryOfTeam (int teamNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if(employee.getDepartment() == teamNumber) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static float calculateAverageSalaryOfTeam(int teamNumber) {
        int membersCount = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == teamNumber) {
                sum += employee.getSalary();
                membersCount++;
            }
        }
        return sum / (float) membersCount;
    }

    public static void indexationOfSalariesByDepartment (int teamNum, int percentTeam) {
        for(Employee employee : employees) {
            if(employee.getDepartment() == teamNum) {
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (percentTeam / 100f + 1)));
                System.out.println(employee.getSalary());
            }
        }
    }

    public static void departmentStuffNum (int numDepartment) {
        for(Employee employee : employees) {
            if(employee.getDepartment() == numDepartment) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " Зарплата " + employee.getSalary());
            }
        }
    }

    public static void salarySorting (int salaryMinStuffAll) {
        for(Employee employee : employees) {
            if(employee.getSalary() < salaryMinStuffAll) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public static void salarySortingMax (int salaryMaxStuffAll) {
        for(Employee employee : employees) {
            if(employee.getSalary() >= salaryMaxStuffAll) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " - " + employee.getSalary());

            }
        }
    }

}
