public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

//        employees[0] = new Employee("Алексей", "Иванович", "Пронькин", 30000, 3);
//        employees[1] = new Employee("Андрей", "Михайлович", "Кузькин", 40000, 1);
//        employees[2] = new Employee("Кузьма", "Андреевич", "Медведев", 30000, 1);
//        employees[3] = new Employee("София", "Агаповна", "Собакевич", 60000, 3);
//        employees[4] = new Employee("Елена", "Вячеславовна", "Дмитриева", 20000, 5);
//        employees[5] = new Employee("Александр", "Дмитриевич", "Ходоренко", 10000, 5);
//        employees[6] = new Employee("Дмитрий", "Федорович", "Звонов", 30000, 2);
//        employees[7] = new Employee("Елисей", "Дмитриевич", "Волков", 70000, 5);
//        employees[8] = new Employee("Роман", "Карлович", "Мудрый", 30000, 3);
//        employees[9] = new Employee("Галина", "Евгеньевна", "Тузова", 110000, 1);


        // Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString))
        employeeBook.printAllEmployeesData();

        // Посчитать сумму затрат на зарплаты в месяц
        int totalMonthlySalary = employeeBook.calcTotalMonthlySalary();
        System.out.println("Сумма затрат на зарплаты в месяц: " + totalMonthlySalary + " руб.");

        // Найти сотрудника с минимальной зарплатой
        String employeeWithMinimumSalary = employeeBook.getEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithMinimumSalary);

        // Найти сотрудника с максимальной зарплатой
        String employeeWithMaximumSalary = employeeBook.getEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaximumSalary);

        // Подсчитать среднее значение зарплат
        int averageMonthlySalary = employeeBook.calcAverageMonthlySalary();
        System.out.println("Среднее значение зарплат в месяц: " + averageMonthlySalary + " руб.");

        // Получить Ф. И. О. всех сотрудников (вывести в консоль)
        employeeBook.printEmployeesFullNames();

        // * 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        System.out.println("================= Task 1 ======================");

        int percent = 10;

        employeeBook.changeEmployeesSalary(percent);
        employeeBook.printAllEmployeesData();

        // * 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
        System.out.println("================= Task 2 ======================");

        int department = 5;

        //    1. Сотрудника с минимальной зарплатой.
        String employeeWithMinimumSalaryInDepartment = employeeBook.getEmployeeWithMinSalary(department) == null
                ? "Зарплаты сотрудников в департаменте " + department + " равны"
                : "Сотрудник с минимальной зарплатой в департаменте " + department + ": " + employeeBook.getEmployeeWithMinSalary(department);
        System.out.println(employeeWithMinimumSalaryInDepartment);

        //    2. Сотрудника с максимальной зарплатой.
        String employeeWithMaximumSalaryInDepartment = employeeBook.getEmployeeWithMaxSalary(department) == null
                ? "Зарплаты сотрудников в департаменте " + department + " равны"
                : "Сотрудник с максимальной зарплатой в департаменте " + department + ": " + employeeBook.getEmployeeWithMaxSalary(department);
        System.out.println(employeeWithMaximumSalaryInDepartment);

        //    3. Сумму затрат на зарплату по отделу.
        int totalMonthlySalaryInDepartment = employeeBook.calcTotalMonthlySalary(department);
        System.out.println("Сумма затрат на зарплаты департамента " + department + " в месяц: " + totalMonthlySalaryInDepartment + " руб.");

        //    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        int averageMonthlySalaryInDepartment = employeeBook.calcAverageMonthlySalary(department);
        System.out.println("Среднее значение зарплат департамента " + department + " в месяц: " + averageMonthlySalaryInDepartment + " руб.");

        //    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        employeeBook.changeEmployeesSalary(percent, department);
        employeeBook.printAllEmployeesData();

        //    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        employeeBook.printDepartmentEmployeesData(department);

        // * 3. Получить в качестве параметра число и найти:
        //    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        //    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("================= Task 3 ======================");

        int benchmark = 33000;

        System.out.println("Сотрудники с зарплатой меньше чем " + benchmark + " рублей:");
        employeeBook.printEmployeesWithSalaryLowerThanBenchmark(benchmark);

        System.out.println("Сотрудники с зарплатой больше или равной " + benchmark + " рублей:");
        employeeBook.printEmployeesWithSalaryHigherThanBenchmark(benchmark);
    }
}