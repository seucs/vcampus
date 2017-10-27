package AdmOffice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAO.DataAccessObject;
import Message.CourseMessage;
import Message.ExamMessage;
import PowfulPanel.SuperTable;

public class SelectCoursePanel extends JPanel {
	private DataAccessObject dataAccessObject = new DataAccessObject();
	private HashMap<String, SelectButton> selectBtnMap = new HashMap<String, SelectButton>();
	private InquirePanel inquirePanel;
	private SuperTable select_table;

	public SelectCoursePanel(InquirePanel inquirePanel) {

		this.inquirePanel = inquirePanel;
		this.setBackground(Color.white);
		this.setLayout(null);

		// 全部课程信息获取
		ArrayList<CourseMessage> allCourMsgArr = dataAccessObject.getCourseDAO().getAllCourseMessage();
		int course_num = 0;
		for (CourseMessage temp_course : allCourMsgArr) {
			if (course_num < Integer.parseInt(temp_course.getCourse_id())) {
				course_num = Integer.parseInt(temp_course.getCourse_id());
			}
		}
		select_table = new SuperTable(course_num, 5);
		select_table.setLocation(30, 20);
		select_table.setCellSize(170, 30);
		select_table.setColumnWidthSize(1, 70);
		select_table.setColumnWidthSize(2, 320);
		select_table.setColumnWidthSize(3, 150);
		select_table.setColumnWidthSize(4, 120);
		select_table.setTableHeadHeight(40);
		String[] btn_name = new String[course_num];
		for (int i = 0; i < course_num; i++) {
			btn_name[i] = "选择";
		}
		select_table.setButtonColumn(4, btn_name);

		// 选课按钮数组获取
		for (int i = 0; i < course_num; i++) {
			selectBtnMap.put(i + 1 + "", new SelectButton(i + 1 + "", select_table.ButtonArray.get(i).get(4)));
		}
		select_table.setTextTableHead(new String[] { "课程", "教师", "上课时间", "上课地点", "选课情况" });

		// 选课表格生成
		for (CourseMessage temp_course : allCourMsgArr) {
			int row = Integer.parseInt(temp_course.getCourse_id()) - 1;
			String time = select_table.getTextTableCell(row, 2);
			if (time == null) {
				select_table.setTextTableCell(row, 0, temp_course.getCourse_name());
				select_table.setTextTableCell(row, 1, temp_course.getCourse_teacher());
				time = temp_course.getCourse_day() + " " + temp_course.getCourse_time() + " ";
				select_table.setTextTableCell(row, 2, time);
				select_table.setTextTableCell(row, 3, temp_course.getCourse_addr());
			} else {
				time += temp_course.getCourse_day() + " " + temp_course.getCourse_time() + " ";
				select_table.setTextTableCell(row, 2, time);
			}
		}
		this.add(select_table);

		// 个人选课信息获取
		ArrayList<ExamMessage> myCourMsgArr = dataAccessObject.getExamDAO().queryExamMessage("student_id", "09013125");
		for (ExamMessage myCour : myCourMsgArr) {
			selectBtnMap.get(myCour.getStudent_course()).ChangeButton();
		}

	}

	public void RepaintInquirePanel() {
		inquirePanel.handleSchedule();
		inquirePanel.handleGrade();
		inquirePanel.handleExam();
	}
	
	public void judgeSelect(String id) {
		SuperTable superTable = inquirePanel.getSuperTable();
		HashMap<String, Integer> day_map = new HashMap<String, Integer>() {
			{
				put("星期一", 0);
				put("星期二", 1);
				put("星期三", 2);
				put("星期四", 3);
				put("星期五", 4);
			}
		};

		HashMap<String, Integer> time_map = new HashMap<String, Integer>() {
			{
				put("1", 0);
				put("3", 1);
				put("6", 2);
				put("8", 3);
				put("11", 4);
			}
		};
			
	}

	class SelectButton {
		final private String course_id;
		final private JButton jButton;

		public SelectButton(String course_id, JButton jButton) {
			this.jButton = jButton;
			this.course_id = course_id;
			jButton.setText("选择");
			jButton.setBackground(new Color(35, 164, 231));
			jButton.setForeground(Color.WHITE);
			jButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (SelectButton.this.jButton.getText().equals("选择")) {
						dataAccessObject.getExamDAO().addExamContent("09013125", "朴智新", "213130798", "100", SelectButton.this.course_id);
						JOptionPane.showMessageDialog(null, "选课成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						dataAccessObject.getExamDAO().deleteExamMessage("student_course", SelectButton.this.course_id,"student_id","09013125");
						JOptionPane.showMessageDialog(null, "退选成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					}
					SelectButton.this.ChangeButton();
					SelectCoursePanel.this.RepaintInquirePanel();
				}
			});
		}

		public void ChangeButton() {
			if (jButton.getText().equals("选择")) {
				jButton.setText("退选");
				jButton.setBackground(new Color(240, 233, 204));
				jButton.setForeground(Color.BLACK);
			} else {
				jButton.setText("选择");
				jButton.setBackground(new Color(35, 164, 231));
				jButton.setForeground(Color.WHITE);
			}
		}

		public String getCourse_id() {
			return course_id;
		}
	}

}
