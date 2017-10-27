package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.PersonMessage;

public class PersonDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	
	//create table Person
  	public void createTablePerson(){
  		try{
  			System.out.println("Create table Person!");
  			
  			//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
  			sql = conn.prepareStatement("create table Person(ID int AUTO_INCREMENT PRIMARY KEY, Name varchar(255), Onecard varchar(255), Number varchar(255), Race varchar(255), Sex varchar(255), Department varchar(255), Major varchar(255), Entrancedate varchar(255), Money double, Coursemanager varchar(255), Librarymanager varchar(255), Shopmanager varchar(255), Supermanager varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	//add Person Information
  	public void addPersonInformation(String name, String onecard, String number, String race, String sex, String department, String major, String entrancedate, double money, String coursemanager, String librarymanager, String shopmanager, String supermanager){
          try{
          	System.out.println("Add Person Information:");
          	
          //ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
          	sql = conn.prepareStatement("insert into Person (Name, Onecard, Number, Race, Sex, Department, Major, Entrancedate, Money, Coursemanager, Librarymanager, Shopmanager, Supermanager) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             
          	sql.setString(1, name);	//please do not start with zero
          	sql.setString(2, onecard);
          	sql.setString(3, number);
          	sql.setString(4, race);
          	sql.setString(5, sex);
          	sql.setString(6, department);
          	sql.setString(7, major);
          	sql.setString(8, entrancedate);
          	sql.setDouble(9, money);
          	sql.setString(10, coursemanager);
          	sql.setString(11, librarymanager);
          	sql.setString(12, shopmanager);
          	sql.setString(13, supermanager);

            sql.executeUpdate();
              
            //output
            System.out.print("姓名: "+name);
            System.out.print("   一卡通: "+onecard);
            System.out.print("   学号: "+number);
            System.out.print("   民族: "+race);
            System.out.print("   性别: "+sex);
            System.out.print("   院系: "+department);
            System.out.print("   专业: "+major);
            System.out.print("   入学日期: "+entrancedate);
            System.out.print("   一卡通余额: "+money);
            System.out.print("   教务管理员: "+coursemanager);
            System.out.print("   图书馆管理员: "+librarymanager);
            System.out.print("   商店管理员: "+shopmanager);
            System.out.println("   超级管理员: "+supermanager);
        
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//delete Person Information
  	public void deletePersonInformation(String column, String x)
  	{
  		try{
  			System.out.println("Delete Person information!");
  			System.out.println("删除个人信息中 "+column+" = "+x+" 的数据！");
          	
          	//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
          	sql = conn.prepareStatement("DELETE FROM Person WHERE "+ column +" = '"+ x +"'");
            sql.executeUpdate();
              
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	//update Person Information 
  	public void updatePersonInformation(String name, String onecard, String number, String race, String sex, String department, String major, String entrancedate, double money, String coursemanager, String librarymanager, String shopmanager, String supermanager){
          try{
          	System.out.println("Update Person Information:");
          	
          	//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
          	sql = conn.prepareStatement("update Person set Name = ? , Number = ? , Race = ? , Sex = ? , Department = ? , Major = ? , Entrancedate = ? , Money = ? , Coursemanager = ? , Librarymanager = ? , Shopmanager = ? , Supermanager = ?  where Onecard = ?");
             
          	sql.setString(1, name);	//please do not start with zero
          	sql.setString(2, number);
          	sql.setString(3, race);
          	sql.setString(4, sex);
          	sql.setString(5, department);
          	sql.setString(6, major);
          	sql.setString(7, entrancedate);
          	sql.setDouble(8, money);
          	sql.setString(9, coursemanager);
          	sql.setString(10, librarymanager);
          	sql.setString(11, shopmanager);
          	sql.setString(12, supermanager);
          	sql.setString(13, onecard);

            sql.executeUpdate();
              
            //output
            System.out.print("姓名: "+name);
            System.out.print("   一卡通: "+onecard);
            System.out.print("   学号: "+number);
            System.out.print("   民族: "+race);
            System.out.print("   性别: "+sex);
            System.out.print("   院系: "+department);
            System.out.print("   专业: "+major);
            System.out.print("   入学日期: "+entrancedate);
            System.out.print("   一卡通余额: "+money);
            System.out.print("   教务管理员: "+coursemanager);
            System.out.print("   图书馆管理员: "+librarymanager);
            System.out.print("   商店管理员: "+shopmanager);
            System.out.println("   超级管理员: "+supermanager);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Person information
  	public void queryPersoninfo(String name, String onecard){
  		try{
			System.out.println("Query Person information!");
			System.out.println("查询包含 姓名："+name+"  或 一卡通："+onecard+"  的个人信息！");
          
			sql = conn.prepareStatement("select * from Person where Name like '%"+name+"%' or Onecard like '%"+onecard+"%' ");
			rs = sql.executeQuery();
         
			//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Name"); 
                String c = rs.getString("Onecard");
                String d = rs.getString("Number");    
                String e = rs.getString("Race");  
                String f = rs.getString("Sex"); 
                String g = rs.getString("Department"); 
                String h = rs.getString("Major"); 
                String i = rs.getString("Entrancedate"); 
                String j = rs.getString("Money"); 
                String k = rs.getString("Coursemanager"); 
                String l = rs.getString("Librarymanager"); 
                String m = rs.getString("Shopmanager"); 
                String n = rs.getString("Supermanager"); 
                
              //output
                System.out.print("编号: "+ a );
                System.out.print("   姓名: "+ b );
                System.out.print("   一卡通: "+ c );
                System.out.print("   学号: "+ d );
                System.out.print("   民族: "+ e );
                System.out.print("   性别: "+ f );
                System.out.print("   院系: "+ g );
                System.out.print("   专业: "+ h );
                System.out.print("   入学日期: "+ i );
                System.out.print("   一卡通余额: "+ j );
                System.out.print("   教务管理员: "+ k );
                System.out.print("   图书馆管理员: "+ l );
                System.out.print("   商店管理员: "+ m );
                System.out.println("   超级管理员: "+ n );
     
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	//fuzzy query Person message
  	public ArrayList<PersonMessage> queryPersonMessage(String column, String x){
  		ArrayList<PersonMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询个人信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Person where "+ column +" = '"+ x +"' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
  		//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
            while(rs.next()){   //if current statement is not the last one, loop
            	PersonMessage personmessage = new PersonMessage();
            	personmessage.setName(rs.getString("Person_name")); 
            	personmessage.setOnecard(rs.getString("Onecard"));
            	personmessage.setNumber(rs.getString("Number"));    
            	personmessage.setRace(rs.getString("Race"));  
            	personmessage.setSex(rs.getString("Sex")); 
            	personmessage.setDepartment(rs.getString("Department")); 
            	personmessage.setMajor(rs.getString("Major")); 
            	personmessage.setEntrancedate(rs.getString("Entrancedate")); 
            	personmessage.setMoney(rs.getDouble("Money")); 
            	personmessage.setCoursemanager(rs.getString("Coursemanager")); 
            	personmessage.setLibrarymanager(rs.getString("Librarymanager")); 
            	personmessage.setShopmanager(rs.getString("Shopmanager")); 
            	personmessage.setSupermanager(rs.getString("Supermanager")); 
            	personmessage.setIcon(rs.getString("icon"));

            	arraylist.add(personmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	
  	public PersonMessage queryPersonMessage_single(String column, String x){
  		ArrayList<PersonMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询个人信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Person where "+ column +" = '"+ x +"' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
  		//ID Name Onecard Number Race Sex Department Major Entrancedate Money Coursemanager Librarymanager Shopmanager Supermanager
            while(rs.next()){   //if current statement is not the last one, loop
            	PersonMessage personmessage = new PersonMessage();
            	personmessage.setName(rs.getString("Person_name")); 
            	personmessage.setOnecard(rs.getString("Onecard"));
            	personmessage.setNumber(rs.getString("Number"));    
            	personmessage.setRace(rs.getString("Race"));  
            	personmessage.setSex(rs.getString("Sex")); 
            	personmessage.setDepartment(rs.getString("Department")); 
            	personmessage.setMajor(rs.getString("Major")); 
            	personmessage.setEntrancedate(rs.getString("Entrancedate")); 
            	personmessage.setMoney(rs.getDouble("Money")); 
            	personmessage.setCoursemanager(rs.getString("Coursemanager")); 
            	personmessage.setLibrarymanager(rs.getString("Librarymanager")); 
            	personmessage.setShopmanager(rs.getString("Shopmanager")); 
            	personmessage.setSupermanager(rs.getString("Supermanager")); 
            	personmessage.setIcon(rs.getString("icon"));
            	return personmessage;
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
  		return null;
    }
  	
  	//print Person Information
  	public void printPersonInfo(){
  		try{
  			System.out.println("Print Person information:");
  			
  			sql = conn.prepareStatement("select * from Person");
            rs = sql.executeQuery();
              
            //print Person information
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Name"); 
                String c = rs.getString("Onecard");
                String d = rs.getString("Number");    
                String e = rs.getString("Race");  
                String f = rs.getString("Sex"); 
                String g = rs.getString("Department"); 
                String h = rs.getString("Major"); 
                String i = rs.getString("Entrancedate"); 
                String j = rs.getString("Money"); 
                String k = rs.getString("Coursemanager"); 
                String l = rs.getString("Librarymanager"); 
                String m = rs.getString("Shopmanager"); 
                String n = rs.getString("Supermanager"); 
                
              //output
                System.out.print("编号: "+ a );
                System.out.print("   姓名: "+ b );
                System.out.print("   一卡通: "+ c );
                System.out.print("   学号: "+ d );
                System.out.print("   民族: "+ e );
                System.out.print("   性别: "+ f );
                System.out.print("   院系: "+ g );
                System.out.print("   专业: "+ h );
                System.out.print("   入学日期: "+ i );
                System.out.print("   一卡通余额: "+ j );
                System.out.print("   教务管理员: "+ k );
                System.out.print("   图书馆管理员: "+ l );
                System.out.print("   商店管理员: "+ m );
                System.out.println("   超级管理员: "+ n );
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	//delete table Person
  	public void deleteTablePerson(){
  		try{
  			System.out.println("Delete table Person!");
  			
  			sql = conn.prepareStatement("delete from Person");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Person
  	public void dropTablePerson(){
  		try{
  			System.out.println("Drop table Person!");
  			
  			sql = conn.prepareStatement("drop table Person");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	

}
