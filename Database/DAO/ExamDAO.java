package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import Message.ExamMessage;

public class ExamDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;

	public void setConn(Connection c) {
		this.conn = c;
	}

	// create table Student
	public void createTableExam() {
		try {
			System.out.println("Create table Exam!");

			sql = conn.prepareStatement(
					"create table Exam(ID int AUTO_INCREMENT PRIMARY KEY, student_id varchar(255), student_name varchar(255), student_onecard varchar(255), student_grade varchar(255), student_course varchar(255))");
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public void addExamContent(String student_id, String student_name, String student_onecard, String student_grade,
			String student_course) {
		try {
			System.out.println("Add Exam content:");

			sql = conn.prepareStatement(
					"insert into Exam (student_id,student_name,student_onecard,student_grade,student_course) values (?,?,?,?,?)");
			sql.setString(1, student_id);
			sql.setString(2, student_name);
			sql.setString(3, student_onecard);
			sql.setString(4, student_grade);
			sql.setString(5, student_course);
			sql.executeUpdate();
			
			//output
            System.out.print("学号: "+student_id);
            System.out.print("   学生姓名: "+student_name);
            System.out.print("   一卡通: "+student_onecard);
            System.out.print("   成绩: "+student_grade);
            System.out.println("   课程编号: "+student_course);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ExamMessage> queryExamMessage(String column, String x) {
		ArrayList<ExamMessage> arraylist = new ArrayList<>();
		try {
			System.out.println("Query!");
			System.out.println("查询学生信息中 " + column + " = " + x + " 的数据！");

			sql = conn.prepareStatement("select * from Exam where "+ column +"= '"+ x +"'" );
			rs = sql.executeQuery();
			
			while (rs.next()) {
				ExamMessage examMessage = new ExamMessage();
				examMessage.setStudent_id(rs.getString("student_id"));
				examMessage.setStudent_name(rs.getString("student_name"));
				examMessage.setStudent_onecard(rs.getString("student_onecard"));
				examMessage.setStudent_grade(rs.getString("student_grade"));
				examMessage.setStudent_course(rs.getString("student_course"));
				arraylist.add(examMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;
	}
	
	//delete table Exam
  	public void deleteTableExam(){
  		try{
  			System.out.println("Delete table Exam!");
  			
  			sql = conn.prepareStatement("delete from Exam");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Exam
  	public void dropTableExam(){
  		try{
  			System.out.println("Drop table Eaxm!");
  			
  			sql = conn.prepareStatement("drop table Exam");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
  //delete Exam Information
  	public void deleteExamMessage(String col1, String x, String col2, String y)
  	{
  		try{
          	sql = conn.prepareStatement("DELETE FROM "+ "Exam" +" WHERE "+ col1 +" = '"+ x +"' and "+ col2 +" = '"+ y +"'");
            sql.executeUpdate();
            System.out.println("haha");
      
          } catch(Exception e){
              e.printStackTrace();
          }
  	}
	
	
	
	
	
	
	
	
	
}
