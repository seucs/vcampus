package Message;
import java.io.Serializable;

public class BookMessage implements Serializable {

	public BookMessage() {
		super();
		
	}
			public BookMessage(String code, String category, String bookname, String address, String author, String press,
			int total, int keep, int ordered, int borrowed, int available, String comment) {
		super();
		this.code = code;
		this.category = category;
		this.bookname = bookname;
		this.address = address;
		this.author = author;
		this.press = press;
		this.total = total;
		this.keep = keep;
		this.ordered = ordered;
		this.borrowed = borrowed;
		this.available = available;
		this.comment = comment;
	}

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
