package Library;
import javax.print.DocFlavor.STRING;




public class book {
	String booknumber;
	String bookname;
	String author;
	String press;
	String total;
	int Total;
	String rest;
	String[] brwperson;
	String[] brwstate;
	String remark;
	String location;
	public book(String bnumber,String bname,String bauthor,String bpress,String btotal,
			String brest,String bremark,String blocation) {
		booknumber=bnumber;
		bookname=bname;
		author=bauthor;
		press=bpress;
		total=btotal;
		rest=brest;
		remark=bremark;
		location=blocation;
		
		// TODO 自动生成的构造函数存根
	}
	public book() {
		// TODO 自动生成的构造函数存根
	}
	public void setBook(String bnumber,String bname,String bauthor,String bpress,String btotal,
			String brest,String bremark,String blocation) {
		booknumber=bnumber;
		bookname=bname;
		author=bauthor;
		press=bpress;
		total=btotal;
		rest=brest;
		remark=bremark;
		location=blocation;
		
	}
	public void setBook(String[][] x,int i) {
		booknumber=x[i][0];
		bookname=x[i][1];
		author=x[i][2];
		press=x[i][3];
		total=x[i][4];
		rest=x[i][5];
		remark=x[i][6];
		location=x[i][7];
		
	}
	public void setBook(String[] x) {
		booknumber=x[0];
		bookname=x[1];
		author=x[2];
		press=x[3];
		total=x[4];
		rest=x[5];
		remark=x[6];
		location=x[7];
		
	}
	public book(String[] x) {
		booknumber=x[0];
		bookname=x[1];
		author=x[2];
		press=x[3];
		total=x[4];
		rest=x[5];
		remark=x[6];
		location=x[7];
		

	}
	public book(String[][] x,int i) {
		booknumber=x[i][0];
		bookname=x[i][1];
		author=x[i][2];
		press=x[i][3];
		total=x[i][4];
		rest=x[i][5];
		remark=x[i][6];
		location=x[i][7];
		

	}
	public void getbook(String[] x) {
		x[0]=booknumber;
		x[1]=bookname;
		x[2]=author;
		x[3]=press;
		x[4]=total;
		x[5]=rest;
		x[6]=remark;
		x[7]=location;
		
	}
	public void getbook(String[][] x,int i) {
		x[i][0]=booknumber;
		x[i][1]=bookname;
		x[i][2]=author;
		x[i][3]=press;
		x[i][4]=total;
		x[i][5]=rest;
		x[i][6]=remark;
		x[i][7]=location;
		
	}

}
