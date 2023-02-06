public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Алексей", "Иванович", "Пронькин", 30000, 3);
        employees[1] = new Employee("Андрей", "Михайлович", "Кузькин", 40000, 1);
        employees[2] = new Employee("Кузьма", "Андреевич", "Медведев", 30000, 1);
        employees[3] = new Employee("София", "Агаповна", "Собакевич", 60000, 3);
        employees[4] = new Employee("Елена", "Вячеславовна", "Дмитриева", 20000, 5);
        employees[5] = new Employee("Александр", "Дмитриевич", "Ходоренко", 10000, 5);
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
//        printEmployeesFullNames();

        // * Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        int percent = 10;
        changeAllEmployeesSalary(percent);
        printAllEmployeesData();

        // * 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
        int department = 5;

        //    1. Сотрудника с минимальной зарплатой.
        String employeeWithMinimumSalaryInDepartment = getEmployeeWithMinSalary(department) == null
            ? "Зарплаты сотрудников в департаменте " + department + " равны"
            : "Сотрудник с минимальной зарплатой в департаменте " + department + ": " + getEmployeeWithMinSalary(department);
        System.out.println(employeeWithMinimumSalaryInDepartment);

        //    2. Сотрудника с максимальной зарплатой.
        String employeeWithMaximumSalaryInDepartment = getEmployeeWithMaxSalary(department) == null
            ? "Зарплаты сотрудников в департаменте " + department + " равны"
            : "Сотрудник с максимальной зарплатой в департаменте " + department + ": " + getEmployeeWithMaxSalary(department);
        System.out.println(employeeWithMaximumSalaryInDepartment);

        //    3. Сумму затрат на зарплату по отделу.
        int totalMonthlySalaryInDepartment = calcTotalMonthlySalary(department);
        System.out.println("Сумма затрат на зарплаты департамента " + department + " в месяц: " + totalMonthlySalaryInDepartment + " руб.");

        //    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        //    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        //    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        printDepartmentEmployeesData(department);
    }

    private static Employee[] getEmployeesByDepartment(int department) {
        Employee[] temp = new Employee[employees.length];
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                temp[count++] = employee;
            }
        }
        return trim(temp, count);
    }

    private static Employee[] trim(Employee[] array, int count) {
        Employee[] result = new Employee[count];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    private static void printDepartmentEmployeesData(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getEmployeeData());
            }
        }
    }

    private static void changeAllEmployeesSalary(int percent) {
        for (Employee employee : employees) {
            int salary = employee.getSalary() + employee.getSalary() * percent / 100;
            employee.setSalary(salary);
        }
    }

    private static void printEmployeesFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    private static String getEmployeeWithMaxSalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (departmentEmployees.length == 0)
                ? "В отделе нет сотрудников"
                : getEmployeeNameWithMaxSalary(departmentEmployees);
    }

    private static String getEmployeeWithMaxSalary() {
        return getEmployeeNameWithMaxSalary(employees);
    }

    private static String getEmployeeNameWithMaxSalary(Employee[] array) {
        int maxSalary = array[0].getSalary();
        String fullName = null;
        for (int i = 1; i < array.length; i++) {
            Employee employee = array[i];
            if (employee.getSalary() > maxSalary) {
                fullName = employee.getFullName();
            }
        }
        return fullName;
    }

    private static String getEmployeeWithMinSalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (departmentEmployees.length == 0)
                ? "В отделе нет сотрудников"
                : getEmployeeNameWithMinSalary(departmentEmployees);
    }

    private static String getEmployeeWithMinSalary() {
        return getEmployeeNameWithMinSalary(employees);
    }

    private static String getEmployeeNameWithMinSalary(Employee[] array) {
        int minSalary = array[0].getSalary();
        String fullName = null;
        for (int i = 1; i < array.length; i++) {
            Employee employee = array[i];
            if (employee.getSalary() < minSalary) {
                fullName = employee.getFullName();
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
    private static int calcTotalMonthlySalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        int total = 0;
        for (Employee employee : departmentEmployees) {
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