package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class BorrowDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;
	
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	//create table Borrow
  	public void createTableBorrow(){
  		try{
  			System.out.println("Create table Borrow!");
  			
  			//ID Onecard Studentnumber Name Code Category Bookname Author Press Borrowday Returnday Timelimit
  			sql = conn.prepareStatement("create table Borrow(ID int AUTO_INCREMENT PRIMARY KEY, Onecard varchar(255), Studentnumber varchar(255), Name varchar(255), Code varchar(255), Category varchar(255), Bookname varchar(255), Author varchar(255), Press varchar(255), Borrowday Date, Returnday Date, Timelimit int)");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
  	
  	//add Borrow Information
  	public void addBorrowInfo(String onecard, String studentnumber, String name, String code, String category, String bookname, String author, String press, String borrowday, String returnday, int timelimit){
          try{
          	System.out.println("Add Borrow Information:");
          	
          	//onecard studentnumber name code category bookname author press borrowday returnday timelimit
          	sql = conn.prepareStatement("insert into Borrow (Onecard, Studentnumber, Name, Code, Category, Bookname, Author, Press, Borrowday, Returnday, Timelimit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             
          	sql.setString(1, onecard);	//please do not start with zero
          	sql.setString(2, studentnumber);
          	sql.setString(3, name);
          	sql.setString(4, code);
          	sql.setString(5, category);
          	sql.setString(6, bookname);
          	sql.setString(7, author);
          	sql.setString(8, press);
          	sql.setString(9, borrowday);
          	sql.setString(10, returnday);
          	sql.setInt(11, timelimit);
            sql.executeUpdate();
              
            //output
            System.out.print("一卡通: "+onecard);
            System.out.print("   学号: "+studentnumber);
            System.out.print("   姓名: "+name);
            System.out.print("   图书编码: "+code);
            System.out.print("   图书类别: "+code);
            System.out.print("   书名: "+bookname);
            System.out.print("   作者: "+author);
            System.out.print("   出版社: "+press);
            System.out.print("   借出日期: "+borrowday);
            System.out.print("   归还日期: "+returnday);
            System.out.println("   剩余天数: "+timelimit);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	//query Borrow information
  	public void queryBorrowinfo(String onecard, String studentcard){
  		try{
			System.out.println("Query Borrow information!");
			System.out.println("查询 一卡通号："+onecard+" 或 学号："+studentcard+" 的同学的借书情况！");
			
			sql = conn.prepareStatement("select * from Borrow where Onecard = "+onecard+ " or Studentnumber = "+studentcard);
			rs = sql.executeQuery();
         
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Onecard");    
                String c = rs.getString("Studentnumber");    
                String d = rs.getString("Name");  
                String e = rs.getString("Code"); 
                String f = rs.getString("Category"); 
                String g = rs.getString("Bookname"); 
                String h = rs.getString("Author"); 
                String i = rs.getString("Press"); 
                String j = rs.getString("Borrowday"); 
                String k = rs.getString("Returnday"); 
                String l = rs.getString("Timelimit"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   一卡通: "+b);
                System.out.print("   学号: "+c);
                System.out.print("   姓名: "+d);
                System.out.print("   图书编码: "+e);
                System.out.print("   图书类别: "+f);
                System.out.print("   书名: "+g);
                System.out.print("   作者: "+h);
                System.out.print("   出版社: "+i);
                System.out.print("   借出日期: "+j);
                System.out.print("   归还日期: "+k);
                System.out.println("   剩余天数: "+i);
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	
  	//query Borrow message
  	//onecard studentnumber name code category bookname author press borrowday returnday timelimit
  	public ArrayList<BorrowMessage> queryBorrowMessage(String column, String x){
  		ArrayList<BorrowMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询借阅信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Borrow where "+ column +" like '%"+ x +"%' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			
  			//int columnNum = rsmd.getColumnCount();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	BorrowMessage borrowmessage = new BorrowMessage();
            	borrowmessage.setOnecard(rs.getString("Onecard")); 
            	borrowmessage.setStudentnumber(rs.getString("Studentnumber"));    
            	borrowmessage.setName(rs.getString("Name"));  
            	borrowmessage.setCode(rs.getString("Code")); 
            	borrowmessage.setCategory(rs.getString("Category")); 
            	borrowmessage.setBookname(rs.getString("Bookname")); 
            	borrowmessage.setAuthor(rs.getString("Author")); 
            	borrowmessage.setPress(rs.getString("Press")); 
            	borrowmessage.setBorrowday(rs.getString("Borrowday")); 
            	borrowmessage.setReturnday(rs.getString("Returnday")); 
            	borrowmessage.setTimelimit(rs.getInt("Timelimit")); 
            	
            	arraylist.add(borrowmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	

  	
  	//print Borrow Information
  	public void printBorrowInfo(){
  		try{
  			System.out.println("Print Borrow information:");
  			
  			sql = conn.prepareStatement("select * from Borrow");
            rs = sql.executeQuery();
              
            //print Borrow information
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Onecard");    
                String c = rs.getString("Studentnumber");    
                String d = rs.getString("Name");  
                String e = rs.getString("Code"); 
                String f = rs.getString("Category"); 
                String g = rs.getString("Bookname"); 
                String h = rs.getString("Author"); 
                String i = rs.getString("Press"); 
                String j = rs.getString("Borrowday"); 
                String k = rs.getString("Returnday"); 
                String l = rs.getString("Timelimit"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   一卡通: "+b);
                System.out.print("   学号: "+c);
                System.out.print("   姓名: "+d);
                System.out.print("   图书编码: "+e);
                System.out.print("   图书类别: "+f);
                System.out.print("   书名: "+g);
                System.out.print("   作者: "+h);
                System.out.print("   出版社: "+i);
                System.out.print("   借出日期: "+j);
                System.out.print("   归还日期: "+k);
                System.out.println("   剩余天数: "+i);
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  		}
        System.out.println();
  	}
	
  	//delete table Borrow
  	public void deleteTableBorrow(){
  		try{
  			System.out.println("Delete table Borrow!");
  			
  			sql = conn.prepareStatement("delete from Borrow");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Borrow
  	public void dropTableBorrow(){
  		try{
  			System.out.println("Drop table Borrow!");
  			
  			sql = conn.prepareStatement("drop table Borrow");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
}
