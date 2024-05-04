package com.helloworld;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "root";
        String password = "root";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); 

            // 假设你有一个学生列表
            List<Student> students = getStudents(); // 获取学生列表

            String sql1 = "INSERT INTO student(id, name) VALUES(?, ?)";
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            
            String sql2 = "INSERT INTO scores(student_id, course, score) VALUES(?, ?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            
            // 处理每一个学生和他们的分数
            for (Student student : students) {
                // 插入主表数据
                pstmt1.setInt(1, student.getId());
                pstmt1.setString(2, student.getName());
                pstmt1.addBatch();

                // 插入子表数据
                List<Score> scores = student.getScores(); 
                for (Score score : scores) {
                    pstmt2.setInt(1, student.getId());
                    pstmt2.setString(2, score.getCourse());
                    pstmt2.setDouble(3, score.getScore());
                    pstmt2.addBatch();
                }
            }

            pstmt1.executeBatch();
            pstmt2.executeBatch();

            conn.commit(); 

            pstmt1.close();
            pstmt2.close();

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // 假设的获取学生列表的方法
    private static List<Student> getStudents() {
        // 这里只是示例，你可以根据需要实现
        return new ArrayList<>();
    }
}

@Data
class Student {
    Integer id;
    String name;
    List<Score> scores;
}

@Data
class Score {
    String course;
    Double score;
}