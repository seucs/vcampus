package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ShopDAO {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement sql = null;
	private static ResultSetMetaData rsmd = null;

	
	public void setConn(Connection c)
	{
		this.conn=c;
	}
	
	//create table Shop
  	public void createTableShop(){
  		try{
  			System.out.println("Create table Shop!");
  			
  			sql = conn.prepareStatement("create table Shop(ID int AUTO_INCREMENT PRIMARY KEY, Category varchar(255), Goodsname varchar(255), Quantity int, Price )");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
	
	
	
}
