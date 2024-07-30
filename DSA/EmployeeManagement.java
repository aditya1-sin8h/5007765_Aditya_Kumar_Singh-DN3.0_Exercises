class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployeeById(int employeeId) {
        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        for (int i = indexToRemove; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear the last element
        size--;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Adding employees
        ems.addEmployee(new Employee(1, "Aman", "Engineer", 70000));
        ems.addEmployee(new Employee(2, "Vidhya", "Manager", 80000));
        ems.addEmployee(new Employee(3, "Charles", "Analyst", 60000));

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        Employee employee = ems.searchEmployeeById(2);
        System.out.println("Search Result: " + (employee != null ? employee : "Employee not found"));

        // Deleting an employee
        ems.deleteEmployeeById(2);

        // Traversing employees after deletion
        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
