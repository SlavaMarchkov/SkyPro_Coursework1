public class Employee {

    private final String firstName; // имя
    private final String middleName; // отчество
    private final String lastName; // фамилия
    private int salary; // зарплата
    private int department; // отдел
    private static int counter = 0; // счётчик
    private final int id = counter; // поле id, которое проставляется из счетчика

    public Employee(String firstName, String middleName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = (salary >= 0) ? salary : 0;
    }

    public void setDepartment(int department) {
        this.department = (department >= 1 && department <= 5) ? department : 1;
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "id=" + id +
                ", имя='" + firstName + '\'' +
                ", отчество='" + middleName + '\'' +
                ", фамилия='" + lastName + '\'' +
                ", зарплата=" + salary +
                ", отдел=" + department +
                '}';
    }

    public String getFullName() {
        return getLastName() + " " + getFirstName() + " " + getMiddleName();
    }

    public String getEmployeeData() {
        return "ID: " + getId() + " | ФИО: " + getFullName() + " | зарплата: " + getSalary();
    }
}
