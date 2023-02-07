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
        // проверка на допустимое количество
        if (getSize() >= employees.length) {
            System.out.println("Контора укомплектована сотрудниками до отказа!");
            return;
        }
        // создаем объект, заполняем поля через конструктор класса Employee
        Employee newEmployee = new Employee(firstName, middleName, lastName, salary, department);
        // кладем в массив в счетчик size, увеличиваем счетчик на единицу
        employees[size++] = newEmployee;
//        System.out.println(Arrays.toString(employees));
    }

    public void removeEmployeeById(int id) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getId() == id) {
                employees[i] = null;
                System.out.println("Сотрудник с ID " + id + " удалён!");
                return;
            }
        }
    }

    public Employee findEmployeeByName(String fullName) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return null;
    }

    public void setSalaryByName(String fullName, int newSalary) {
        Employee foundEmployee = findEmployeeByName(fullName);
        foundEmployee.setSalary(newSalary);
    }

    public void setDepartmentByName(String fullName, int newDepartment) {
        Employee foundEmployee = findEmployeeByName(fullName);
        foundEmployee.setDepartment(newDepartment);
    }

    public void printEmployeesWithSalaryHigherThanBenchmark(int benchmark) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= benchmark) {
                System.out.println(employee.getEmployeeData());
            }
        }
    }

    public void printEmployeesWithSalaryLowerThanBenchmark(int benchmark) {
        for (Employee employee : employees) {
            if (employee.getSalary() < benchmark) {
                System.out.println(employee.getEmployeeData());
            }
        }
    }

    private Employee[] getEmployeesByDepartment(int department) {
        Employee[] temp = new Employee[employees.length];
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                temp[count++] = employee;
            }
        }
        return trim(temp, count);
    }

    private Employee[] trim(Employee[] array, int count) {
        Employee[] result = new Employee[count];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    public void printDepartmentEmployeesData(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees) {
            System.out.println(employee.getEmployeeData());
        }
    }

    public void changeEmployeesSalary(int percent) {
        for (Employee employee : employees) {
            int salary = employee.getSalary() + employee.getSalary() * percent / 100;
            employee.setSalary(salary);
        }
    }

    public void changeEmployeesSalary(int percent, int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        for (Employee employee : departmentEmployees) {
            int salary = employee.getSalary() + employee.getSalary() * percent / 100;
            employee.setSalary(salary);
        }
    }

    public void printEmployeesFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
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

    private String getEmployeeNameWithMaxSalary(Employee[] array) {
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

    public String getEmployeeWithMinSalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return (departmentEmployees.length == 0)
                ? "В отделе нет сотрудников"
                : getEmployeeNameWithMinSalary(departmentEmployees);
    }

    public String getEmployeeWithMinSalary() {
        return getEmployeeNameWithMinSalary(employees);
    }

    private String getEmployeeNameWithMinSalary(Employee[] array) {
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

    public int calcAverageMonthlySalary(int department) {
        Employee[] departmentEmployees = getEmployeesByDepartment(department);
        return calcTotalMonthlySalary(department) / departmentEmployees.length;
    }

    public int calcAverageMonthlySalary() {
        return calcTotalMonthlySalary() / employees.length;
    }

    /**
     * Считает общую зарплату за месяц
     *
     * @return int
     */
    public int calcTotalMonthlySalary() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
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
            total += employee.getSalary();
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

    private int getSize() {
        return size;
    }

}
