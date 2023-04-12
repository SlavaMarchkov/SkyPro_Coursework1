import java.util.Objects;

public class Employee {

    private final String fullName;
    private int salary; // зарплата
    private int department; // отдел
    private static int counter = 1; // счётчик
    private final int id; // поле id, которое проставляется из счетчика

    public Employee(
            String fullName,
            int salary,
            int department
    ) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
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
        this.salary = Math.max(salary, 0);
    }

    public void setDepartment(int department) {
        this.department = (department >= 1 && department <= 5) ? department : 1;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, ФИО: %s, ЗП: %d, отдел: %d",
                id,
                getFullName(),
                salary,
                department
        );
    }

    public String getEmployeeData() {
        return "ID: " + getId() + " | ФИО: " + getFullName() + " | зарплата: " + getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
