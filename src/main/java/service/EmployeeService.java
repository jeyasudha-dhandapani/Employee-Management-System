package service;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee emp = new Employee(0, name, dept, salary);
        dao.addEmployee(emp);
    }

    public void viewAllEmployees() {
        List<Employee> list = dao.getAllEmployees();
        System.out.println("---- Employee List ----");
        for (Employee e : list) {
            System.out.println(e.getId() + " | " + e.getName() + " | " +
                               e.getDepartment() + " | " + e.getSalary());
        }
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee emp = new Employee(id, name, dept, salary);
        dao.updateEmployee(emp);
    }

    public void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        dao.deleteEmployee(id);
    }
}

