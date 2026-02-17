package com.kodnest.employeemanagementsystem;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    private SessionFactory factory;
    private Scanner sc = new Scanner(System.in);

    public HibernateApp() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    // ADD EMPLOYEE
    public void addEmployee() {
        System.out.println("Enter name salary designation department");

        Product emp = new Product(
                sc.next(),
                sc.nextDouble(),
                sc.next(),
                sc.next()
        );

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("Employee added successfully");
    }

    // GET EMPLOYEE
    public void getEmployeeById() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();

        Session session = factory.openSession();
        Product emp = session.get(Product.class, id);

        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found");
        }

        session.close();
    }

    // DELETE EMPLOYEE
    public void deleteEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product emp = session.get(Product.class, id);
        if (emp != null) {
            session.remove(emp);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }

        tx.commit();
        session.close();
    }

    // UPDATE EMPLOYEE
    public void updateEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product emp = session.get(Product.class, id);

        if (emp != null) {
            System.out.println("1.Name 2.Salary 3.Designation 4.Department");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new name");
                    emp.setEmpName(sc.next());
                }
                case 2 -> {
                    System.out.println("Enter new salary");
                    emp.setEmpSalary(sc.nextDouble());
                }
                case 3 -> {
                    System.out.println("Enter new designation");
                    emp.setEmpdesignation(sc.next());
                }
                case 4 -> {
                    System.out.println("Enter new department");
                    emp.setEmpdepartment(sc.next());
                }
            }
            session.merge(emp);
            System.out.println("Employee updated");
        } else {
            System.out.println("Employee not found");
        }

        tx.commit();
        session.close();
    }

    public void close() {
        factory.close();
    }
}
