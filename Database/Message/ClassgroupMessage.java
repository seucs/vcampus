package Message;
import java.io.Serializable;

public class ClassgroupMessage implements Serializable {
	//studentnumber Class
	private String studentnumber;
	private String class_id;
	
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	
}
