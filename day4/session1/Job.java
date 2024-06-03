package day4.session1;

import java.sql.*;
import java.util.Scanner;

public class Job {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\javaCourse\\src\\main\\java\\day4\\hr.db";
//        String quary = "select * from jobs";
        String quary = "insert into jobs values(?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url);

            //Statement st = connection.createStatement();
            PreparedStatement st = connection.prepareStatement(quary);

           // ResultSet rs = st.executeQuery(quary);

            System.out.println("Enter Job id: ");
            int jobId = sc.nextInt();
            st.setInt(1, jobId);
            sc.nextLine();

            System.out.println("Enter title: ");
            String jobTitle = sc.nextLine();
            st.setString(2, jobTitle);

            System.out.println("Enter min salary: ");
            double min_salary = sc.nextDouble();
            st.setDouble(3, min_salary);

            System.out.println("Enter max salary: ");
            double max_salary = sc.nextDouble();
            st.setDouble(4, max_salary);

//            while (rs.next()){
////                int job_id = rs.getInt(1);
////                String job_title = rs.getString(2);
//
//                JDBCJob d = new JDBCJob(rs);

                int rows = st.executeUpdate();

                System.out.println(rows + " rows inserted");

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
