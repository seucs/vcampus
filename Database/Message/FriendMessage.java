package Message;
import java.io.Serializable;

public class FriendMessage implements Serializable {
	
	//studentnumber friendnumber
	private String studentnumber;
	private String friendnumber;
	
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getFriendnumber() {
		return friendnumber;
	}
	public void setFriendnumber(String friendnumber) {
		this.friendnumber = friendnumber;
	}
	
	
}
