package DAO;

import Message.LoginMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;


public class LoginDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;
	
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	
	//create table Login
  	public void createTableLogin(){
  		try{
  			System.out.println("Create table Login!");
  			
  			//ID Onecard Studentnumber Password Name
  			sql = conn.prepareStatement("create table Login(ID int AUTO_INCREMENT PRIMARY KEY, Name varchar(255), Onecard varchar(255), Studentnumber varchar(255), Password varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	//add full Login information
  	public void addLoginInfo(String name, String onecard, String studentnumber, String password){
          try{
          		System.out.println("Add Login information:");
          	
          		sql = conn.prepareStatement("insert into Login (Name, Onecard, Studentnumber, Password) values (?, ?, ?, ?)");
          		sql.setString(1, name);
          		sql.setString(2, onecard);
          		sql.setString(3, studentnumber);
          		sql.setString(4, password);
          		sql.executeUpdate();
              
          		//output
          		System.out.print("姓名: "+name);
          		System.out.print("   一卡通: "+onecard);
          		System.out.print("   学号: "+studentnumber);
          		System.out.println("   密码: "+password);         
              
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	public boolean LoginCheck(String password, String studentnumber){
        // String password = null;
         try{
             
             System.out.println("Check Login Information for the user whose student number = "+studentnumber+"!");
             
             sql = conn.prepareStatement("select * from Login where Password = ? and Studentnumber = ? ");
             sql.setString(1, password);
           	sql.setString(2, studentnumber);
             rs = sql.executeQuery();
             
             if(rs.next())
             {
             	if(password == null)
             	{
             		return false;
             	}
             	return true;
             }
             else {
 				return false;
 			}
             
         } catch(Exception e){
             e.printStackTrace();
         }
 		return false;
        
     }
     
     
     
     public boolean SignupCheck(String onecard, String studentnumber){
         // String password = null;
          try{
              
              System.out.println("Check Signup Information for the user whose one-card = "+onecard+" and student number = "+studentnumber+"!");
              
              sql = conn.prepareStatement("select * from Login where Onecard = ? and Studentnumber = ? ");
              sql.setString(1, onecard);
            	 sql.setString(2, studentnumber);
              rs = sql.executeQuery();
              
              if(rs.next())
              	return true;
              else {
  				return false;
  			}
              
          } catch(Exception e){
              e.printStackTrace();
          }
  		return false;
         
      }
  	
  	
  	//update Login password
  	public void updateLoginPassword(String onecard, String studentnumber, String password){
          try{
          		System.out.println("Update Login Password for the user whose one-card = "+onecard+" and student number = "+studentnumber+"!");
          	
          		sql = conn.prepareStatement("update Login set Password = ? where Onecard = ? and Studentnumber = ? ");
          		sql.setString(1, password);
          		sql.setString(2, onecard);
          		sql.setString(3, studentnumber);
          		sql.executeUpdate();      
              
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	

  	//findLoginPassword
  	public String findLoginPassword(String onecard, String studentnumber){
  		String password = null;
        try{
        		
        		System.out.println("Find Login Password for the user whose one-card = "+onecard+" and student number = "+studentnumber+"!");
        	
        		sql = conn.prepareStatement("select * from Login where Onecard = ? and Studentnumber = ? ");
        		sql.setString(1, onecard);
          		sql.setString(2, studentnumber);
      			rs = sql.executeQuery();
      			
      			while(rs.next()){   //if current statement is not the last one, loop
                	password = rs.getString("Password");
                    
                    System.out.println("The password is: "+password);
                	}
            
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
        return password;
	}
  	
  	
  	//query table Login 
  	//Name Onecard Studentnumber Password 
  	public ArrayList<LoginMessage> queryLoginMessage(String column, String x){
  		ArrayList<LoginMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Query!");
            System.out.println("查询登陆信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Login where "+ column +" = ' "+ x +" '");
  			rs = sql.executeQuery();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	LoginMessage bookmessage = new LoginMessage();
            	bookmessage.setName(rs.getString("Name")); 
            	bookmessage.setOnecard(rs.getString("Onecard"));    
            	bookmessage.setStudentnumber(rs.getString("Studentnumber"));  
            	bookmessage.setPassword(rs.getString("Password")); 
            	
            	arraylist.add(bookmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	
  	
  	
  	//print Login information
  	public void printLoginInfo(){
  		try{
  				System.out.println("Print Login information:");
  			
  				sql = conn.prepareStatement("select * from Login");
  				rs = sql.executeQuery();
              
  				//print chat content
  				while(rs.next()){   //if current statement is not the last one, loop
  				  String a = rs.getString("ID");
                  String b = rs.getString("Name");    
                  String c = rs.getString("Onecard");    
                  String d = rs.getString("Studentnumber");  
                  String e = rs.getString("Password"); 
                  
                  
                  //output
                  System.out.print("编号: "+a);
                  System.out.print("   姓名: "+b);
                  System.out.print("   一卡通: "+c);
                  System.out.print("   学号: "+d);
                  System.out.println("   密码: "+e);
              }
  			
  		} catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
    
  	//delete table Login
  	public void deleteTableLogin(){
  		try{
  			System.out.println("Delete table Login!");
  			
  			sql = conn.prepareStatement("delete from Login");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Login
  	public void dropTableLogin(){
  		try{
  			System.out.println("Drop table Login!");
  			
  			sql = conn.prepareStatement("drop table Login");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
	
	
	
	
	

	
}
