public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployee(String fullName);

    void removeEmployee(int id);
}
