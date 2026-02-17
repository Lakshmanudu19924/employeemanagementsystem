package com.kodnest.employeemanagementsystem;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        HibernateApp app = new HibernateApp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                1. Add Employee
                2. Get Employee
                3. Delete Employee
                4. Update Employee
                Any other number to Exit
                """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> app.addEmployee();
                case 2 -> app.getEmployeeById();
                case 3 -> app.deleteEmployee();
                case 4 -> app.updateEmployee();
                default -> {
                    app.close();
                    sc.close();
                    System.out.println("THANK YOU");
                    return;
                }
            }
        }
    }
}
