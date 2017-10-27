package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.FriendMessage;

public class FriendDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	//create table Friend
  	public void createTableFriend(){
  		try{
  			System.out.println("Create table Friend!");
  			
  			sql = conn.prepareStatement("create table Friend(ID int AUTO_INCREMENT PRIMARY KEY, Studentnumber varchar(255), Friendnumber varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }

  	
  	//add Friend Information
  	public void addFriendInformation(String studentnumber, String friendnumber){
          try{
          	System.out.println("Add Friend Information:");
          	
          	//studentnumber friendnumber
          	sql = conn.prepareStatement("insert into Friend (Studentnumber, friendnumber) values (?, ?)");
             
          	sql.setString(1, studentnumber);	//please do not start with zero
          	sql.setString(2, friendnumber);
        
            sql.executeUpdate();
              
            //output
            System.out.print("学生学号: "+studentnumber);
            System.out.println("   好友学号: "+friendnumber);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//delete Friend Information
  	public void deleteFriendInformation(String column, String x)
  	{
  		try{
  			System.out.println("Delete Friend information!");
  			System.out.println("删除好友信息中 "+column+" = "+x+" 的数据！");
          	
          	sql = conn.prepareStatement("DELETE FROM Friend WHERE "+ column +" = '"+ x +"'");
            sql.executeUpdate();
              
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//update Friend Information 
  	//update Friend for a speciific studentnumber
  	public void updateFriendInformation(String studentnumber, String friendnumber){
          try{
          	System.out.println("Update Friend Information:");
          	
          	//studentnumber friendnumber
          	sql = conn.prepareStatement("update Friend set friendnumber = ? where Studentnumber = ?");
             
          	sql.setString(1, friendnumber);	//please do not start with zero
          	sql.setString(2, studentnumber);
         
            sql.executeUpdate();
            
            //output
            System.out.print("学生学号: "+studentnumber);
            System.out.println("   好友学号: "+friendnumber);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Friend information
  	public void queryFriendinfo(String studentnumber){
  		try{
			System.out.println("Query Friend information!");
			System.out.println("查询 学生学号："+studentnumber+" 的好友信息！");
          
			sql = conn.prepareStatement("select * from Friend where Studentnumber = '"+studentnumber+"' ");
			rs = sql.executeQuery();
         
			//studentnumber friendnumber
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Studentnumber"); 
                String c = rs.getString("Friendnumber");
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   学生学号: "+b);
                System.out.println("   好友学号: "+c);
                
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	
  	//fuzzy query Friend message
  	public ArrayList<FriendMessage> queryFriendMessage(String column, String x){
  		ArrayList<FriendMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询好友信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Friend where "+ column +" = '"+ x +"' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
  			//studentnumber friendnumber
            while(rs.next()){   //if current statement is not the last one, loop
            	FriendMessage friendmessage = new FriendMessage();
            	friendmessage.setStudentnumber(rs.getString("Studentnumber"));
            	friendmessage.setFriendnumber(rs.getString("Friendnumber"));
            	
            	arraylist.add(friendmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  
  	
  	//print Friend Information
  	public void printFriendInfo(){
  		try{
  			System.out.println("Print Friend information:");
  			
  			sql = conn.prepareStatement("select * from Friend");
            rs = sql.executeQuery();
              
            //print Friend information
            //studentnumber friendnumber
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Studentnumber"); 
                String c = rs.getString("Friendnumber");
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   学生学号: "+b);
                System.out.println("   好友学号: "+c);
                
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	
  	//delete table Friend
  	public void deleteTableFriend(){
  		try{
  			System.out.println("Delete table Friend!");
  			
  			sql = conn.prepareStatement("delete from Friend");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Friend
  	public void dropTableFriend(){
  		try{
  			System.out.println("Drop table Friend!");
  			
  			sql = conn.prepareStatement("drop table Friend");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }


}
