package Message;
import java.io.Serializable;

public class PersonMessage implements Serializable {
	//Name Onecard Number Race Sex Department Major Entrancedate Money Identity 
	private String name;
	private String onecard;
	private String number;
	private String race;
	private String sex;
	private String department;
	private String major;
	private String entrancedate;
	private double money;
	private String coursemanager;
	private String librarymanager;
	private String shopmanager;
	private String supermanager;
	private String icon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOnecard() {
		return onecard;
	}
	public void setOnecard(String onecard) {
		this.onecard = onecard;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEntrancedate() {
		return entrancedate;
	}
	public void setEntrancedate(String entrancedate) {
		this.entrancedate = entrancedate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCoursemanager() {
		return coursemanager;
	}
	public void setCoursemanager(String coursemanager) {
		this.coursemanager = coursemanager;
	}
	public String getLibrarymanager() {
		return librarymanager;
	}
	public void setLibrarymanager(String librarymanager) {
		this.librarymanager = librarymanager;
	}
	public String getShopmanager() {
		return shopmanager;
	}
	public void setShopmanager(String shopmanager) {
		this.shopmanager = shopmanager;
	}
	public String getSupermanager() {
		return supermanager;
	}
	public void setSupermanager(String supermanager) {
		this.supermanager = supermanager;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
