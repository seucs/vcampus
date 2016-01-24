package Message;
import java.io.Serializable;

public class ShopMessage implements Serializable {
	
	//Code Category Goodsname Quantity Price Seller Telephone Status Picture Comment 
			private String code;
			private String category;
			private String goodsname;
			private int quantity;
			private double price;
			private String seller;
			private String telephone;
			private String status;
			private String picture;
			private String comment;
			
			public void setCode(String code) 
			{
				this.code = code;
			}
			
			public String getCode() 
			{
				return code;
			}

			public void setCategory(String category) 
			{
				this.category = category;
			}
			
			public String getCategory() 
			{
				return category;
			}
			
			public void setGoodsname(String goodsname) 
			{
				this.goodsname = goodsname;
			}
			
			public String getGoodsname() 
			{
				return goodsname;
			}
			
			public void setQuantity(int quantity) 
			{
				this.quantity = quantity;
			}
			
			public int getquantity() 
			{
				return quantity;
			}
			
			public void setPrice(double price) 
			{
				this.price = price;
			}
			
			public double getPrice() 
			{
				return price;
			}
			
			public void setSeller(String seller) 
			{
				this.seller = seller;
			}
			
			public String getSeller() 
			{
				return seller;
			}
			
			public void setTelephone(String telephone) 
			{
				this.telephone = telephone;
			}
			
			public String getTelephone() 
			{
				return telephone;
			}
			
			public void setStatus(String status) 
			{
				this.status = status;
			}
			
			public String getStatus() 
			{
				return status;
			}
			
			public void setPicture(String picture) 
			{
				this.picture = picture;
			}
			
			public String getPicture() 
			{
				return picture;
			}
			
			public void setComment(String comment) 
			{
				this.comment = comment;
			}
			
			public String getComment() 
			{
				return comment;
			}

}
