package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.CourseMessage;

public class CourseDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;

	public void setConn(Connection c) {
		this.conn = c;
	}

	public void addCourseContent(String course_time, String course_teacher, String course_name, String course_id,
			String course_addr, String course_day, String course_exam_time, String course_exam_addr) {
		try {
			System.out.println("Add Chat content:");

			sql = conn.prepareStatement(
					"insert into Course (course_time,course_teacher,course_name,course_id,course_addr,course_day,course_exam_time,course_exam_addr) values (?,?,?,?,?,?,?,?)");
			sql.setString(1, course_time);
			sql.setString(2, course_teacher);
			sql.setString(3, course_name);
			sql.setString(4, course_id);
			sql.setString(5, course_addr);
			sql.setString(6, course_day);
			sql.setString(7, course_exam_time);
			sql.setString(8, course_exam_addr);
			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CourseMessage> queryCourseMessage(String column, String x) {
		ArrayList<CourseMessage> arraylist = new ArrayList<>();
		try {
			System.out.println("Query!");
			System.out.println("查询课程信息中 " + column + " = " + x + " 的数据！");

			sql = conn.prepareStatement("select * from Course where " + column + "= '" + x + "'");
			rs = sql.executeQuery();
			while (rs.next()) {
				CourseMessage courseMessage = new CourseMessage();
				courseMessage.setCourse_time(rs.getString("course_time"));
				courseMessage.setCourse_teacher(rs.getString("course_teacher"));
				courseMessage.setCourse_name(rs.getString("course_name"));
				courseMessage.setCourse_id(rs.getString("course_id"));
				courseMessage.setCourse_addr(rs.getString("course_addr"));
				courseMessage.setCourse_day(rs.getString("course_day"));
				courseMessage.setCourse_exam_time(rs.getString("course_exam_time"));
				courseMessage.setCourse_exam_addr(rs.getString("course_exam_addr"));
				arraylist.add(courseMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;
	}

	public ArrayList<CourseMessage> getAllCourseMessage() {
		ArrayList<CourseMessage> arraylist = new ArrayList<>();
		try {
			sql = conn.prepareStatement("select * from Course");
			rs = sql.executeQuery();
			while (rs.next()) {
				CourseMessage courseMessage = new CourseMessage();
				courseMessage.setCourse_time(rs.getString("course_time"));
				courseMessage.setCourse_teacher(rs.getString("course_teacher"));
				courseMessage.setCourse_name(rs.getString("course_name"));
				courseMessage.setCourse_id(rs.getString("course_id"));
				courseMessage.setCourse_addr(rs.getString("course_addr"));
				courseMessage.setCourse_day(rs.getString("course_day"));
				courseMessage.setCourse_exam_time(rs.getString("course_exam_time"));
				courseMessage.setCourse_exam_addr(rs.getString("course_exam_addr"));
				arraylist.add(courseMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;
	}
}
