package ru.skypro;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void workList() {
        for (Employee i : employees) {
            System.out.println(i);
        }
    }

    public int payrollCosts (){
        int totalExpenses = 0;
        for(Employee i : employees) {
            totalExpenses += i.getSalary();
        }
        return totalExpenses;
    }

    public Employee minimalPay() {
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

    public Employee maximumPay() {
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

    public int mean () {
        int averageSalary = payrollCosts() / employees.length;
        return averageSalary;
    }

    public void fullNameStaff () {
        String fullNameStaff;
        for(Employee i : employees) {
            fullNameStaff = i.getFullName();
            System.out.println("Ф.И.О = " + fullNameStaff);
        }
    }

    public void indexPay (int percent) {
        for (Employee employee : employees) {
            int indexPayStaff = employee.getSalary();
            employee.setSalary((int) (indexPayStaff /(percent / 100f + 1)));
        }
    }

    public Employee departmentMinSalaryWork (int departmentStaff) {
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

    public Employee departmentMaxSalaryWork (int depatmentStaff) {
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

    public int calculateTotalSalaryOfTeam (int teamNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if(employee.getDepartment() == teamNumber) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float calculateAverageSalaryOfTeam(int teamNumber) {
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

    public void indexationOfSalariesByDepartment (int teamNum, int percentTeam) {
        for(Employee employee : employees) {
            if(employee.getDepartment() == teamNum) {
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (percentTeam / 100f + 1)));
                System.out.println(employee.getSalary());
            }
        }
    }

    public void departmentStuffNum (int numDepartment) {
        for(Employee employee : employees) {
            if(employee.getDepartment() == numDepartment) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " Зарплата " + employee.getSalary());
            }
        }
    }

    public void salarySorting (int salaryMinStuffAll) {
        for(Employee employee : employees) {
            if(employee.getSalary() < salaryMinStuffAll) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public void salarySortingMax (int salaryMaxStuffAll) {
        for(Employee employee : employees) {
            if(employee.getSalary() >= salaryMaxStuffAll) {
                System.out.println(employee.getId() + " . " + employee.getFullName() + " - " + employee.getSalary());

            }
        }
    }
    //Метод для заполнения массива в Main
    public void createEmployee(String fullName, int salary, int teamNumber) {
        int index = freeCell();
        if (index == -1) {
            System.out.println("Хранилище заполнено. Создание сотрудника не допускается.");
            return;
        }
        employees[index] = new Employee(fullName, teamNumber, salary);
    }

    //Поиск свободной ячейки в массиве
    private int freeCell() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }
    //Удалить(уволить) сотрудника по имени
    public void deleteAnEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
            }
        }
    }

    //Удалить(уволить) сотрудника по ID
    public void removeEmployeeId(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    //Изменить зарплату
    public void changeSalaryOfEmployee(String fullName, int salary) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
            }
        }
    }

    //Изменить отдел
    public void changeDepartmentEmployee(String fullName, int teamNumber) {
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(teamNumber);
            }
        }
    }

    //Получить Ф. И. О. всех сотрудников по отделам
    public void printStuff() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Team " + i + ":");
            for (Employee employee : employees) {
                if (employee.getDepartment() == i) {
                    System.out.println("\t" + employee.getId() + ". " + employee.getFullName());
                }
            }
        }
    }
}
