package DAO;

import Message.ClassgroupMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.CompetitionMessage;

public class ClassgroupDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	//create table Classgroup
  	public void createTableClassgroup(){
  		try{
  			System.out.println("Create table Classgroup!");
  			
  			sql = conn.prepareStatement("create table Classgroup(ID int AUTO_INCREMENT PRIMARY KEY, Studentnumber varchar(255), Class_id varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }

  	//add Classgroup Information
  	public void addClassgroupInformation(String studentnumber, String class_id){
          try{
          	System.out.println("Add Classgroup Information:");
          	
          	//studentnumber class_id
          	sql = conn.prepareStatement("insert into Classgroup (Studentnumber, Class_id) values (?, ?)");
             
          	sql.setString(1, studentnumber);	//please do not start with zero
          	sql.setString(2, class_id);
        
            sql.executeUpdate();
              
            //output
            System.out.print("学生学号: "+studentnumber);
            System.out.println("   所属班级: "+class_id);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//delete Classgroup Information
  	public void deleteClassgroupInformation(String column, String x)
  	{
  		try{
  			System.out.println("Delete Classgroup information!");
  			System.out.println("删除群组信息中 "+column+" = "+x+" 的数据！");
          	
          	sql = conn.prepareStatement("DELETE FROM Classgroup WHERE "+ column +" = '"+ x +"'");
            sql.executeUpdate();
              
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//update Classgroup Information 
  	//update Classgroup for a speciific studentnumber
  	public void updateClassgroupInformation(String studentnumber, String class_id){
          try{
          	System.out.println("Update Classgroup Information:");
          	
          	//studentnumber class_id
          	sql = conn.prepareStatement("update Classgroup set Class_id = ? where Studentnumber = ?");
             
          	sql.setString(1, class_id);	//please do not start with zero
          	sql.setString(2, studentnumber);
         
            sql.executeUpdate();
            
            //output
            System.out.print("学生学号: "+studentnumber);
            System.out.println("   所属班级: "+class_id);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Classgroup information
  	public void queryClassgroupinfo(String studentnumber){
  		try{
			System.out.println("Query Classgroup information!");
			System.out.println("查询 学生学号："+studentnumber+" 的群组信息！");
          
			sql = conn.prepareStatement("select * from Classgroup where Studentnumber = '"+studentnumber+"' ");
			rs = sql.executeQuery();
         
			//studentnumber class_id
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Studentnumber"); 
                String c = rs.getString("Class_id");
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   学生学号: "+b);
                System.out.println("   所属班级: "+c);
                
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	
  	//fuzzy query Classgroup message
  	public ArrayList<ClassgroupMessage> queryClassgroupMessage(String column, String x){
  		ArrayList<ClassgroupMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询群组信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Classgroup where "+ column +" like '%"+ x +"%' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
  			//studentnumber class_id
            while(rs.next()){   //if current statement is not the last one, loop
            	ClassgroupMessage classgroupmessage = new ClassgroupMessage();
            	classgroupmessage.setStudentnumber(rs.getString("Studentnumber")); 
            	classgroupmessage.setClass_id(rs.getString("Class_id"));  
            	
            	arraylist.add(classgroupmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  
  	
  	//print Classgroup Information
  	public void printClassgroupInfo(){
  		try{
  			System.out.println("Print Classgroup information:");
  			
  			sql = conn.prepareStatement("select * from Classgroup");
            rs = sql.executeQuery();
              
            //print Classgroup information
            //studentnumber class_id
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Studentnumber"); 
                String c = rs.getString("Class_id");
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   学生学号: "+b);
                System.out.println("   所属班级: "+c);
                
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	
  	//delete table Classgroup
  	public void deleteTableClassgroup(){
  		try{
  			System.out.println("Delete table Classgroup!");
  			
  			sql = conn.prepareStatement("delete from Classgroup");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Classgroup
  	public void dropTableClassgroup(){
  		try{
  			System.out.println("Drop table Classgroup!");
  			
  			sql = conn.prepareStatement("drop table Classgroup");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }

}
