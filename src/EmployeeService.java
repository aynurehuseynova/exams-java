
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // ADD EMPLOYEE (Custom Exception)
    public void addEmployee(Employee employee) {
        if (employeeMap.containsKey(employee.getId())) {
            throw new EmployeeAlreadyExistsException(
                    "Employee with ID " + employee.getId() + " already exists"
            );
        }
        employeeList.add(employee);
        employeeMap.put(employee.getId(), employee);
    }

    // REMOVE
    public void removeEmployee(int id) {
        Employee removed = employeeMap.remove(id);
        if (removed == null) {
            System.out.println("Employee not found");
            return;
        }
        employeeList.remove(removed);
        System.out.println("Employee removed");
    }

    // SHOW ALL
    public void showAll() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees");
            return;
        }
        employeeList.forEach(System.out::println);
    }

    // SORT BY NAME ASC
    public void sortByName() {
        employeeList.sort(Comparator.comparing(Employee::getName));
        showAll();
    }

    // SORT BY SALARY DESC
    public void sortBySalaryDesc() {
        employeeList.sort(Comparator.comparing(Employee::getSalary).reversed());
        showAll();
    }

    // SORT BY DEPARTMENT THEN NAME
    public void sortByDepartmentThenName() {
        employeeList.sort(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getName)
        );
        showAll();
    }

    // SEARCH BY ID (Optional)
    public void searchById(int id) {
        Optional.ofNullable(employeeMap.get(id))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Employee not found")
                );
    }

    // SEARCH BY NAME (PARTIAL, STREAM)
    public void searchByName(String keyword) {
        List<Employee> result = employeeList.stream()
                .filter(e -> e.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Employee not found");
        } else {
            result.forEach(System.out::println);
        }
    }

    // SALARY ANALYTICS (STREAM ONLY)
    public void salaryAnalytics() {

        double average = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("Average salary: " + average);

        employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(e ->
                        System.out.println("Highest salary: " + e)
                );

        System.out.println("Top 3 salaries:");
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}