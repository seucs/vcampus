package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ChatDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;
	
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	
	//create table Chat
  	public void createTableChat(){
  		try{
  			System.out.println("Create table Chat!");
  			
  			sql = conn.prepareStatement("create table Chat(ID int AUTO_INCREMENT PRIMARY KEY, Time Time, Sender varchar(255), Recipient varchar(255), Content varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
    //add Chat content
	public void addChatContent(String time, String sender, String recipient, String content){
        try{
        	System.out.println("Add Chat content:");
        	
            //ADD
        	sql = conn.prepareStatement("insert into Chat (Time, Sender, Recipient, Content) values (?, ?, ?, ?)");
            //add time(Time:yyyy-mm-dd hh:mm:ss), sender, recipient, content
        	sql.setString(1, time);
        	sql.setString(2, sender);
        	sql.setString(3, recipient);
        	sql.setString(4, content);
            sql.executeUpdate();
            
            //output
            System.out.print("发送时间: "+time);
            System.out.print("   发信人: "+sender);
            System.out.print("   收信人: "+recipient);
            System.out.println("   聊天内容: "+content);
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
	}
	
	
	//query Chat message
	//time(Time:yyyy-mm-dd hh:mm:ss), sender, recipient, content
	public ArrayList<ChatMessage> queryChatMessage(String column, String x){
  		ArrayList<ChatMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Query!");
            System.out.println("查询聊天信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Chat where "+ column +" = "+ x );
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			
  			//int columnNum = rsmd.getColumnCount();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	ChatMessage chatmessage = new ChatMessage();
            	chatmessage.setTime(rs.getString("Time")); 
            	chatmessage.setSender(rs.getString("Sender"));    
            	chatmessage.setRecipient(rs.getString("Recipient"));  
            	chatmessage.setContent(rs.getString("Content")); 
            	
            	arraylist.add(chatmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
	
	
	//update Chat Content depends on Time
	public void updateChatContent(String time, String content){
  		try{
  			System.out.println("Update Chat Content!");
  			
  			sql = conn.prepareStatement("update Chat set Content = ? where Time = ? ");
  			sql.setString(1, content);
        	sql.setString(2, time);
            sql.executeUpdate();
            
            //output
            System.out.print("发送时间: "+time);
            System.out.println("   聊天内容更新为: "+content);
              
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
	
	//delete Chat Content depends on Time
	public void deleteChatContent(String time){
  		try{
  			System.out.println("Delete Chat Content!");
  			
  			sql = conn.prepareStatement("delete from Chat where Time = ?");
  			sql.setString(1, time);
            sql.executeUpdate();
            
            //output
            System.out.print("发送时间: "+time);
            System.out.println("   聊天记录被删除！");
              
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
    }
	
	//fuzzy query table Chat
	public void queryTableChat(String x){
  		try{
  			System.out.println("Query Chat Content!");
            System.out.print("查询包含： “"+x);
            System.out.println("”   的聊天记录！");
            
  			sql = conn.prepareStatement("select * from Chat where Content like '%"+ x +"%' ");
  			rs = sql.executeQuery();
           
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Time");    
                String c = rs.getString("Sender");    
                String d = rs.getString("Recipient");  
                String e = rs.getString("Content"); 
                
                System.out.print("编号: "+a);
                System.out.print("   发送时间: "+b);
                System.out.print("   发信人: "+c);
                System.out.print("   收信人: "+d);
                System.out.println("   聊天内容: "+e);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
    }
	
	
	//query Chat records by Time Section
	public void queryChatRecords(String starttime, String endtime, String column, String person){
  		try{
  			System.out.println("Query Chat Records by Time Section!");
            System.out.println("查询 发送时间 在 "+ starttime +" ~ "+ endtime +" 之间的聊天记录！");
            
  			sql = conn.prepareStatement("select * from Chat where Time >= '"+ starttime + "' and Time <= '" + endtime +"' and "+ column +" = '"+ person +"'");
  			rs = sql.executeQuery();
           
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Time");    
                String c = rs.getString("Sender");    
                String d = rs.getString("Recipient");  
                String e = rs.getString("Content"); 
                
                System.out.print("编号: "+a);
                System.out.print("   发送时间: "+b);
                System.out.print("   发信人: "+c);
                System.out.print("   收信人: "+d);
                System.out.println("   聊天内容: "+e);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
    }
	
	
	//print Chat Content
	public void printChatContent(){
		try{
			System.out.println("Print Chat content:");
			
			sql = conn.prepareStatement("select * from Chat");
            rs = sql.executeQuery();
            
            //print chat content
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Time");    
                String c = rs.getString("Sender");    
                String d = rs.getString("Recipient");  
                String e = rs.getString("Content"); 
                
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   发送时间: "+b);
                System.out.print("   发信人: "+c);
                System.out.print("   收信人: "+d);
                System.out.println("   聊天内容: "+e);
            }
			
		} catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
	}
	
	//delete table Chat
	public void deleteTableChat(){
		try{
			System.out.println("Delete table Chat!");
			
			sql = conn.prepareStatement("delete from Chat");
            sql.executeUpdate();
            
		} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();
    }
	
	
	//drop table Chat
	public void dropTableChat(){
		try{
			System.out.println("Drop table Chat!");
			
			sql = conn.prepareStatement("drop table Chat");
            sql.executeUpdate();
            
		} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();
    }
}
