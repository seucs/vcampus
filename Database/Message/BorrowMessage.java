package Message;
import java.io.Serializable;

public class BorrowMessage implements Serializable {
	
			//onecard studentnumber name code bookname author press borrowday returnday timelimit status
			private String onecard;
			private String studentnumber;
			private String name;
			private String code;
			private String bookname;
			private String author;
			private String press;
			private String borrowday;
			private String returnday;
			private int timelimit;
			private String status;
			
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

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

}
