package main;

import dao.DeptDAO;
import dao.StudentDAO;
import model.Student;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			StudentDAO dao = new StudentDAO();

			while (true) {

			    System.out.println("\n===== Student Management System =====");

			    System.out.println("1. Add Student");
			    System.out.println("2. View Students");
			    System.out.println("3. Update Student");
			    System.out.println("4. Delete Student");
			    System.out.println("5. View Departments");
			    System.out.println("6. Exit");

			    System.out.print("Enter Choice: ");

			    int choice = sc.nextInt();

			    switch (choice) {

			        case 1:

			            System.out.print("Enter ID: ");
			            int id = sc.nextInt();
			            sc.nextLine();

			            System.out.print("Enter Name: ");
			            String name = sc.nextLine();

			            System.out.print("Enter Department: ");
			            String dept = sc.nextLine();

			            Student s = new Student(id, name, dept);

			            dao.addStudent(s);

			            break;

			        case 2:

			            dao.viewStudents();

			            break;

			        case 3:

			            System.out.print("Enter Student ID to Update: ");
			            int uid = sc.nextInt();
			            sc.nextLine();

			            System.out.print("Enter New Name: ");
			            String uname = sc.nextLine();

			            System.out.print("Enter New Department: ");
			            String udept = sc.nextLine();

			            dao.updateStudent(uid, uname, udept);

			            break;

			        case 4:

			            System.out.print("Enter Student ID to Delete: ");
			            int did = sc.nextInt();

			            dao.deleteStudent(did);

			            break;
			        case 5:
			        	DeptDAO.showDepartments();
			        	break;

			        case 6:

			            System.out.println("Program Ended");
			            System.exit(0);
			    }
			}
		}
    }
}