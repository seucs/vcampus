package Message;
import java.io.Serializable;

public class CourseMessage implements Serializable {
	//course_time course_teacher course_id course_addr course_day course_name course_exam_time course_exam_addr
	private String course_time;
	private String course_teacher;
	private String course_id;
	private String course_addr;
	private String course_day;
	private String course_name;
	private String course_exam_time;
	private String course_exam_addr;

	public String getCourse_time() {
		return course_time;
	}

	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_addr() {
		return course_addr;
	}

	public void setCourse_addr(String course_addr) {
		this.course_addr = course_addr;
	}

	public String getCourse_day() {
		return course_day;
	}

	public void setCourse_day(String course_day) {
		this.course_day = course_day;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_exam_time() {
		return course_exam_time;
	}

	public void setCourse_exam_time(String course_exam_time) {
		this.course_exam_time = course_exam_time;
	}

	public String getCourse_exam_addr() {
		return course_exam_addr;
	}

	public void setCourse_exam_addr(String course_exam_addr) {
		this.course_exam_addr = course_exam_addr;
	}
}
