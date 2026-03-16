package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;

public class StudentDAO {

    public void addStudent(Student student) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "insert into student values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDepartment());

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "select * from student";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, String dept) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "update student set name=?, department=? where id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "delete from student where id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}