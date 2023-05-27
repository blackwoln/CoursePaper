public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 45000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 46000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 1, 54500);
        employees[3] = new Employee("Смирнова Елена Александровна", 3, 67000);
        employees[4] = new Employee("Козлова Ольга Владимировна", 2, 55500);
        employees[5] = new Employee("Николаев Николай Николаевич", 4, 88000);
        employees[6] = new Employee("Федорова Екатерина Ивановна", 2, 95000);
        employees[7] = new Employee("Алексеев Алексей Алексеевич", 3, 56500);
        employees[8] = new Employee("Михайлова Мария Петровна", 5, 67500);
        employees[9] = new Employee("Васильев Василий Васильевич", 4, 75500);

        // Получить список всех сотрудников
        printAllEmployees();
        System.out.println();

        // Посчитать сумму затрат на зарплаты
        double totalSalaryExpenses = calculateTotalSalaryExpenses();
        System.out.println("Сумма затрат на зарплаты: " + totalSalaryExpenses);
        System.out.println();

        // Найти сотрудника с минимальной зарплатой
        Employee minSalaryEmployee = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        System.out.println();

        // Найти сотрудника с максимальной зарплатой
        Employee maxSalaryEmployee = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        System.out.println();

        // Подсчитать среднее значение зарплат
        double averageSalary = calculateAverageSalary();
        System.out.println("Средняя зарплата: " + averageSalary);
        System.out.println();

        // Получить Ф. И. О. всех сотрудников
        printEmployeeNames();
        System.out.println();

        // Проиндексировать зарплату на 10%
        indexSalary(10);
        System.out.println();

        // Найти сотрудника с минимальной зарплатой в отделе 2
        Employee minSalaryEmployeeInDepartment2 = findEmployeeWithMinSalaryByDepartment(2);
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2: " + minSalaryEmployeeInDepartment2);
        System.out.println();

        // Найти сотрудника с максимальной зарплатой в отделе 3
        Employee maxSalaryEmployeeInDepartment3 = findEmployeeWithMaxSalaryByDepartment(3);
        System.out.println("Сотрудник с максимальной зарплатой в отделе 3: " + maxSalaryEmployeeInDepartment3);
        System.out.println();

        // Посчитать сумму затрат на зарплату в отделе 1
        double totalSalaryExpensesInDepartment1 = calculateTotalSalaryExpensesByDepartment(1);
        System.out.println("Сумма затрат на зарплату в отделе 1: " + totalSalaryExpensesInDepartment1);
        System.out.println();

        // Посчитать среднюю зарплату в отделе 4
        double averageSalaryInDepartment4 = calculateAverageSalaryByDepartment(4);
        System.out.println("Средняя зарплата в отделе 4: " + averageSalaryInDepartment4);
        System.out.println();

        // Проиндексировать зарплату всех сотрудников отдела 5 на 5%
        indexSalaryByDepartment(5, 5);
        System.out.println();

        // Напечатать всех сотрудников отдела 2
        printEmployeesByDepartment(2);
        System.out.println();

        // Вывести информацию о сотрудниках с зарплатой менее 60000
        printEmployeesWithSalaryLessThan(60000);
        System.out.println();

        // Вывести информацию о сотрудниках с зарплатой больше или равной 60000
        printEmployeesWithSalaryGreaterThan(60000);
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double calculateTotalSalaryExpenses() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary() {
        double totalSalary = calculateTotalSalaryExpenses();
        int employeeCount = countEmployees();
        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }

    public static void printEmployeeNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    private static int countEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static void indexSalary(double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary + (currentSalary * (percentage / 100));
                employee.setSalary(indexedSalary);
            }
        }
    }

    public static Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateTotalSalaryExpensesByDepartment(int department) {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static double calculateAverageSalaryByDepartment(int department) {
        double totalSalary = calculateTotalSalaryExpensesByDepartment(department);
        int employeeCount = countEmployeesByDepartment(department);
        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }

    public static void indexSalaryByDepartment(int department, double percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary + (currentSalary * (percentage / 100));
                employee.setSalary(indexedSalary);
            }
        }
    }

    public static void printEmployeesByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ID: " + employee.getId() + ", " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryLessThan(double threshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < threshold) {
                System.out.println("ID: " + employee.getId() + ", " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryGreaterThan(double threshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= threshold) {
                System.out.println("ID: " + employee.getId() + ", " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    private static int countEmployeesByDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }
}