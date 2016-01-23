package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.CompetitionMessage;

public class CompetitionDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;

	public void setConn(Connection c) {
		this.conn = c;
	}

	// create table Competition
	public void createTableCompetition() {
		try {
			System.out.println("Create table Competition!");

			sql = conn.prepareStatement(
					"create table Competition(ID int AUTO_INCREMENT PRIMARY KEY, competition_id varchar(255), competition_name varchar(255), competition_time varchar(255))");
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// add Competition Information
	public void addCompetitionInformation(String competition_id, String competition_name, String competition_time) {
		try {
			System.out.println("Add Competition Information:");

			// competition_id competition_name competition_time
			sql = conn.prepareStatement(
					"insert into Competition (competition_id, competition_name, competition_time) values (?, ?, ?)");

			sql.setString(1, competition_id); // please do not start with zero
			sql.setString(2, competition_name);
			sql.setString(3, competition_time);

			sql.executeUpdate();

			// output
			System.out.print("竞赛ID: " + competition_id);
			System.out.print("   竞赛名称: " + competition_name);
			System.out.println("   竞赛时间: " + competition_time);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// delete Competition Information
	public void deleteCompetitionInformation(String column, String x) {
		try {
			System.out.println("Delete Competition information!");
			System.out.println("删除竞赛信息中 " + column + " = " + x + " 的数据！");

			sql = conn.prepareStatement("DELETE FROM Competition WHERE " + column + " = '" + x + "'");
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// update Competition Information
	public void updateCompetitionInformation(String competition_id, String competition_name, String competition_time) {
		try {
			System.out.println("Update Competition Information:");

			// competition_id competition_name competition_time
			sql = conn.prepareStatement(
					"update Competition set competition_name = ? , competition_time = ? where competition_id = ?");

			sql.setString(1, competition_name); // please do not start with zero
			sql.setString(2, competition_time);
			sql.setString(3, competition_id);

			sql.executeUpdate();

			// output
			System.out.print("竞赛ID: " + competition_id);
			System.out.print("   竞赛名称: " + competition_name);
			System.out.println("   竞赛时间: " + competition_time);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// fuzzy query Competition information
	public void queryCompetitioninfo(String competition_name) {
		try {
			System.out.println("Query Competition information!");
			System.out.println("查询包含 竞赛名称：" + competition_name + " 的竞赛信息！");

			sql = conn.prepareStatement(
					"select * from Competition where competition_name like '%" + competition_name + "%' ");
			rs = sql.executeQuery();

			// competition_id competition_name competition_time
			while (rs.next()) { // if current statement is not the last one,
								// loop
				String a = rs.getString("ID");
				String b = rs.getString("competition_id");
				String c = rs.getString("competition_name");
				String d = rs.getString("competition_time");

				// output
				System.out.print("编号: " + a);
				System.out.print("   竞赛ID: " + b);
				System.out.print("   竞赛名称: " + c);
				System.out.println("   竞赛时间: " + d);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public ArrayList<CompetitionMessage> queryAllCompetitionMessage() {
		ArrayList<CompetitionMessage> arraylist = new ArrayList<>();
		try {
			sql = conn.prepareStatement("select * from Competition");
			rs = sql.executeQuery();
			while (rs.next()) { // if current statement is not the last one,
								// loop
				CompetitionMessage competitionmessage = new CompetitionMessage();
				competitionmessage.setCompetition_id(rs.getString("competition_id"));
				competitionmessage.setCompetition_name(rs.getString("competition_name"));
				competitionmessage.setCompetition_time(rs.getString("competition_time"));

				arraylist.add(competitionmessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;
	}

	// fuzzy query Competition message
	public ArrayList<CompetitionMessage> queryCompetitionMessage(String column, String x) {
		ArrayList<CompetitionMessage> arraylist = new ArrayList<>();
		try {
			System.out.println("Fuzzy Query!");
			System.out.println("查询竞赛信息中 " + column + " = " + x + " 的数据！");

			sql = conn.prepareStatement("select * from Competition where " + column + " like '%" + x + "%' ");
			rs = sql.executeQuery();
			// rsmd = rs.getMetaData();
			// int columnNum = rsmd.getColumnCount();

			// competition_id competition_name competition_time
			while (rs.next()) { // if current statement is not the last one,
								// loop
				CompetitionMessage competitionmessage = new CompetitionMessage();
				competitionmessage.setCompetition_id(rs.getString("competition_id"));
				competitionmessage.setCompetition_name(rs.getString("competition_name"));
				competitionmessage.setCompetition_time(rs.getString("competition_time"));

				arraylist.add(competitionmessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;
	}

	// print Competition Information
	public void printCompetitionInfo() {
		try {
			System.out.println("Print Competition information:");

			sql = conn.prepareStatement("select * from Competition");
			rs = sql.executeQuery();

			// print Competition information
			// competition_id competition_name competition_time
			while (rs.next()) { // if current statement is not the last one,
								// loop
				String a = rs.getString("ID");
				String b = rs.getString("competition_id");
				String c = rs.getString("competition_name");
				String d = rs.getString("competition_time");

				// output
				System.out.print("编号: " + a);
				System.out.print("   竞赛ID: " + b);
				System.out.print("   竞赛名称: " + c);
				System.out.println("   竞赛时间: " + d);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// delete table Competition
	public void deleteTableCompetition() {
		try {
			System.out.println("Delete table Competition!");

			sql = conn.prepareStatement("delete from Competition");
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// drop table Competition
	public void dropTableCompetition() {
		try {
			System.out.println("Drop table Competition!");

			sql = conn.prepareStatement("drop table Competition");
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

}
