public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Алексей", "Иванович", "Пронькин", 30000, 3);
        employees[1] = new Employee("Андрей", "Михайлович", "Кузькин", 40000, 1);
        employees[2] = new Employee("Кузьма", "Андреевич", "Медведев", 50000, 2);
        employees[3] = new Employee("София", "Агаповна", "Собакевич", 60000, 3);
        employees[4] = new Employee("Елена", "Вячеславовна", "Дмитриева", 20000, 5);
        employees[5] = new Employee("Александр", "Дмитриевич", "Ходоренко", 10000, 4);
        employees[6] = new Employee("Дмитрий", "Федорович", "Звонов", 30000, 2);
        employees[7] = new Employee("Елисей", "Дмитриевич", "Волков", 70000, 5);
        employees[8] = new Employee("Роман", "Карлович", "Мудрый", 30000, 3);
        employees[9] = new Employee("Галина", "Евгеньевна", "Тузова", 110000, 1);

        // Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString))
        printAllEmployeesData();

        // Посчитать сумму затрат на зарплаты в месяц
        int totalMonthlySalary = calcTotalMonthlySalary();
        System.out.println("Сумма затрат на зарплаты в месяц: " + totalMonthlySalary + " руб.");

        // Найти сотрудника с минимальной зарплатой
        String employeeWithMinimumSalary = getEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithMinimumSalary);

        // Найти сотрудника с максимальной зарплатой
        String employeeWithMaximumSalary = getEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaximumSalary);

        // Подсчитать среднее значение зарплат
        int averageMonthlySalary = calcAverageMonthlySalary();
        System.out.println("Среднее значение зарплат в месяц: " + averageMonthlySalary + " руб.");

        // Получить Ф. И. О. всех сотрудников (вывести в консоль)
        printEmployeesFullNames();
    }

    private static void printEmployeesFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    private static String getEmployeeWithMaxSalary() {
        int maxSalary = employees[0].getSalary();
        String fullName = null;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                fullName = employees[i].getFullName();
            }
        }
        return fullName;
    }

    private static String getEmployeeWithMinSalary() {
        int minSalary = employees[0].getSalary();
        String fullName = null;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                fullName = employees[i].getFullName();
            }
        }
        return fullName;
    }

    private static int calcAverageMonthlySalary() {
        return calcTotalMonthlySalary() / employees.length;
    }

    private static int calcTotalMonthlySalary() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    private static void printAllEmployeesData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}