package DAO;
import java.sql.*;
import java.sql.Connection;
import java.util.*;

public class DataAccessObject {
	//intial database variables
	private static Connection conn = null;
	private static PreparedStatement sql = null;
	
	//intial objects of operation classes
	private BookDAO book = new BookDAO();
	private BorrowDAO borrow = new BorrowDAO();
	private ChatDAO chat = new ChatDAO();
	private LoginDAO login = new LoginDAO();
	private ShopDAO shop = new ShopDAO();
	private TeachDAO teach = new TeachDAO();
	private CourseDAO course = new CourseDAO();
	
	//getters for DAO objects
	public BookDAO getBookDAO()
	{
		return book;
	}
	
	public BorrowDAO getBorrowDAO()
	{
		return borrow;
	}
	
	public ChatDAO getChatDAO()
	{
		return chat;
	}
	
	public LoginDAO getLoginDAO()
	{
		return login;
	}
	
	public ShopDAO getShopDAO()
	{
		return shop;
	}
	
	public TeachDAO getTeachDAO()
	{
		return teach;
	}
	
	public CourseDAO getCourseDAO() {
		return course;
	}
	
	//Main Function
    public static void main(String[] args){
    	DataAccessObject dao = new DataAccessObject();
    	dao.getConn();
    	dao.getBookDAO().dropTableBook();
    	dao.getBookDAO().createTableBook();
    	dao.getBookDAO().addBookInformation("0", "maths", "高等数学", "李文正图书馆中文阅览室4", "华罗庚", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().addBookInformation("1", "physics", "时间简史", "李文正图书馆中文阅览室4", "霍金", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().addBookInformation("2", "computer", "C++", "李文正图书馆中文阅览室4", "ysj", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().addBookInformation("3", "computer", "Java", "李文正图书馆中文阅览室4", "pzx", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().addBookInformation("4", "lanuage", "大学英语", "李文正图书馆中文阅览室4", "obama", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().addBookInformation("5", "novel", "老人与海", "李文正图书馆中文阅览室4", "海明威", "高等教育出版社", 100, 10, 40, 30, 20, "");
    	dao.getBookDAO().queryBookCategory("", true, false, false, false, false, false, false, false, false, false, false);

    }
    
	//Connect Database
    public Connection getConn()
    {
        try{
            //load JDBC driver
            Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
            System.out.println("Access Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        try{
            //data source url1 user password
            String url1 = "jdbc:Access://database.accdb";
            String user = "";
            String password = "";
            
            //getConnection() create a object for linking
            //getConnection("jdbc:odbc:data source name","user name","password")
            conn = DriverManager.getConnection(url1, user, password);
            
            //all classes connected
            book.setConn(conn);
            borrow.setConn(conn);
            chat.setConn(conn);
            login.setConn(conn);
            shop.setConn(conn);
            teach.setConn(conn);
            
            
            System.out.println("DataBase Access Linked Successfully!");
        }catch (Exception e){
            System.out.println("DataBase Access Linked UnSuccessfully!");
            e.printStackTrace();
        }
        
        System.out.println();
        return conn;
    }
    
    
    //close
    public void clear(ResultSet a, Statement b, Connection c, PreparedStatement d)
    {
        try {
            if (a != null)
                a.close();
        } catch (Exception e1) {
            System.out.println("Access ResultSet Close Error");
            e1.printStackTrace();
        } finally {
            try {
                if (b != null)
                    b.close();
            } catch (Exception e2) {
                System.out.println("Access Statement Close Error");
                e2.printStackTrace();
            } finally {
                try {
                    if (c != null)
                        c.close();
                } catch (Exception e3) {
                    System.out.println("Access Connection Close Error");
                    e3.printStackTrace();
                } finally {
                    try {
                        if (d != null)
                            d.close();
                    } catch (Exception e4) {
                        System.out.println("Access PreparedStatement Close Error");
                        e4.printStackTrace();
                    }
                }
            }
        } 
    }
    
    
    //delete a table which you choose to delete
  	public void deleteTable(String table){
  		try{
  			System.out.println("Delete table "+ table +"!");
  			
  			sql = conn.prepareStatement("delete from "+table);
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
    
    
  	//drop a table which you choose to drop
  	public void dropTable(String table){
  		try{
  			System.out.println("Drop table "+ table +"!");
  			
  			sql = (conn).prepareStatement("drop table "+ table);
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
}

	
