package main;

import java.util.*;
import dao.EmployeeDAO;
import model.Employee;

public class TestDB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(0,name, dept, salary);
                    dao.addEmployee(emp);
                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();
                    for (Employee e : list) {
                        System.out.println(
                            e.getId() + " " +
                            e.getName() + " " +
                            e.getDepartment() + " " +
                            e.getSalary()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter new department: ");
                    String udept = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    double usalary = sc.nextDouble();

                    Employee uemp = new Employee(uid, uname, udept, usalary);
                    dao.updateEmployee(uemp);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
