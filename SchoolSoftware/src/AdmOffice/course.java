package AdmOffice;

public class Course {
	String coursenumber;
	String coursename;
	String teacher;
	String coursetime;
	String courseroom;
	String maxstu;
	String selectedstu;
	public Course() {
		
	}
	public Course(String[][] str,int i,int flag) {
		if(flag==1)
		{setcnumber(str[i][0]);
		setcname(str[i][1]);
		setcteacher(str[i][2]);
		setctime(str[i][3]);
		setcroom(str[i][4]);
		}
		else {
			setcname(str[i][0]);
			setcteacher(str[i][1]);
			setctime(str[i][2]);
			setcroom(str[i][3]);
			
		}
		
	}
	public Course(String number,String name,String Teacher,String time, String room,String max,String selected)
	{
		 setcnumber( number);
		 setcname(name);
		 setcteacher(Teacher);
		 setctime(time);
		 setcroom(room);
		 setmaxstu(max);
		selectedstu(selected);
	}
	public Course(String name){
		setcname(name);
		 setcnumber(null);
		
		 setcteacher(null);
		 setctime(null);
		 setcroom(null);
		 setmaxstu(null);
		selectedstu(null);
		
	}
	void getcourse(String[][] str,int i,int flag){
		if(flag==1)
		{str[i][0]=getcnumber();
		str[i][1]=getcname();
		str[i][2]=getcteacher();
		str[i][3]=getctime();
		str[i][4]=getcroom();
		}
		else {
			str[i][0]=getcname();
			str[i][1]=getcteacher();
			str[i][2]=getctime();
			str[i][3]=getcroom();
			
		}
		
	}
	void setcnumber(String x){coursenumber= x;}
	void setcname(String x){coursename= x;}
	void setcteacher(String x){teacher =x;}
	void setctime(String x){coursetime=x;}
	void setcroom(String x){courseroom= x;}
	void setmaxstu(String x){maxstu=x;}
	void selectedstu(String x){selectedstu=x;}
	String getcnumber(){return coursenumber;}
	String getcname(){return coursename;}
	String getcteacher(){return teacher;}
	String getctime(){return coursetime;}
	String getcroom(){return courseroom;}
	String getmaxstu(){return maxstu;}
	String gelectedstu(){return selectedstu;}
}
