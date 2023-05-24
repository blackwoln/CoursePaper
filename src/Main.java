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
            if (employee != null) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
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
}