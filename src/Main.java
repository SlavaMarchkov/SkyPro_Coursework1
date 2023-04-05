import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"Иван", "Максим", "Виктор", "Андрей", "Дмитрий", "Егор", "Игорь", "Вячеслав"};
    private static final String[] SURNAMES = {"Иванов", "Максимов", "Викторов", "Андреев", "Дмитриев", "Егоров", "Абдурахманов", "Славин"};
    private static final String[] MIDDLE_NAMES = {"Иванович", "Максимович", "Викторович", "Андреевич", "Дмитриевич", "Егорович", "Абдурахманович", "Вячеславович"};
    private static final int DEPARTMENT = 4;
    private static final int BENCHMARK = 75_000;
    private static final int INDEX_PERCENT = 10;

    public static void main(String[] args) {

        // ** Задания уровня "Очень сложно"
        System.out.println("================= Уровень \"Очень сложно\" ======================");

        EmployeeBook employeeBook = new EmployeeBook();

        // ** Добавить сотрудника
        fillEmployees(employeeBook);
        employeeBook.addEmployee(new Employee("Звонов Дмитрий Федорович", 40_000, 4));
        employeeBook.addEmployee(new Employee("Звонов Дмитрий Федорович", 50_000, 4));

        // ** Удалить сотрудника по ФИО
        employeeBook.removeEmployee("Звонов Дмитрий Федорович");
        employeeBook.removeEmployee("Пронькиндт Алексей Иванович");

        // ** Удалить сотрудника по ID
        employeeBook.removeEmployee(2);
        employeeBook.removeEmployee(19);

        // ** Обратно добавить удаленного сотрудника
        employeeBook.addEmployee(new Employee("Звонов Дмитрий Федорович", 40_000, 4));

        // ** Изменить зарплату сотрудника по ФИО
        employeeBook.setSalaryByName("Звонов Дмитрий Федорович", 60_000);
        employeeBook.setSalaryByName("Марчков Дмитрий Федорович", 60_000);
        employeeBook.setSalaryByName(employeeBook.getEmployeeWithMinSalary().getFullName(), 90_000);

        // ** Изменить отдел, где работает сотрудник по его ФИО
        employeeBook.setDepartmentByName("Звонов Дмитрий Федорович", 1);
        employeeBook.setDepartmentByName(employeeBook.getEmployeeWithMinSalary().getFullName(), DEPARTMENT);

        // ** Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
        employeeBook.printAllEmployeesDataGroupedByDepartment();

        // Задания уровня "Базовая сложность"
        System.out.println("================= Уровень \"Базовая сложность\" ======================");
        // Получить список всех сотрудников со всеми имеющимися по ним данными
        employeeBook.printAllEmployeesData();

        // Посчитать сумму затрат на зарплаты в месяц
        int totalMonthlySalary = employeeBook.calcTotalMonthlySalary();
        System.out.println("Сумма затрат на зарплаты в месяц: " + totalMonthlySalary + " руб.");

        // Найти сотрудника с минимальной зарплатой
        Employee employeeWithMinimumSalary = employeeBook.getEmployeeWithMinSalary();
        System.out.println("Сотрудник с мин. ЗП: " + employeeWithMinimumSalary);

        // Найти сотрудника с максимальной зарплатой
        Employee employeeWithMaximumSalary = employeeBook.getEmployeeWithMaxSalary();
        System.out.println("Сотрудник с макс. ЗП: " + employeeWithMaximumSalary);

        // Подсчитать среднее значение зарплат
        double averageMonthlySalary = employeeBook.calcAverageMonthlySalary();
        System.out.println("Среднее значение зарплат в месяц: " + averageMonthlySalary + " руб.");

        // Получить Ф. И. О. всех сотрудников (вывести в консоль)
        employeeBook.printEmployeesFullNames();

        // Задания уровня "Повышенная сложность"
        System.out.println("================= Уровень \"Повышенная сложность\" ======================");

        // * 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        System.out.println("================= Task 1 ======================");

        employeeBook.changeEmployeesSalary(INDEX_PERCENT);
        System.out.printf("ЗП после индексации на %d%%%n", INDEX_PERCENT);
        employeeBook.printAllEmployeesData();

        // * 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
        System.out.println("================= Task 2 ======================");

        //    1. Сотрудника с минимальной зарплатой.
        String employeeWithMinimumSalaryInDepartment = employeeBook.getEmployeeWithMinSalary(DEPARTMENT) == null
                ? "Сотрудников в отделе %d не найдено %n"
                : "Сотрудник с мин. ЗП в отделе %d: " + employeeBook.getEmployeeWithMinSalary(DEPARTMENT) + "%n";
        System.out.printf(employeeWithMinimumSalaryInDepartment, DEPARTMENT);

        //    2. Сотрудника с максимальной зарплатой.
        String employeeWithMaximumSalaryInDepartment = employeeBook.getEmployeeWithMaxSalary(DEPARTMENT) == null
                ? "Сотрудников в отделе %d не найдено %n"
                : "Сотрудник с макс. ЗП в отделе %d: " + employeeBook.getEmployeeWithMaxSalary(DEPARTMENT) + "%n";
        System.out.printf(employeeWithMaximumSalaryInDepartment, DEPARTMENT);

        //    3. Сумму затрат на зарплату по отделу.
        int totalMonthlySalaryInDepartment = employeeBook.calcTotalMonthlySalary(DEPARTMENT);
        System.out.printf("Сумма затрат на зарплаты отдела %d в месяц: %d руб.%n", DEPARTMENT, totalMonthlySalaryInDepartment);

        //    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        double averageMonthlySalaryInDepartment = employeeBook.calcAverageMonthlySalary(DEPARTMENT);
        System.out.println("Среднее значение зарплат отдела " + DEPARTMENT + " в месяц: " + averageMonthlySalaryInDepartment + " руб.");

        //    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        employeeBook.changeEmployeesSalary(INDEX_PERCENT, DEPARTMENT);
        employeeBook.printAllEmployeesData();

        //    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        System.out.println("Все сотрудники отдела " + DEPARTMENT);
        employeeBook.printDepartmentEmployeesData(DEPARTMENT);

        // * 3. Получить в качестве параметра число и найти:
        //    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        //    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("================= Task 3 ======================");

        System.out.println("Сотрудники с зарплатой меньше чем " + BENCHMARK + " рублей:");
        employeeBook.printEmployeesWithSalaryLowerThanBenchmark(BENCHMARK);

        System.out.println("Сотрудники с зарплатой больше или равной " + BENCHMARK + " рублей:");
        employeeBook.printEmployeesWithSalaryHigherThanBenchmark(BENCHMARK);
    }

    private static void fillEmployees(EmployeeBook employeeBook) {
        for (int i = 0; i < 10; i++) {
            employeeBook.addEmployee(generate());
        }
    }

    private static Employee generate() {
        String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)]
                + ' ' + NAMES[RANDOM.nextInt(NAMES.length)]
                + ' ' + MIDDLE_NAMES[RANDOM.nextInt(MIDDLE_NAMES.length)];
        return new Employee(
                fullName,
                RANDOM.nextInt(45_000, 90_000),
                RANDOM.nextInt(1, 6)
        );
    }
}