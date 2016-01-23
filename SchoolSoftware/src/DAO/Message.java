package DAO;

public class Message {
	private String type;
	private int code;
	private Object data;
	
	public Message(String type, int code, Object data)
	{
		this.type=type;
		this.code=code;
		this.data=data;
	}
	
	
}


	class LoginMessage {
		//Name Onecard Studentnumber Password 
		private String name;
		private String onecard;
		private String studentnumber;
		private String password;
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setOnecard(String onecard)
		{
			this.onecard = onecard;
		}
		
		public String getOnecard()
		{
			return onecard;
		}
		
		public void setStudentnumber(String studentnumber)
		{
			this.studentnumber = studentnumber;
		}
		
		public String getStudentnumber()
		{
			return studentnumber;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}
		
		public String getPassword()
		{
			return password;
		}
		

	}


	
	class BookMessage {
		//Code Category Name Address Author Press Total Keep Ordered Borrowed Available Comment
		private String code;
		private String category;
		private String bookname;
		private String address;
		private String author;
		private String press;
		private int total;
		private int keep;
		private int ordered;
		private int borrowed;
		private int available;
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
		
		public void setBookname(String bookname)
		{
			this.bookname = bookname;
		}
		
		public String getBookname()
		{
			return bookname;
		}
		
		public void setAddress(String address)
		{
			this.address = address;
		}
		
		public String getAddress()
		{
			return address;
		}
		
		public void setAuthor(String author)
		{
			this.author = author;
		}
		
		public String getAuthor()
		{
			return author;
		}
		
		public void setPress(String press)
		{
			this.press = press;
		}
		
		public String getPress()
		{
			return press;
		}
		
		public void setTotal(int total)
		{
			this.total = total;
		}
		
		public int getTotal()
		{
			return total;
		}
		
		public void setKeep(int keep)
		{
			this.keep = keep;
		}
		
		public int getKeep()
		{
			return keep;
		}
		
		public void setOrdered(int ordered)
		{
			this.ordered = ordered;
		}
		
		public int getOrdered()
		{
			return ordered;
		}
		
		public void setBorrowed(int borrowed)
		{
			this.borrowed = borrowed;
		}
		
		public int getBorrowed()
		{
			return borrowed;
		}
		
		public void setAvailable(int available)
		{
			this.available = available;
		}
		
		public int getAvailable()
		{
			return available;
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

	
	
	class BorrowMessage {
		//onecard studentnumber name code bookname author press borrowday returnday timelimit 
		private String onecard;
		private String studentnumber;
		private String name;
		private String code;
		private String category;
		private String bookname;
		private String author;
		private String press;
		private String borrowday;
		private String returnday;
		private int timelimit;
		
		public void setOnecard(String onecard)
		{
			this.onecard = onecard;
		}
		
		public String getOnecard()
		{
			return onecard;
		}
		
		public void setStudentnumber(String studentnumber)
		{
			this.studentnumber = studentnumber;
		}
		
		public String getStudentnumber()
		{
			return studentnumber;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
		
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
		
		public void setBookname(String bookname)
		{
			this.bookname = bookname;
		}
		
		public String getBookname()
		{
			return bookname;
		}
		
		public void setAuthor(String author)
		{
			this.author = author;
		}
		
		public String getAuthor()
		{
			return author;
		}
		
		public void setPress(String press)
		{
			this.press = press;
		}
		
		public String getPress()
		{
			return press;
		}
		
		public void setBorrowday(String borrowday)
		{
			this.borrowday = borrowday;
		}
		
		public String getBorrowday()
		{
			return borrowday;
		}
		
		public void setReturnday(String returnday)
		{
			this.returnday = returnday;
		}
		
		public String getReturnday()
		{
			return returnday;
		}
		
		public void setTimelimit(int timelimit)
		{
			this.timelimit = timelimit;
		}
		
		public int getTimelimit()
		{
			return timelimit;
		}
	
	
	}

	
	
	class ChatMessage {
		//time(Time:yyyy-mm-dd hh:mm:ss), sender, recipient, content
		private String time;
		private String sender;
		private String recipient;
		private String content;
		
		public void setTime(String time)
		{
			this.time = time;
		}
		
		public String getTime()
		{
			return time;
		}
		
		public void setSender(String sender)
		{
			this.sender = sender;
		}
		
		public String getSender()
		{
			return sender;
		}
		
		public void setRecipient(String recipient)
		{
			this.recipient = recipient;
		}
		
		public String getRecipient()
		{
			return recipient;
		}
		
		public void setContent(String content)
		{
			this.content = content;
		}
		
		public String getContent()
		{
			return content;
		}
		
		
	}



	class ShopMessage {
		//商品名 价格 图片 卖家（学校/学生）
		
		
	}

	class TeachMessage {
		
		
		
	}
	
	

