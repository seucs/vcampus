package DAO;

import Message.ShopMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Message.ShopMessage;

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
  			
  			sql = conn.prepareStatement("create table Shop(ID int AUTO_INCREMENT PRIMARY KEY, Code varchar(255), Category varchar(255), Goodsname varchar(255), Quantity int, Price double, Seller varchar(255), Telephone varchar(255), Status varchar(255), Picture varchar(255), Comment varchar(255))");
            sql.executeUpdate();
            
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
	
  	//add Shop Information
  	//Code Category Goodsname Quantity Price Seller Telephone Status Picture Comment 
  	public void addShopInformation(String code, String category, String goodsname, int quantity, double price, String seller, String telephone, String status, String picture, String comment){
          try{
          	System.out.println("Add Shop Information:");
          	
          	sql = conn.prepareStatement("insert into Shop (Code, Category, Goodsname, Quantity, Price, Seller, Telephone, Status, Picture, Comment) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             
          	sql.setString(1, code);	
          	sql.setString(2, category);	
          	sql.setString(3, goodsname);
          	sql.setInt(4, quantity);
          	sql.setDouble(5, price);
          	sql.setString(6, seller);
          	sql.setString(7, telephone);
          	sql.setString(8, status);
          	sql.setString(9, picture);
          	sql.setString(10, comment);

            sql.executeUpdate();
              
            //output
            System.out.print("商品编码: "+category);
            System.out.print("   商品类别: "+category);
            System.out.print("   商品名称: "+goodsname);
            System.out.print("   商品数量: "+quantity);
            System.out.print("   单价: "+price);
            System.out.print("   卖家: "+seller);
            System.out.print("   联系电话: "+telephone);
            System.out.print("   状态: "+status);
            System.out.print("   图片地址: "+picture);
            System.out.println("   备注: "+comment);
            
            
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	
  	//update Shop Information 
  	//Code Category Goodsname Quantity Price Seller Telephone Status Picture Comment 
  	public void updateShopInformation(String code, String category, String goodsname, int quantity, double price, String seller, String telephone, String status, String picture, String comment){
          try{
          	System.out.println("Update Shop Information:");
          	
          	sql = conn.prepareStatement("update Shop set Category = ? , Goodsname = ? , Quantity = ? , Price = ? , Seller = ? , Telephone = ? , Status = ? , Picture = ? , Comment = ? where code = ?");
            
          	sql.setString(1, category);	
          	sql.setString(2, goodsname);
          	sql.setInt(3, quantity);
          	sql.setDouble(4, price);
          	sql.setString(5, seller);
          	sql.setString(6, telephone);
          	sql.setString(7, status);
          	sql.setString(8, picture);
          	sql.setString(9, comment);
          	sql.setString(10, code);

            sql.executeUpdate();
              
          //output
            System.out.print("商品编码: "+category);
            System.out.print("   商品类别: "+category);
            System.out.print("   商品名称: "+goodsname);
            System.out.print("   商品数量: "+quantity);
            System.out.print("   单价: "+price);
            System.out.print("   卖家: "+seller);
            System.out.print("   联系电话: "+telephone);
            System.out.print("   状态: "+status);
            System.out.print("   图片地址: "+picture);
            System.out.println("   备注: "+comment);
               
          } catch(Exception e){
              e.printStackTrace();
          }
          System.out.println();
  	}
  	
  	//fuzzy query Shop information
  	public void queryShopinfo(String category, String goodsname){
  		try{
			System.out.println("Query Shop information!");
			System.out.println("查询包含 类别："+category+"  或 商品名称："+goodsname+"  的商品信息！");
          
			sql = conn.prepareStatement("select * from Shop where Category like '%"+category+"%' or Goodsname like '%"+goodsname+"%' ");
			rs = sql.executeQuery();
         
			while(rs.next()){   //if current statement is not the last one, loop
				String a = rs.getString("ID");
                String b = rs.getString("Code");    
                String c = rs.getString("Category");    
                String d = rs.getString("Goodsname");  
                String e = rs.getString("Quantity"); 
                String f = rs.getString("Price"); 
                String g = rs.getString("Seller"); 
                String h = rs.getString("Telephone"); 
                String i = rs.getString("Status"); 
                String j = rs.getString("Picture"); 
                String k = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   商品编码: "+b);
                System.out.print("   商品类别: "+c);
                System.out.print("   商品名称: "+d);
                System.out.print("   数量: "+e);
                System.out.print("   单价: "+f);
                System.out.print("   卖家: "+g);
                System.out.print("   联系电话: "+h);
                System.out.print("   状态: "+i);
                System.out.print("   图片地址: "+j);
                System.out.println("   备注: "+k);
          	}
              
			} catch(Exception e){
            e.printStackTrace();
		}
		System.out.println();		
    }
  	
  	
  	//fuzzy query Shop message
  	//Code Category Goodsname Quantity Price Seller Telephone Status Picture Comment 
  	public ArrayList<ShopMessage> queryShopMessage(String column, String x){
  		ArrayList<ShopMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Fuzzy Query!");
            System.out.println("查询商品信息中 "+column+" = "+x+" 的数据！");
            
  			sql = conn.prepareStatement("select * from Shop where "+ column +" like '%"+ x +"%' ");
  			rs = sql.executeQuery();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	ShopMessage shopmessage = new ShopMessage();
            	shopmessage.setCode(rs.getString("Code")); 
            	shopmessage.setCategory(rs.getString("Category"));    
            	shopmessage.setGoodsname(rs.getString("Goodsname"));  
            	shopmessage.setQuantity(rs.getInt("Quantity")); 
            	shopmessage.setPrice(rs.getDouble("Price")); 
            	shopmessage.setSeller(rs.getString("Seller")); 
            	shopmessage.setTelephone(rs.getString("Telephone")); 
            	shopmessage.setStatus(rs.getString("Status")); 
            	shopmessage.setPicture(rs.getString("Picture")); 
            	shopmessage.setComment(rs.getString("Comment")); 
            	
            	arraylist.add(shopmessage);
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	
  	//category query
  	//Life, Study, Secondhandbook, Electron, Other
  	public ArrayList<ShopMessage> queryShopCategory(String x, boolean life,boolean study, boolean secondhandbook, boolean electron, boolean other){
  		ArrayList<ShopMessage> arraylist = new ArrayList<>();
  		try{
  			System.out.println("Category Query!");
            System.out.println("根据类别查询商品信息！");
            
            String Life, Study, Secondhandbook, Electron, Other;
            
            if(life)	Life = "life";
            else Life = "vanish";
            if(study)	Study = "study";
            else Study = "vanish";
            if(secondhandbook)	Secondhandbook = "secondhandbook";
            else Secondhandbook = "vanish";
            if(electron)	Electron = "electron";
            else Electron = "vanish";
            if(other)	Other = "other";
            else Other = "vanish";
            
  			sql = conn.prepareStatement("select * from Shop where Goodsname like '%"+ x +"%' and Category in (?,?,?,?,?)");
  			sql.setString(1, Life);
  			sql.setString(2, Study);
  			sql.setString(3, Secondhandbook);
  			sql.setString(4, Electron);
  			sql.setString(5, Other);
  			
  			rs = sql.executeQuery();
  			
            while(rs.next()){   //if current statement is not the last one, loop
            	ShopMessage shopmessage = new ShopMessage();
            	shopmessage.setCode(rs.getString("Code")); 
            	shopmessage.setCategory(rs.getString("Category"));    
            	shopmessage.setGoodsname(rs.getString("Goodsname"));  
            	shopmessage.setQuantity(rs.getInt("Quantity")); 
            	shopmessage.setPrice(rs.getDouble("Price")); 
            	shopmessage.setSeller(rs.getString("Seller")); 
            	shopmessage.setTelephone(rs.getString("Telephone")); 
            	shopmessage.setStatus(rs.getString("Status")); 
            	shopmessage.setPicture(rs.getString("Picture")); 
            	shopmessage.setComment(rs.getString("Comment")); 
            	
            	arraylist.add(shopmessage);
            	
            	String a = rs.getString("ID");
                String b = rs.getString("Code"); 
                String c = rs.getString("Category");
                String d = rs.getString("Goodsname");    
                String e = rs.getString("Quantity");  
                String f = rs.getString("Price"); 
                String g = rs.getString("Seller"); 
                String h = rs.getString("Telephone"); 
                String i = rs.getString("Status"); 
                String j = rs.getString("Picture"); 
                String k = rs.getString("Comment"); 
                
              //output
                System.out.print("编号: "+a);
                System.out.print("   商品编码: "+b);
                System.out.print("   商品类别: "+c);
                System.out.print("   商品名称: "+d);
                System.out.print("   数量: "+e);
                System.out.print("   单价: "+f);
                System.out.print("   卖家: "+g);
                System.out.print("   联系电话: "+h);
                System.out.print("   状态: "+i);
                System.out.print("   图片地址: "+j);
                System.out.println("   备注: "+k);
           
            	}
                
  			} catch(Exception e){
              e.printStackTrace();
  		}
  		
		return arraylist;
    }
  	
  	
  	//print Shop Information
  	public void printShopInfo(){
  		try{
  			System.out.println("Print Shop information:");
  			
  			sql = conn.prepareStatement("select * from Shop");
            rs = sql.executeQuery();
              
            //print Shop information
            while(rs.next()){   //if current statement is not the last one, loop
            	String a = rs.getString("ID");
                String b = rs.getString("Code");    
                String c = rs.getString("Category");    
                String d = rs.getString("Goodsname");  
                String e = rs.getString("Quantity"); 
                String f = rs.getString("Price"); 
                String g = rs.getString("Seller"); 
                String h = rs.getString("Telephone"); 
                String i = rs.getString("Status"); 
                String j = rs.getString("Picture"); 
                String k = rs.getString("Comment"); 
                
                //output
                System.out.print("编号: "+a);
                System.out.print("   商品编码: "+b);
                System.out.print("   商品类别: "+c);
                System.out.print("   商品名称: "+d);
                System.out.print("   数量: "+e);
                System.out.print("   单价: "+f);
                System.out.print("   卖家: "+g);
                System.out.print("   联系电话: "+h);
                System.out.print("   状态: "+i);
                System.out.print("   图片地址: "+j);
                System.out.println("   备注: "+k);
            	}
  			
  			} catch(Exception e){
              e.printStackTrace();
  			}
          	System.out.println();
  	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	//delete table Shop
  	public void deleteTableShop(){
  		try{
  			System.out.println("Delete table Shop!");
  			
  			sql = conn.prepareStatement("delete from Shop");
              sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	//drop table Shop
  	public void dropTableShop(){
  		try{
  			System.out.println("Drop table Shop!");
  			
  			sql = conn.prepareStatement("drop table Shop");
            sql.executeUpdate();
              
  		} catch(Exception e){
              e.printStackTrace();
  		}
  		System.out.println();
      }
  	
  	
  	
	
	
}
