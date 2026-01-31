public class Employee {

    private Integer id;
    private String name;
    private String department;
    private Double salary;

    public Employee(Integer id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Salary=" + salary;
    }
}