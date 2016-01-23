package DAO;

import Message.BookMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement sql = null;
	static ResultSetMetaData rsmd = null;
	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	/*
     *
     * @author YANSHENGJIA
     *
     */
	//create table Book
  	public void createTableBook(){
  		try{
  			System.out.println("Create table Book!");
  			
  			sql = conn.prepareStatement("create table Book(ID int AUTO_INCREMENT PRIMARY KEY, Code int, Category varchar(255), Bookname varchar(255), Address varchar(255), Author varchar(255), Press varchar(255), Total int, Keep int, Ordered int, Borrowed int, Available int, Comment varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
	
  	//add Book Information
  	public void addBookInformation(String code, String categoty, String bookname, String address, String author, String press, int total, int keep, int ordered, int borrowed, int available, String comment){
          try{
          	System.out.println("Add Book Information:");
          	
          	//Code Category Name Address Author Press Total Keep Ordered Borrowed Available Comment
          	sql = conn.prepareStatement("insert into Book (Code, Category, Bookname, Address, Author, Press, Total, Keep, Ordered, Borrowed, Available, Comment) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             
          	sql.setString(1, code);	//please do not start with zero
          	sql.setString(2, categoty);
          	sql.setString(3, bookname);
          	sql.setString(4, address);
          	sql.setString(5, author);
          	sql.setString(6, press);
          	sql.setInt(7, total);
          	sql.setInt(8, keep);
          	sql.setInt(9, ordered);
          	sql.setInt(10, borrowed);
          	sql.setInt(11, available);
          	sql.setString(12, comment);
            sql.executeUpdate();
              
            //output
            System.out.print("图书编码: "+code);
            System.out.print("   图书类别: "+categoty);
            System.out.print("   图书名称: "+bookname);
            System.out.print("   图书地址: "+address);
            System.out.print("   作者: "+author);
            System.out.print("   出版社: "+press);
            System.out.print("   总本数: "+total);
            System.out.print("   保留本数: "+keep);
            System.out.print("   已预约本数: "+ordered);
            System.out.print("   已借本数: "+borrowed);
            System.out.print("   可借本数: "+available);
            System.out.println("   备注: "+comment);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	//update Book Information 
  	public void updateBookInformation(String code, String category, String bookname, String address, String author, String press, int total, int keep, int ordered, int borrowed, int available, String comment){
          try{
          	System.out.println("Update Book Information:");
          	
          	//Code Category Name Address Author Press Total Keep Ordered Borrowed Available Comment
          	sql = conn.prepareStatement("update Book set Category = ? , Bookname = ? , Address = ? , Author = ? , Press = ? , Total = ? , Keep = ? , Ordered = ? , Borrowed = ? , Available = ? , Comment = ? where code = ?");
             
          	sql.setString(1, code);	//please do not start with zero
          	sql.setString(2, category);
          	sql.setString(3, bookname);
          	sql.setString(4, address);
          	sql.setString(5, author);
          	sql.setString(6, press);
          	sql.setInt(7, total);
          	sql.setInt(8, keep);
          	sql.setInt(9, ordered);
          	sql.setInt(10, borrowed);
          	sql.setInt(11, available);
          	sql.setString(12, comment);
            sql.executeUpdate();
              
            //output
            System.out.print("   图书编码: "+code);
            System.out.print("   图书类别: "+category);
            System.out.print("   图书名称: "+bookname);
            System.out.print("   图书地址: "+address);
            System.out.print("   作者: "+author);
            System.out.print("   出版社: "+press);
            System.out.print("   总本数: "+total);
            System.out.print("   保留本数: "+keep);
            System.out.print("   已预约本数: "+ordered);
            System.out.print("   已借本数: "+borrowed);
            System.out.print("   可借本数: "+available);
            System.out.println("   备注: "+comment);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Book information
  	public void queryBookinfo(String bookname, String author){
  		try{
			System.out.println("Query Book information!");
			System.out.println("查询包含 书名："+bookname+"  或 作者："+author+"  的图书信息！");
          
			sql = conn.prepareStatement("select * from Book where Bookname like '%"+bookname+"%' or Author like '%"+author+"%' ");
			rs = sql.executeQuery();
         
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Code"); 
                String c = rs.getString("Category");
                String d = rs.getString("Bookname");    
                String e = rs.getString("Address");  
                String f = rs.getString("Author"); 
                String g = rs.getString("Press"); 
                String h = rs.getString("Total"); 
                String i = rs.getString("Keep"); 
                String j = rs.getString("Ordered"); 
                String k = rs.getString("Borrowed"); 
                String l = rs.getString("Available"); 
                String m = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   图书编码: "+b);
                System.out.print("   图书类别: "+c);
                System.out.print("   图书名称: "+d);
                System.out.print("   图书地址: "+e);
                System.out.print("   作者: "+f);
                System.out.print("   出版社: "+g);
                System.out.print("   总本数: "+h);
                System.out.print("   保留本数: "+i);
                System.out.print("   已预约本数: "+j);
                System.out.print("   已借本数: "+k);
                System.out.print("   可借本数: "+l);
                System.out.println("   备注: "+m);
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	//fuzzy query Book message
  	public ArrayList<BookMessage> queryBookMessage(String column, String x){
  		ArrayList<BookMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询图书信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Book where "+ column +" like '%"+ x +"%' ");
  			rs = sql.executeQuery();
  			//rsmd = rs.getMetaData();
  			//int columnNum = rsmd.getColumnCount();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	BookMessage bookmessage = new BookMessage();
            	bookmessage.setCode(rs.getString("Code")); 
            	bookmessage.setCategory(rs.getString("Category"));
            	bookmessage.setBookname(rs.getString("Bookname"));    
            	bookmessage.setAddress(rs.getString("Address"));  
            	bookmessage.setAuthor(rs.getString("Author")); 
            	bookmessage.setPress(rs.getString("Press")); 
            	bookmessage.setTotal(rs.getInt("Total")); 
            	bookmessage.setKeep(rs.getInt("Keep")); 
            	bookmessage.setOrdered(rs.getInt("Ordered")); 
            	bookmessage.setBorrowed(rs.getInt("Borrowed")); 
            	bookmessage.setAvailable(rs.getInt("Available")); 
            	bookmessage.setComment(rs.getString("Comment")); 
            	
            	arraylist.add(bookmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	
  	//category query
  	//Novel, Essay, Poetry, Finance, Computer, Electron, Physics, Maths, Chemisty, Biology, Lanuage
  	public ArrayList<BookMessage> queryBookCategory(String x, boolean novel,boolean essay, boolean poetry, boolean finance, boolean computer, boolean electron, boolean physics, boolean maths, boolean chemisty, boolean biology, boolean lanuage){
  		ArrayList<BookMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Category Query!");
            System.out.println("根据类别查询图书信息！");
            
            String Novel, Essay, Poetry, Finance, Computer, Electron, Physics, Maths, Chemisty, Biology, Lanuage;
            
            if(novel)	Novel = "novel";
            else Novel = "vanish";
            if(essay)	Essay = "essay";
            else Essay = "vanish";
            if(poetry)	Poetry = "poetry";
            else Poetry = "vanish";
            if(finance)	Finance = "finance";
            else Finance = "vanish";
            if(computer)	Computer = "computer";
            else Computer = "vanish";
            if(electron)	Electron = "electron";
            else Electron = "vanish";
            if(physics)	Physics = "physics";
            else Physics = "vanish";
            if(maths)	Maths = "maths";
            else Maths = "vanish";
            if(chemisty)	Chemisty = "chemisty";
            else Chemisty = "vanish";
            if(biology)	Biology = "biology";
            else Biology = "vanish";
            if(lanuage)	Lanuage = "lanuage";
            else Lanuage = "vanish";
            
  			sql = conn.prepareStatement("select * from Book where Bookname like '%"+ x +"%' and Category in (?,?,?,?,?,?,?,?,?,?,?)");
  			sql.setString(1, Novel);
  			sql.setString(2, Essay);
  			sql.setString(3, Poetry);
  			sql.setString(4, Finance);
  			sql.setString(5, Computer);
  			sql.setString(6, Electron);
  			sql.setString(7, Physics);
  			sql.setString(8, Maths);
  			sql.setString(9, Chemisty);
  			sql.setString(10, Biology);
  			sql.setString(11, Lanuage);
  			
  			rs = sql.executeQuery();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	BookMessage bookmessage = new BookMessage();
            	bookmessage.setCode(rs.getString("Code")); 
            	bookmessage.setCategory(rs.getString("Category"));  
            	bookmessage.setBookname(rs.getString("Bookname"));    
            	bookmessage.setAddress(rs.getString("Address"));  
            	bookmessage.setAuthor(rs.getString("Author")); 
            	bookmessage.setPress(rs.getString("Press")); 
            	bookmessage.setTotal(rs.getInt("Total")); 
            	bookmessage.setKeep(rs.getInt("Keep")); 
            	bookmessage.setOrdered(rs.getInt("Ordered")); 
            	bookmessage.setBorrowed(rs.getInt("Borrowed")); 
            	bookmessage.setAvailable(rs.getInt("Available")); 
            	bookmessage.setComment(rs.getString("Comment")); 
            	
            	arraylist.add(bookmessage);
            	
            	String a = rs.getString("ID");
                String b = rs.getString("Code"); 
                String c = rs.getString("Category");
                String d = rs.getString("Bookname");
                String e = rs.getString("Address");  
                String f = rs.getString("Author"); 
                String g = rs.getString("Press"); 
                String h = rs.getString("Total"); 
                String i = rs.getString("Keep"); 
                String j = rs.getString("Ordered"); 
                String k = rs.getString("Borrowed"); 
                String l = rs.getString("Available"); 
                String m = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   图书编码: "+b);
                System.out.print("   图书类别: "+c);
                System.out.print("   图书名称: "+d);
                System.out.print("   图书地址: "+e);
                System.out.print("   作者: "+f);
                System.out.print("   出版社: "+g);
                System.out.print("   总本数: "+h);
                System.out.print("   保留本数: "+i);
                System.out.print("   已预约本数: "+j);
                System.out.print("   已借本数: "+k);
                System.out.print("   可借本数: "+l);
                System.out.println("   备注: "+m);
           
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	public ArrayList<BookMessage> queryBookCategorybyauthor(String x, boolean novel,boolean essay, boolean poetry, boolean finance, boolean computer, boolean electron, boolean physics, boolean maths, boolean chemisty, boolean biology, boolean lanuage){
  		ArrayList<BookMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Category Query!");
            System.out.println("根据类别查询图书信息！");
            
            String Novel, Essay, Poetry, Finance, Computer, Electron, Physics, Maths, Chemisty, Biology, Lanuage;
            if(novel)	Novel = "novel";
            else Novel = "vanish";
            if(essay)	Essay = "essay";
            else Essay = "vanish";
            if(poetry)	Poetry = "poetry";
            else Poetry = "vanish";
            if(finance)	Finance = "finance";
            else Finance = "vanish";
            if(computer)	Computer = "computer";
            else Computer = "vanish";
            if(electron)	Electron = "electron";
            else Electron = "vanish";
            if(physics)	Physics = "physics";
            else Physics = "vanish";
            if(maths)	Maths = "maths";
            else Maths = "vanish";
            if(chemisty)	Chemisty = "chemisty";
            else Chemisty = "vanish";
            if(biology)	Biology = "biology";
            else Biology = "vanish";
            if(lanuage)	Lanuage = "lanuage";
            else Lanuage = "vanish";
            
  			sql = conn.prepareStatement("select * from Book where Author like '%"+ x +"%' and Category in (?,?,?,?,?,?,?,?,?,?,?)");
  			sql.setString(1, Novel);
  			sql.setString(2, Essay);
  			sql.setString(3, Poetry);
  			sql.setString(4, Finance);
  			sql.setString(5, Computer);
  			sql.setString(6, Electron);
  			sql.setString(7, Physics);
  			sql.setString(8, Maths);
  			sql.setString(9, Chemisty);
  			sql.setString(10, Biology);
  			sql.setString(11, Lanuage);
  			
  			rs = sql.executeQuery();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	BookMessage bookmessage = new BookMessage();
            	bookmessage.setCode(rs.getString("Code")); 
            	bookmessage.setCategory(rs.getString("Category"));  
            	bookmessage.setBookname(rs.getString("Bookname"));    
            	bookmessage.setAddress(rs.getString("Address"));  
            	bookmessage.setAuthor(rs.getString("Author")); 
            	bookmessage.setPress(rs.getString("Press")); 
            	bookmessage.setTotal(rs.getInt("Total")); 
            	bookmessage.setKeep(rs.getInt("Keep")); 
            	bookmessage.setOrdered(rs.getInt("Ordered")); 
            	bookmessage.setBorrowed(rs.getInt("Borrowed")); 
            	bookmessage.setAvailable(rs.getInt("Available")); 
            	bookmessage.setComment(rs.getString("Comment")); 
            	
            	arraylist.add(bookmessage);
            	
            	String a = rs.getString("ID");
                String b = rs.getString("Code"); 
                String c = rs.getString("Category");
                String d = rs.getString("Bookname");    
                String e = rs.getString("Address");  
                String f = rs.getString("Author"); 
                String g = rs.getString("Press"); 
                String h = rs.getString("Total"); 
                String i = rs.getString("Keep"); 
                String j = rs.getString("Ordered"); 
                String k = rs.getString("Borrowed"); 
                String l = rs.getString("Available"); 
                String m = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   图书编码: "+b);
                System.out.print("   图书类别: "+c);
                System.out.print("   图书名称: "+d);
                System.out.print("   图书地址: "+e);
                System.out.print("   作者: "+f);
                System.out.print("   出版社: "+g);
                System.out.print("   总本数: "+h);
                System.out.print("   保留本数: "+i);
                System.out.print("   已预约本数: "+j);
                System.out.print("   已借本数: "+k);
                System.out.print("   可借本数: "+l);
                System.out.println("   备注: "+m);
           
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }	
  	
  	//print Book Information
  	public void printBookInfo(){
  		try{
  			System.out.println("Print Book information:");
  			
  			sql = conn.prepareStatement("select * from Book");
            rs = sql.executeQuery();
              
            //print Book information
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Code"); 
                String c = rs.getString("Category");
                String d = rs.getString("Bookname");    
                String e = rs.getString("Address");  
                String f = rs.getString("Author"); 
                String g = rs.getString("Press"); 
                String h = rs.getString("Total"); 
                String i = rs.getString("Keep"); 
                String j = rs.getString("Ordered"); 
                String k = rs.getString("Borrowed"); 
                String l = rs.getString("Available"); 
                String m = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   图书编码: "+b);
                System.out.print("   图书类别: "+c);
                System.out.print("   图书名称: "+d);
                System.out.print("   图书地址: "+e);
                System.out.print("   作者: "+f);
                System.out.print("   出版社: "+g);
                System.out.print("   总本数: "+h);
                System.out.print("   保留本数: "+i);
                System.out.print("   已预约本数: "+j);
                System.out.print("   已借本数: "+k);
                System.out.print("   可借本数: "+l);
                System.out.println("   备注: "+m);
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	//delete table Book
  	public void deleteTableBook(){
  		try{
  			System.out.println("Delete table Book!");
  			
  			sql = conn.prepareStatement("delete from Book");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Book
  	public void dropTableBook(){
  		try{
  			System.out.println("Drop table Book!");
  			
  			sql = conn.prepareStatement("drop table Book");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
}
