
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Show All Employees");
            System.out.println("4. Sort by Name (ASC)");
            System.out.println("5. Sort by Salary (DESC)");
            System.out.println("6. Sort by Department then Name");
            System.out.println("7. Search by ID");
            System.out.println("8. Search by Name");
            System.out.println("9. Salary Analytics");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Department: ");
                        String dep = scanner.nextLine();

                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();

                        service.addEmployee(new Employee(id, name, dep, salary));
                        System.out.println("Employee added");

                    } catch (EmployeeAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("ID: ");
                    service.removeEmployee(scanner.nextInt());
                    break;

                case 3:
                    service.showAll();
                    break;

                case 4:
                    service.sortByName();
                    break;

                case 5:
                    service.sortBySalaryDesc();
                    break;

                case 6:
                    service.sortByDepartmentThenName();
                    break;

                case 7:
                    System.out.print("ID: ");
                    service.searchById(scanner.nextInt());
                    break;

                case 8:
                    scanner.nextLine();
                    System.out.print("Name: ");
                    service.searchByName(scanner.nextLine());
                    break;

                case 9:
                    service.salaryAnalytics();
                    break;

                case 10:
                    System.exit(0);
            }
        }
    }
}