package DAO;
import java.sql.*;
import java.sql.Connection;
import java.util.*;
import Message.*;
import Message.*;



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
	private CourseDAO course = new CourseDAO();
	private ExamDAO exam = new ExamDAO();
	private PersonDAO person = new PersonDAO();
	private CompetitionDAO competition = new CompetitionDAO();
	private CompetitorDAO competitor = new CompetitorDAO();
	private ClassgroupDAO classgroup = new ClassgroupDAO();
	private FriendDAO friend = new FriendDAO();
	
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
	
	public CourseDAO getCourseDAO() {
		return course;
	}
	
	public ExamDAO getExamDAO() {
		return exam;
	}
	
	public PersonDAO getPersonDAO() {
		return person;
	}
	
	public CompetitionDAO getCompetitionDAO() {
		return competition;
	}
	
	public CompetitorDAO getCompetitorDAO() {
		return competitor;
	}
	
	public ClassgroupDAO getClassgroupDAO() {
		return classgroup;
	}
	
	public FriendDAO getFriendDAO() {
		return friend;
	}
	
	
	
	
	//Main Function
    public static void main(String[] args){
    	DataAccessObject dao = new DataAccessObject();
    	dao.getConn();
    	
    	
    	
    	
    	
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
            String url1 = "jdbc:Access://database/database.accdb";
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
            course.setConn(conn);
            exam.setConn(conn);
            person.setConn(conn);
            competition.setConn(conn);
            competitor.setConn(conn);
            classgroup.setConn(conn);
            friend.setConn(conn);
            
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
  	
  	//delete Table Information
  	public void deleteTableInformation(String table, String column, String x)
  	{
  		try{
  			System.out.println("Delete Table information!");
  			System.out.println("删除 表 "+table+" 中  "+column+" = "+x+" 的数据！");
          	
          	sql = conn.prepareStatement("DELETE FROM "+ table +" WHERE "+ column +" = '"+ x +"'");
            sql.executeUpdate();
      
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	
}

	
