package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.CompetitorMessage;

public class CompetitorDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}

	//create table Competitor
  	public void createTableCompetitor(){
  		try{
  			System.out.println("Create table Competitor!");
  			
  			sql = conn.prepareStatement("create table Competitor(ID int AUTO_INCREMENT PRIMARY KEY, competition_id varchar(255), Capation varchar(255), Teammate1 varchar(255), Teammate2 varchar(255), Award varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
  //add Competitor Information
  	public void addCompetitorInformation(String competition_id, String caption, String teammate1, String teammate2, String award){
          try{
          	System.out.println("Add Competitor Information:");
          	
          	//competition_id Capation Teammate1 Teammate2 Award
          	sql = conn.prepareStatement("insert into Competitor (competition_id, Capation, Teammate1, Teammate2, Award) values (?, ?, ?, ?, ?)");
             
          	sql.setString(1, competition_id);	//please do not start with zero
          	sql.setString(2, caption);
          	sql.setString(3, teammate1);
          	sql.setString(4, teammate2);
          	sql.setString(5, award);
          	
            sql.executeUpdate();
              
            //output
            System.out.print("竞赛ID: "+competition_id);
            System.out.print("   队长: "+caption);
            System.out.print("   队员1: "+teammate1);
            System.out.print("   队员2: "+teammate2);
            System.out.println("   获奖情况: "+award);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//delete Competitor Information
  	public void deleteCompetitorInformation(String column, String x)
  	{
  		try{
  			System.out.println("Delete Competitor information!");
  			System.out.println("删除竞赛人员信息中 "+column+" = "+x+" 的数据！");
          	
          	sql = conn.prepareStatement("DELETE FROM Competitor WHERE "+ column +" = ' "+ x +" '");
            sql.executeUpdate();
              
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//update Competitor Information 
  	public void updateCompetitorInformation(String competition_id, String caption, String teammate1, String teammate2, String award){
          try{
          	System.out.println("Update Competitor Information:");
          	
          	//competition_id Capation Teammate1 Teammate2 Award
          	sql = conn.prepareStatement("update Competitor set Capation = ? , Teammate1 = ? , Teammate2 = ? , Award = ? where competition_id = ? ");
             
          	sql.setString(1, caption);	//please do not start with zero
          	sql.setString(2, teammate1);
          	sql.setString(3, teammate2);
          	sql.setString(4, award);
          	sql.setString(5, competition_id);
         
            sql.executeUpdate();
            
            //output
            System.out.print("竞赛ID: "+competition_id);
            System.out.print("   队长: "+caption);
            System.out.print("   队员1: "+teammate1);
            System.out.print("   队员2: "+teammate2);
            System.out.println("   获奖情况: "+award);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Competitor information
  	public void queryCompetitorinfo(String competition_name, String captain){
  		try{
			System.out.println("Query Competitor information!");
			System.out.println("查询 包含 竞赛名称："+competition_name+" 和  队长："+captain+"的竞赛人员信息！");
          
			sql = conn.prepareStatement("select * from Competitor where competition_name like '%"+competition_name+"%' or Captain like '%"+captain+"%' ");
			rs = sql.executeQuery();
         
			//competition_id Capation Teammate1 Teammate2 Award 
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("competition_id"); 
                String c = rs.getString("Capation");
                String d = rs.getString("Teammate1");    
                String e = rs.getString("Teammate2");  
                String f = rs.getString("Award");  
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   竞赛ID: "+b);
                System.out.print("   队长: "+c);
                System.out.print("   队员1: "+d);
                System.out.print("   队员2: "+e);
                System.out.println("   获奖情况: "+f);
                
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	
  	//fuzzy query Competitor message
  	public ArrayList<CompetitorMessage> queryCompetitorMessage(String column, String x){
  		ArrayList<CompetitorMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询竞赛人员信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Competitor where "+ column +" like '%"+ x +"%' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
  			//competition_id Capation Teammate1 Teammate2 Award
            while(rs.next()){   //if current statement is not the last one, loop
            	CompetitorMessage competitormessage = new CompetitorMessage();
            	competitormessage.setCompetition_id(rs.getString("competition_id")); 
            	competitormessage.setCapation(rs.getString("Capation"));
            	competitormessage.setTeammate1(rs.getString("Teammate1"));    
            	competitormessage.setTeammate2(rs.getString("Teammate2"));    
            	competitormessage.setAward(rs.getString("Award"));    
            	
            	arraylist.add(competitormessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  
  	
  	//print Competitor Information
  	public void printCompetitorInfo(){
  		try{
  			System.out.println("Print Competitor information:");
  			
  			sql = conn.prepareStatement("select * from Competitor");
            rs = sql.executeQuery();
              
            //print Competition information
            //competition_id Capation Teammate1 Teammate2 Award
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("competition_id"); 
                String c = rs.getString("Capation");
                String d = rs.getString("Teammate1");    
                String e = rs.getString("Teammate2");  
                String f = rs.getString("Award");  
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   竞赛ID: "+b);
                System.out.print("   队长: "+c);
                System.out.print("   队员1: "+d);
                System.out.print("   队员2: "+e);
                System.out.println("   获奖情况: "+f);
                
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	
  	//delete table Competitor
  	public void deleteTableCompetitor(){
  		try{
  			System.out.println("Delete table Competitor!");
  			
  			sql = conn.prepareStatement("delete from Competitor");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Competitor
  	public void dropTableCompetitor(){
  		try{
  			System.out.println("Drop table Competitor!");
  			
  			sql = conn.prepareStatement("drop table Competitor");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
    //delete Competitor Information
  	public void deleteCompetitorMessage(String col1, String x, String col2, String y)
  	{
  		try{
          	sql = conn.prepareStatement("DELETE FROM "+ "Competitor" +" WHERE "+ col1 +" = '"+ x +"' and "+ col2 +" = '"+ y +"'");
            sql.executeUpdate();
      
          } catch(Exception e){
              e.printStackTrace();
          }
  	}
  	
  	
  	
  	
  	
}
