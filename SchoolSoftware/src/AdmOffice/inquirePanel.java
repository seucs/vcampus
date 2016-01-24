package AdmOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.DataAccessObject;
import Message.CompetitionMessage;
import Message.CompetitorMessage;
import Message.CourseMessage;
import Message.ExamMessage;
import PowfulPanel.SuperTable;

public class InquirePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel mainInquirePanel = new JPanel();
	private InquireButton scheduleButton = new InquireButton(new ImageIcon("images/schedule.png"));
	private InquireButton onecardButton = new InquireButton(new ImageIcon("images/onecard.png"));
	private InquireButton gradeButton = new InquireButton(new ImageIcon("images/grade.png"));
	private InquireButton examButton = new InquireButton(new ImageIcon("images/exam.png"));
	private InquireButton compeButton = new InquireButton(new ImageIcon("images/contest.png"));
	private DataAccessObject dataAccessObject = new DataAccessObject();
	private SuperTable schdule_table = null;
	private SuperTable grade_table = null;
	private SuperTable exam_table = null;
	private SuperTable contest_table = null;

	public InquirePanel() {

		this.setLayout(null);
		mainInquirePanel.setBounds(0, 0, 900, 700);
		mainInquirePanel.setBackground(Color.WHITE);
		mainInquirePanel.setLayout(null);
		this.add(mainInquirePanel);

		dataAccessObject.getConn();
		initScheduleButton();
		initOnecardButton();
		initGradeButton();
		initExamButton();
		initCompeButton();
	}

	public void initScheduleButton() {
		scheduleButton.setLocation(180, 50);
		scheduleButton.initLabel("课程安排");
		mainInquirePanel.add(scheduleButton);

		schdule_table = new SuperTable(3, 5);
		schdule_table.setCellSize(165, 190);
		schdule_table.setTableHeadHeight(40);
		schdule_table.setTextTableHead(new String[] { "星期一", "星期二", "星期三", "星期四", "星期五" });
		schdule_table.setRowHeightSize(2, 100);
		schdule_table.setLocation(30, 20);
		handleSchedule();
		scheduleButton.getJumpPanel().add(schdule_table);
	}

	public void handleSchedule() {
		schdule_table.setTextTableAll(new String[3][5]);

		ArrayList<ExamMessage> examMsgArr = dataAccessObject.getExamDAO().queryExamMessage("student_id", "09013125");
		ArrayList<CourseMessage> courMsgArr = new ArrayList<>();
		ArrayList<CourseMessage> tempCourMsgArr = new ArrayList<>();

		for (ExamMessage exam_temp : examMsgArr) {
			tempCourMsgArr = dataAccessObject.getCourseDAO().queryCourseMessage("course_id",
					exam_temp.getStudent_course());
			for (CourseMessage cour_temp : tempCourMsgArr) {
				courMsgArr.add(cour_temp);
			}
		}
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

		for (CourseMessage cour_temp : courMsgArr) {
			int last1 = cour_temp.getCourse_time().lastIndexOf(']') + 1;
			int last2 = cour_temp.getCourse_time().lastIndexOf('-');
			int col = day_map.get(cour_temp.getCourse_day());
			int row2 = time_map.get(cour_temp.getCourse_time().substring(last1, last2));

			String pre_celltext = schdule_table.getTextTableCell(row2 / 2, col);
			if (pre_celltext == null) {
				pre_celltext = "";
			}
			String new_celltext = cour_temp.getCourse_name() + "<br>" + cour_temp.getCourse_time() + "<br>"
					+ cour_temp.getCourse_addr() + "<br>";
			if (row2 % 2 != 0) {
				schdule_table.setTextTableCell(row2 / 2, col, pre_celltext + new_celltext);
			} else {
				schdule_table.setTextTableCell(row2 / 2, col, new_celltext + pre_celltext);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (schdule_table.getTextTableCell(i, j) == null) {
					continue;
				}
				schdule_table.setTextTableCell(i, j,
						"<html><tr><td align='center'>" + schdule_table.getTextTableCell(i, j) + "</td></tr></html>");
			}
		}

	}

	public void initOnecardButton() {
		onecardButton.setLocation(480, 50);
		onecardButton.initLabel("一卡通余额");
		mainInquirePanel.add(onecardButton);

	}

	public void initGradeButton() {
		gradeButton.setLocation(20, 300);
		gradeButton.initLabel("成绩查询");
		mainInquirePanel.add(gradeButton);
		this.handleGrade();

	}

	public void handleGrade() {
		if (grade_table != null) {
			grade_table.setVisible(false);
			grade_table.removeAll();
		}
		ArrayList<ExamMessage> examMsgArr = dataAccessObject.getExamDAO().queryExamMessage("student_id", "09013125");
		ArrayList<CourseMessage> courMsgArr = new ArrayList<>();
		for (ExamMessage exam_temp : examMsgArr) {
			courMsgArr.add(dataAccessObject.getCourseDAO()
					.queryCourseMessage("course_id", exam_temp.getStudent_course()).get(0));
		}

		grade_table = new SuperTable(examMsgArr.size(), 5);
		grade_table.setLocation(30, 20);
		grade_table.setCellSize(165, 30);
		grade_table.setTableHeadHeight(40);
		grade_table.setTextTableHead(new String[] { "课程", "教师", "考试时间", "考试地点", "考试成绩" });
		for (int i = 0; i < examMsgArr.size(); i++) {
			grade_table.setTextTableCell(i, 0, courMsgArr.get(i).getCourse_name());
			grade_table.setTextTableCell(i, 1, courMsgArr.get(i).getCourse_teacher());
			grade_table.setTextTableCell(i, 2, courMsgArr.get(i).getCourse_exam_time());
			grade_table.setTextTableCell(i, 3, courMsgArr.get(i).getCourse_exam_addr());
			grade_table.setTextTableCell(i, 4, examMsgArr.get(i).getStudent_grade());
		}
		gradeButton.getJumpPanel().add(grade_table);
	}

	public void initExamButton() {
		examButton.setLocation(320, 300);
		examButton.initLabel("考试安排");
		mainInquirePanel.add(examButton);
		handleExam();
	}

	public void handleExam() {
		if (exam_table != null) {
			exam_table.setVisible(false);
			exam_table.removeAll();
		}
		ArrayList<ExamMessage> examMsgArr = dataAccessObject.getExamDAO().queryExamMessage("student_id", "09013125");
		ArrayList<CourseMessage> courMsgArr = new ArrayList<>();
		for (ExamMessage exam_temp : examMsgArr) {
			courMsgArr.add(dataAccessObject.getCourseDAO()
					.queryCourseMessage("course_id", exam_temp.getStudent_course()).get(0));
		}
		exam_table = new SuperTable(examMsgArr.size(), 4);
		exam_table.setLocation(30, 20);
		exam_table.setCellSize(200, 30);
		exam_table.setTableHeadHeight(40);
		exam_table.setTextTableHead(new String[] { "课程", "教师", "考试时间", "考试地点" });
		for (int i = 0; i < examMsgArr.size(); i++) {
			exam_table.setTextTableCell(i, 0, courMsgArr.get(i).getCourse_name());
			exam_table.setTextTableCell(i, 1, courMsgArr.get(i).getCourse_teacher());
			exam_table.setTextTableCell(i, 2, courMsgArr.get(i).getCourse_exam_time());
			exam_table.setTextTableCell(i, 3, courMsgArr.get(i).getCourse_exam_addr());
		}
		examButton.getJumpPanel().add(exam_table);
	}

	public void initCompeButton() {
		compeButton.setLocation(620, 300);
		compeButton.initLabel("竞赛查询");
		mainInquirePanel.add(compeButton);
		handleContest();

	}

	public void handleContest() {
		if (contest_table != null) {
			contest_table.setVisible(false);
			contest_table.removeAll();
		}
		ArrayList<CompetitorMessage> competitorMsgArr = new ArrayList<>();
		ArrayList<CompetitorMessage> myContestMsgArr = dataAccessObject.getCompetitorDAO()
				.queryCompetitorMessage("Capation", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			competitorMsgArr.add(myContest);
		}
		myContestMsgArr = dataAccessObject.getCompetitorDAO().queryCompetitorMessage("teammate1", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			competitorMsgArr.add(myContest);
		}
		myContestMsgArr = dataAccessObject.getCompetitorDAO().queryCompetitorMessage("teammate2", "09013125");
		for (CompetitorMessage myContest : myContestMsgArr) {
			competitorMsgArr.add(myContest);
		}

		contest_table = new SuperTable(competitorMsgArr.size(), 6);
		contest_table.setCellSize(120, 40);
		contest_table.setColumnWidthSize(0, 280);
		contest_table.setColumnWidthSize(2, 100);
		contest_table.setColumnWidthSize(3, 100);
		contest_table.setColumnWidthSize(4, 100);
		contest_table.setTableHeadHeight(40);
		contest_table.setTextTableHead(new String[] { "竞赛名称", "竞赛时间", "队长", "队员1", "队员2", "获奖情况" });
		
		contest_table.setLocation(30, 20);
		ArrayList<CompetitionMessage> CompMsgArr = new ArrayList<>();
		for (CompetitorMessage myContest : competitorMsgArr) {
			CompMsgArr.add(dataAccessObject.getCompetitionDAO()
					.queryCompetitionMessage("competition_id", myContest.getCompetition_id()).get(0));
		}
		for (int i = 0; i < competitorMsgArr.size(); i++) {
			contest_table.setTextTableCell(i, 0, CompMsgArr.get(i).getCompetition_name());
			contest_table.setTextTableCell(i, 1, CompMsgArr.get(i).getCompetition_time());
			contest_table.setTextTableCell(i, 2, competitorMsgArr.get(i).getCapation());
			contest_table.setTextTableCell(i, 3, competitorMsgArr.get(i).getTeammate1());
			contest_table.setTextTableCell(i, 4, competitorMsgArr.get(i).getTeammate2());
			contest_table.setTextTableCell(i, 5, competitorMsgArr.get(i).getAward());
		}

		compeButton.getJumpPanel().add(contest_table);
	}

	public void setMainInquirePanelVisitable(boolean judge) {
		this.mainInquirePanel.setVisible(judge);
	}

	class InquireButton extends JButton {
		private static final long serialVersionUID = 1L;
		private JPanel jumpPanel = new JPanel();
		private JLabel jLabel = new JLabel();

		public InquireButton(ImageIcon icon) {
			super();
			this.setIcon(icon);
			this.setContentAreaFilled(false);
			this.setFocusPainted(false);
			this.setLayout(null);
			this.setBorderPainted(false);
			this.setSize(this.getPreferredSize());
			this.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					jumpPanel.setVisible(true);
					InquirePanel.this.setMainInquirePanelVisitable(false);
				}
			});

			jumpPanel.setBounds(0, 0, 900, 700);
			jumpPanel.setBackground(Color.WHITE);
			jumpPanel.setVisible(false);
			jumpPanel.setLayout(null);
			InquirePanel.this.add(jumpPanel);

			JButton jButton = new JButton("返回");
			jButton.setFont(new Font("微软雅黑", Font.PLAIN, 28));
			jButton.setSize(600, 40);
			jButton.setLocation(150, 565);
			jButton.setBorderPainted(false);
			jButton.setFocusPainted(false);
			jButton.setForeground(Color.WHITE);
			jButton.setBackground(new Color(35, 164, 231));
			jButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jumpPanel.setVisible(false);
					InquirePanel.this.setMainInquirePanelVisitable(true);
				}
			});
			jumpPanel.add(jButton);

		}

		public JPanel getJumpPanel() {
			return jumpPanel;
		}

		public void initLabel(String btn_name) {
			jLabel.setText(btn_name);
			jLabel.setForeground(new Color(35, 164, 231));
			jLabel.setBackground(Color.WHITE);
			jLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			jLabel.setSize(jLabel.getPreferredSize());
			jLabel.setLocation(this.getLocation().x + this.getSize().width / 2 - jLabel.getSize().width / 2,
					this.getLocation().y + this.getSize().height);
			InquirePanel.this.mainInquirePanel.add(jLabel);
		}

	}

	public SuperTable getSuperTable() {
		return schdule_table;
	}
}
