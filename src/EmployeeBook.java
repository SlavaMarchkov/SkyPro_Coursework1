public class EmployeeBook {

    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    /**
     * Добавляет нового сотрудника типа Employee в массив employees с проверкой на допустимое количество
     *
     * @param firstName  String
     * @param middleName String
     * @param lastName   String
     * @param salary     int
     * @param department int
     */
    public void addEmployee(String firstName, String middleName, String lastName, int salary, int department) {
        if (size >= employees.length) {
            System.out.println("Контора укомплектована сотрудниками до отказа!");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                // создаем объект, заполняем поля через конструктор класса Employee
                Employee newEmployee = new Employee(firstName, middleName, lastName, salary, department);
                // кладем в массив в счетчик size, увеличиваем счетчик на единицу
                employees[i] = newEmployee;
                size++;
                break;
            }
        }
    }

    /**
     * Удаляет сотрудника по ID (обнуляет ячейку в массиве сотрудников)
     *
     * @param id int
     */
    public void removeEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getId() == id) {
                employees[i] = null;
                size--;
                System.out.println("Сотрудник с ID " + id + " удалён!");
                return;
            }
        }
    }

    /**
     * Удаляет сотрудника по ФИО (обнуляет ячейку в массиве сотрудников)
     *
     * @param fullName String
     */
    public void removeEmployeeByName(String fullName) {
        Employee foundEmployee = findEmployeeByName(fullName);
        if (foundEmployee == null) {
            System.out.println("Сотрудник \"" + fullName + "\" не найден!");
        } else {
            int id = foundEmployee.getId();
            employees[id] = null;
            size--;
            System.out.println("Сотрудник \"" + fullName + "\" удалён!");
        }
    }

    /**
     * Ищет сотрудника по ФИО
     *
     * @param fullName String
     * @return Employee|null - если сотрудник не найден, возвращает null
     */
    private Employee findEmployeeByName(String fullName) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return null;
    }

    public void setSalaryByName(String fullName, int newSalary) {
        Employee foundEmployee = findEmployeeByName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setSalary(newSalary);
            System.out.println("Зарплата сотрудника \"" + fullName + "\" изменена. Новая зарплата: " + newSalary + " руб.");
        } else {
            System.out.println("Сотрудник \"" + fullName + "\" не найден!");
        }
    }

    public void setDepartmentByName(String fullName, int newDepartment) {
        Employee foundEmployee = findEmployeeByName(fullName);
        if (foundEmployee != null) {
            foundEmployee.setDepartment(newDepartment);
            System.out.println("Отдел сотрудника \"" + fullName + "\" изменён. Новый отдел: " + newDepartment);
        } else {
            System.out.println("Сотрудник \"" + fullName + "\" не найден!");
        }
    }

    /**
     * Выводит в консоль список сотрудников с зарплатой больше заданного числа или равной
     *
     * @param benchmark int
     */
    public void printEmployeesWithSalaryHigherThanBenchmark(int benchmark) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= benchmark) {
                System.out.println(employee.getEmployeeData());
            }
        }
    }

    /**
     * Выводит в консоль список сотрудников с зарплатой меньше заданного числа
     *
     * @param benchmark int
     */
    public void printEmployeesWithSalaryLowerThanBenchmark(int benchmark) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < benchmark) {
                System.out.println(employee.getEmployeeData());
            }
        }
    }

    /**
     * Получает массив сотрудников одного отдела длиной исходного массива
     *
     * @param department int
     * @return Employee[]
     */
    private Employee[] getEmployeesByDepartment(int department) {
        Employee[] temp = new Employee[employees.length];
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                temp[count++] = employee;
            }
        }
        return trim(temp, count);
    }

    /**
     * Обрезает массив
     *
     * @param array Employee[]
     * @param count int
     * @return Employee[]
     */
    private Employee[] trim(Employee[] array, int count) {
        Employee[] result = new Employee[count];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    /**
     * Выводит на экран данные сотрудников одного отдела
     *
     * @param department int
     */
    public void printDepartmentEmployeesData(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees) {
            System.out.println(employee.getEmployeeData());
        }
    }

    /**
     * Индексирует зарплату всех сотрудников
     *
     * @param percent int
     */
    public void changeEmployeesSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                int salary = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary(salary);
            }
        }
    }

    /**
     * Индексирует зарплату сотрудников по отделу
     *
     * @param percent    int
     * @param department int
     */
    public void changeEmployeesSalary(int percent, int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees) {
            int salary = employee.getSalary() + employee.getSalary() * percent / 100;
            employee.setSalary(salary);
        }
    }

    public void printEmployeesFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public String getEmployeeWithMaxSalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (departmentEmployees.length == 0)
                ? "В отделе нет сотрудников"
                : getEmployeeNameWithMaxSalary(departmentEmployees);
    }

    public String getEmployeeWithMaxSalary() {
        return getEmployeeNameWithMaxSalary(employees);
    }

    /**
     * Получает ФИО сотрудника с максимальной зарплатой
     *
     * @param array Employee
     * @return String
     */
    private String getEmployeeNameWithMaxSalary(Employee[] array) {
        int maxSalary = array[0].getSalary();
        String fullName = null;
        for (int i = 1; i < array.length; i++) {
            Employee employee = array[i];
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                fullName = employee.getFullName();
            }
        }
        return fullName;
    }

    public String getEmployeeWithMinSalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (departmentEmployees.length == 0)
                ? "В отделе нет сотрудников"
                : getEmployeeNameWithMinSalary(departmentEmployees);
    }

    public String getEmployeeWithMinSalary() {
        return getEmployeeNameWithMinSalary(employees);
    }

    /**
     * Получает ФИО сотрудника с минимальной зарплатой
     *
     * @param array Employee
     * @return String
     */
    private String getEmployeeNameWithMinSalary(Employee[] array) {
        int minSalary = array[0].getSalary();
        String fullName = null;
        for (int i = 1; i < array.length; i++) {
            Employee employee = array[i];
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                fullName = employee.getFullName();
            }
        }
        return fullName;
    }

    public float calcAverageMonthlySalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (float) calcTotalMonthlySalary(department) / departmentEmployees.length;
    }

    public float calcAverageMonthlySalary() {
        return (float) calcTotalMonthlySalary() / getSize();
    }

    /**
     * Считает общую зарплату за месяц
     *
     * @return int
     */
    public int calcTotalMonthlySalary() {
        int total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    /**
     * Считает общую зарплату за месяц по отделу
     *
     * @param department int - номер отдела
     * @return int
     */
    public int calcTotalMonthlySalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        int total = 0;
        for (Employee employee : departmentEmployees) {
            if (employee != null) {
                System.out.println(employee.getFullName() + " | " + employee.getSalary());
                total += employee.getSalary();
            }
        }
        return total;
    }

    /**
     * Выводит методом toString() все данные о всех сотрудниках
     */
    public void printAllEmployeesData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Получает количество заполненных элементов массива сотрудников
     *
     * @return int
     */
    private int getSize() {
        return size;
    }

    /**
     * Выводит на экран список сотрудников по каждому отделу
     */
    public void printAllEmployeesDataGroupedByDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i);
            Employee[] departmentEmployees = getEmployeesByDepartment(i);
            if (departmentEmployees.length > 0) {
                for (Employee employee : departmentEmployees) {
                    System.out.println(employee.getFullName());
                }
            } else {
                System.out.println("В отделе нет сотрудников");
            }
        }
    }
}
